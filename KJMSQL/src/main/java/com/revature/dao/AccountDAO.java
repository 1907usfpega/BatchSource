package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class AccountDAO {


public boolean changeBalance(double amount) {
	try (Connection conn = ConnectionFactory.getInstance().getConnection()){
		
		conn.setAutoCommit(false);
		
		String sql = "UPDATE bank_account SET account_balance = ? WHERE user_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setDouble(1, amount);
		pstmt.setInt(2, AppState.getCurrentUser().getAccountId());
		pstmt.execute();
		
	} catch (SQLException sqle) {
		System.out.println("[ERROR] - " + sqle.getMessage());
		return false;
	}
	return true;
}

public Account getCurrentUserById() {
	
	Account retrievedAcc = null;
	
	try (Connection conn = ConnectionFactory.getInstance().getConnection()){
		
		conn.setAutoCommit(false);
		
		String sql = "SELECT * FROM bank_account WHERE user_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, AppState.getCurrentUser().getAccountId());
		
		retrievedAcc = accountResultSet(pstmt.executeQuery());
		
		
	} catch (SQLIntegrityConstraintViolationException sqlicve) {
		System.out.println("[LOG] - Username is already taken!");
		System.out.println("[ERROR] - " + sqlicve.getMessage());
	} catch (SQLException sqle) {
		System.out.println("[ERROR] - " + sqle.getMessage());
	}
		return retrievedAcc;
	
}

public double getBalance() {
	
	double balance = 0.00;
	
	try (Connection conn = ConnectionFactory.getInstance().getConnection()){
		
		String sql = "SELECT account_balance FROM bank_account WHERE user_id =" + AppState.getCurrentUser().getAccountId();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		balance = moneyResultSet(rs);
		
	} catch (SQLException sqle) {
		System.out.println("[ERROR] - " + sqle.getMessage());
	}
	return balance;
}

private Account accountResultSet(ResultSet rs) throws SQLException {
	
	Account temp = new Account();
	
	while (rs.next()) {
		temp.setBalance(rs.getDouble("account_balance"));
		rs.next();
	}
	return temp;
}

private double moneyResultSet(ResultSet rs) throws SQLException {
	
	Double money = 0.00;
	
	while (rs.next()) {
		money = rs.getDouble("account_balance");
		rs.next();
	}
	return money;
	
}

}