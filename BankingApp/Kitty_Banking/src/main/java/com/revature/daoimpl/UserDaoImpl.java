package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.UsersDao; //different class
import com.revature.util.ConnFactory;

public class UserDaoImpl implements UsersDao {
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createUsers(String userName, String userPASS, int userID, int ACCOUNTBALANCE) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO ACCOUNTUSER VALUES(?,?,USERSEQ.nextval)"; // replace with insert sql query
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userName);
		ps.setString(2, userPASS);

		ps.executeUpdate();
	}
	
	public ArrayList<User> getAllUsers() throws SQLException {
		ArrayList<User> userList = new ArrayList<User>();
        Connection conn = cf.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNTUSER");
        User users = null;
        while(rs.next()) {
            users = new User(rs.getString(1), rs.getString(2), rs.getInt(3));
            userList.add(users);
        }
        return userList;
	}

//	public ArrayList<User> getAllUsers(){
//		ArrayList <User> users= new ArrayList<User>();
//		
//		return users;
//	}

	public void createAccount(int UserID ) throws SQLException {
	Connection conn = cf.getConnection();
	String addAccountSql = "insert into BankAccount values (0,AccSeq.nextval,?) ";
	PreparedStatement ps = conn.prepareStatement(addAccountSql);
	ps.setInt(1, UserID );
	ps.executeUpdate();
	}

	
	
	
	public void deleteAccount(int BANKACCOUNTID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call spDelete(?)"; 
		//PreparedStatement ps = conn.prepareStatement(sql);
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, BANKACCOUNTID);
		call.execute();
	}
	
	public void depositBalance( int amount, int accountID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call spDeposit(?,?)"; 
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, accountID);
		call.setInt(2, amount);
		call.execute();
	}
	


	
	
	public void withdrawBalance(int amount, int accountID) throws SQLException {
		Connection conn = cf.getConnection();
		//String sql = "spWithdraw(?,?)"; 
		//PreparedStatement ps = conn.prepareStatement(sql);
		String sql = "{call spWithdraw(?,?)"; 
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, accountID);
		call.setInt(2, amount);
		call.execute();
	}

	public void loginUsers(String userName, String userPASS, int userID, int ACCOUNTBALANCE) throws SQLException {
		// TODO Auto-generated method stub
		
	}
//change void to array list?
	public ArrayList<Account> getAccounts(int userID) throws SQLException {
		ArrayList<Account> accounts = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM BANKACCOUNT where USERID=?"; 
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, userID);
        ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Account acc = new Account(rs.getInt(2),rs.getInt(1),rs.getInt(3));
			accounts.add(acc);
		}
		return accounts;
		
	
	}
	
	
	
	
}
