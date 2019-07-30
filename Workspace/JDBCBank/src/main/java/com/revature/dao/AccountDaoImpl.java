package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.User;
import com.revature.exception.NegativeNumberException;
import com.revature.util.ConnFactory;

public class AccountDaoImpl implements AccountDao {
	ConnFactory cf = ConnFactory.getInstance();

	public void createAccount(int userId) {
		Connection conn = cf.getConnection();
		String sql = "{ call InsertAccount(?) }";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, userId);
			call.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("pliz fix database");
		}

	}

	public void deleteAccount(int accountId) {
		Connection conn = cf.getConnection();
		String sql = "{call DeleteAccount(" + accountId + ") }";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void depoOrWithdraw(int accountId, int amount, boolean withdrawn) throws NegativeNumberException {
		Connection conn = cf.getConnection();
		String sql = "";
		int balance;
		try {
		if (withdrawn) {
			balance = getBalance(accountId) - amount;
		} else {
			balance = getBalance(accountId) + amount;
		}
		if(balance < 0 || amount < 0)
			throw new NegativeNumberException();
		sql = "{call WithdrawOrDeposit(" + accountId + ", " + balance + ")}";
		CallableStatement call = conn.prepareCall(sql);
		call.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public int getBalance(int accountInd) throws SQLException{
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT balance FROM bankaccount WHERE account_id = " + accountInd);
		int balance = 0;
		while(rs.next()) {
			balance = rs.getInt(1);
		}
		return balance;
	}

}
