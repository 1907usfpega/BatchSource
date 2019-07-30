package hw2.hollander.ben.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hw2.hollander.ben.dao.AccountManagementDao;
import hw2.hollander.ben.exceptions.AccountExists;
import hw2.hollander.ben.exceptions.AccountNotEmptyException;
import hw2.hollander.ben.exceptions.BadValueException;
import hw2.hollander.ben.exceptions.WrongCredentialsException;
import hw2.hollander.ben.util.ConnFactory;
import hw2.hollander.ben.main.*;

public class AccountManagementDaoImpl implements AccountManagementDao {
	public static ConnFactory cf= ConnFactory.getInstance();
	
	@Override
	public void Create(String usr, String pswd) throws AccountExists, SQLException, BadValueException, WrongCredentialsException {
		Connection conn= cf.getConnection();
		String sql= "{ call acct_creation(?, ?)";
		CallableStatement call= conn.prepareCall(sql);
		int hash = (usr+pswd).hashCode();
		call.setInt(1, hash);
		call.setString(2,  usr);
		try {
			call.execute();
			System.out.println("Account created"); //get acct number & sysout
			getAccountNumber(usr, pswd);
		}
		catch(SQLException e) {
			System.out.println("This account already exists");
			LoginMenu.Menu();
		}
	}

	@Override
	public void Delete(int acctid, int hash) throws AccountNotEmptyException, SQLException {
		Connection conn= cf.getConnection();
		//TODO verify acct belongs to them
		boolean go = AccountOwner(hash, acctid);
		//END TODO
		if (go==true) {
		String sql= "{ call acct_delete(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, String.valueOf(acctid));
		try {
			call.execute();
			System.out.println("Account deleted");
		}
		catch(SQLException e) {
			try {
				throw new AccountNotEmptyException();
			}
			catch(AccountNotEmptyException e1) {
				System.out.println("Account not deleted, prbable becuase it's not empty");
			}
		}
		}
		else {
			System.out.println("You don't have an account with that number");
		}
	}
	
	public void getAccountNumber(String usr, String pswd) throws SQLException, BadValueException {
		Connection conn= cf.getConnection();
		int hash = (usr+pswd).hashCode();
		String sql = "SELECT acctid FROM accountslist WHERE usrid=(SELECT usrid FROM login WHERE hashcode=?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, hash);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("Your account number is " + rs.getInt("acctid"));
		}
		CustomerMenu.menu(hash);
	}
	
	public static boolean AccountOwner(int hash, int acctID) throws SQLException {
		Connection conn= cf.getConnection();
		String sql = "SELECT acctid FROM accountslist WHERE usrid=(SELECT usrid FROM login WHERE hashcode=?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, hash);
		ResultSet rs = ps.executeQuery();
		int n;
		while (rs.next()) {
			n = rs.getInt(1);
			if (n==acctID) {
				return true;
			}
		}
		return false;
	}

}
