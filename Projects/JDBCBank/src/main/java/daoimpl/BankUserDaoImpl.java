package daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BankUserDao;
import members.Account;
import members.Customer;
import utilities.ConnFactory;


public class BankUserDaoImpl implements BankUserDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	//creates a new user and 1 account with $100 in it
	@Override
	public boolean createNewUser(String username, String password) {
		Connection conn= cf.getConnection();
		String sql="{CALL NEW_USER(?,?)";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1,username);
			call.setString(2, password);
			call.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	//checks if there is a bank user in the database with matching password
	@Override
	public boolean userAuthentication(String usr, String pword) {
		String pwordFromDatabase="";
		Connection conn = cf.getConnection();
		String sql = "SELECT pasword FROM BANK_USERS WHERE USERNAME=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usr);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				pwordFromDatabase =rs.getString(1);
				if(pword.equals(pwordFromDatabase)) {
					  return true;
				  }
				else {
					return false;
				}
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	//Gets bank accounts associated with the username given
	@Override
	public ArrayList<Account> getBankAccounts(String username)  {
		ArrayList<Account> userList = new ArrayList<Account> ();
		Connection conn= cf.getConnection();
		String sql ="select bankaccount_id,balance from bank_account where bankaccount_id in ( select bankaccount_id from user_account where user_id = (select user_id from bank_users where username =?))"; 
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery(); 
			Account a =null;
			while(rs.next()) {
				a=new Account(rs.getInt(1), rs.getDouble(2));
				userList.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		return userList;
	}
	//checks if the account # exists
	@Override
	public boolean acctExists(int acctNum) {
		Connection conn = cf.getConnection();
		String sql = "SELECT bankaccount_id FROM bank_account WHERE bankaccount_id=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acctNum);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	//returns the account of the one given
	@Override
	public Account getBankAccount(int acctNum) {
		Account acct =null;
		Connection conn= cf.getConnection();
		String sql ="select bankaccount_id,balance from bank_account where bankaccount_id =?"; 
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acctNum);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				acct=new Account(rs.getInt(1), rs.getDouble(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		return acct;
	}
	
	//updates the account information in database
	@Override
	public boolean updateBalance(Account a) {
		Connection conn =cf.getConnection();
		String sql= "CALL BALANCE_UPDATE(?,?)";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1,a.getAcctNum());
			call.setDouble(2, a.getBalance()); 
			call.executeUpdate();
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	//deletes account "a" from database
	@Override
	public boolean deleteAcct(Account a) {
		Connection conn =cf.getConnection();
		String sql= "CALL DELETE_ACCT(?)";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1,a.getAcctNum());
			call.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//makes a new account associated with the Customer "c"
	@Override
	public boolean makeNewAcct(Customer c) {
		Connection conn =cf.getConnection();
		String sql= "CALL NEW_ACCT(?)";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1,c.getUserid());
			call.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//gets userid from database of a customer "c"
	@Override
	public int getUserID(Customer c) { 
		Connection conn = cf.getConnection();
		String sql = "SELECT user_id FROM bank_users WHERE username=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getUsername());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				c.setUserid(rs.getInt(1));
				return c.getUserid();
			}
			else{
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	@Override
	public boolean userAlreadyExists(String username) {
		Connection conn = cf.getConnection();
		String sql = "SELECT username FROM BANK_USERS WHERE USERNAME like ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()==false){
				return false;
			}
			else{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	

}
