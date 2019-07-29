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
import com.revature.beans.Transaction;
import com.revature.dao.TransactionDao;
import com.revature.util.ConnFactory;

public class TransactionDaoImpl implements TransactionDao {
	//private Account acct; //Probably don't need this here. Would be better served in an instance of menu/login in order to keep values?
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public void makeDeposit(Account acct, double amt) throws SQLException {
		
		if (amt <= 0.00)
		{
			System.out.println("Invalid transaction. Please deposit a value exceeding $0.00.");
		}
		else
		{
			Connection conn = cf.getConnection();
			String sql = "{ call make_transaction(?,?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, acct.getAcctNo());
			call.setDouble(2, amt);
			call.execute();
			System.out.println("Amount of " + amt + " has been deposited to account #" + acct.getAcctNo());
		}
		
	}

	public void makeWithdrawal(Account acct, double amt) throws SQLException {
		
		if (acct.getBalance() - amt < 0.00)
		{
			System.out.println("Invalid transaction. Account has insufficient funds.");
		}
		else if (amt <= 0.00)
		{
			System.out.println("Invalid transaction. That is not an acceptable value.");
		}
		else
		{
			Connection conn = cf.getConnection();
			String sql = "{ call make_transaction(?,?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, acct.getAcctNo());
			call.setDouble(2, amt * -1);
			call.execute();
		}
		
	}

	public void makeXfer(Account srcAcct, Account destAcct, double amt) throws SQLException {
		if (srcAcct.getBalance() - amt < 0.00)
		{
			System.out.println("Invalid transaction. Account has insufficient funds.");
		}
		else
		{
			makeWithdrawal(srcAcct, amt);
			makeDeposit(destAcct, amt);
		}
		
	}

	//Returns transaction history.
	public List<Transaction> transactionList(int acctNo) throws SQLException {
		List<Transaction> transactionList = new ArrayList<Transaction>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM TRANSACTION WHERE ACCOUNTID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, acctNo);
		ResultSet rs = ps.executeQuery();
		Transaction trans = null;
		while (rs.next())
		{
			//ResultSet columns start at 1.
			trans = new Transaction(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4));
			transactionList.add(trans);
		}
		return transactionList;
	}

}
