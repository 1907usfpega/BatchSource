package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.dao.AccountDao;
import com.revature.util.ConnFactory;

public class AccountDaoImpl implements AccountDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();


	public void createAccount(Integer userId, Double balance, String accountType) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call add_account(?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, userId);
		call.setDouble(2, balance.doubleValue());
		call.setString(3, accountType);
		call.execute();
	}

	//Should only be allowed by customer if bal = 0.00. Should always be available to admins.
	public void closeAccount(Integer userId) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call delete_account(?)";
		CallableStatement call = conn.prepareCall(sql);
		
	}

	public Account getAccount(Integer userId) throws SQLException {
		Account acct = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM ACCOUNT WHERE USERID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userId.intValue());
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			//ResultSet columns start at 1.
			acct = new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4));
		}
		return acct;
	}
	
	public Account getAccountbyNo(Integer AccountId) throws SQLException {
		Account acct = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM ACCOUNT WHERE ACCOUNTID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, AccountId.intValue());
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			//ResultSet columns start at 1.
			acct = new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4));
		}
		return acct;
	}

	public List<Account> getAccountList() throws SQLException {
		List<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		//Statement - compiles on SQL side. Generally terrible. Allows for SQL Injection. Headaches. DON'T DO IT.
		Statement stmt = conn.createStatement();
		//SEMICOLON built into query. Nice. :D
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT");
		Account s = null;
		while (rs.next())
		{
			//ResultSet columns start at 1.
			s = new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4));
			accountList.add(s);
		}
		return accountList;
	}

	public Double getBal(Integer accountId) throws SQLException{
		Double acctBal = 0.0;
		Connection conn = cf.getConnection();
		String sql = "SELECT BALANCE FROM ACCOUNT WHERE ACCOUNTID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, accountId.intValue());
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			//ResultSet columns start at 1.
			acctBal = (rs.getDouble(1));
		}
		return acctBal;
	}


}
