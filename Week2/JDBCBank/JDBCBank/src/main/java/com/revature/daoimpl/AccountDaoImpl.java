package com.revature.daoimpl;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.account.Account;
import com.revature.connFactory.ConnFactory;
import com.revature.dao.AccountDao;



public class AccountDaoImpl implements AccountDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	//calls the procedure on db to create a new account row
	public void createAccount(int userid, int loginid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call insertaccount(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, loginid);
		call.setInt(2, userid);
		call.execute();
		System.out.println("Account Created");
	}
	
	//fetches all the accounts associated with a specific user
	public List<Account> getAccounts(int userid) throws SQLException {
		List<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		
		String sql = "SELECT * FROM account WHERE userid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userid);
		ResultSet rs = ps.executeQuery();
		Account account = null;
		
		while (rs.next()) {
			account= new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getInt(4));
			accountList.add(account);
		}
		return accountList;
	}

	//sends the amount to add to the account balance to the db
	public void deposit(int accountid, double balance) throws SQLException {
		Connection conn = cf.getConnection();
		balance *= -1;
		String sql = "{call updateaccount(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, accountid);
		call.setDouble(2, balance);
		call.execute();
		System.out.println("Amount Deposited");

	}

	//sends the amount to be subtracted from the account balance to the db
	public void withdraw(int accountid, double balance) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call updateaccount(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, accountid);
		call.setDouble(2, balance);
		call.execute();
		System.out.println("Amount Withdrawn");
	}

	//deletes a specific account
	public void deleteAccount(int accountid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call deleteaccount(?)";
		CallableStatement call = conn.prepareCall(sql);
		
		call.setInt(1, accountid);
		call.execute();
		System.out.println("Account Deleted");
	}

	//returns an account if the specified account belongs to the specified user
	public Account checkAccount(int accountid, int userid) throws SQLException {
		Account account = null;
		Connection conn = cf.getConnection();
		
		String sql = "SELECT * FROM account WHERE (accountid = ? AND userid = ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, accountid);
		ps.setInt(2, userid);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			account= new Account(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getInt(4));
		}
		return account;
	}
}
