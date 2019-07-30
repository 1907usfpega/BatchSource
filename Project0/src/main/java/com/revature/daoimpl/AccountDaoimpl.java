package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.beans.Account;
import com.revature.dao.AccountDao;
import com.revature.util.ConnFactory;

public class AccountDaoimpl implements AccountDao{
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void insertAccount(String type) {
		Connection conn = cf.getConnection(); 
		String sql = "{ call INSERT_ACCOUNT(?)";
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setString(1, type);
			call.execute();
		} catch (SQLException e) {
		
			e.printStackTrace();
		} 
	}

	@Override
	public void deleteAccount(int accountID) {
		Connection conn = cf.getConnection(); 
		String sql = "{ call DELETE_ACCOUNT(?)";
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setInt(1, accountID);
			call.execute();
		} catch (SQLException e) {
		
			e.printStackTrace();
		} 
		
	}

	@Override
	public void changeAccountStatus(int accountID, String status) {
		Connection conn = cf.getConnection(); 
		String sql = "{ call UPDATE_ACCOUNT_STATUS(?,?)";
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setInt(1, accountID);
			call.setString(2, status);
			call.execute();
		} catch (SQLException e) {
		
			e.printStackTrace();
		} 
		
	}

	@Override
	public void changeAccountBalance(int accountID, double val) {
		Connection conn = cf.getConnection(); 
		String sql = "{ call UPDATE_BALANCE(?,?)";
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setInt(1, accountID);
			call.setDouble(2, val);
			call.execute();
		} catch (SQLException e) {
		
			e.printStackTrace();
		} 
		
	}

	@Override
	public void setAccountBalance(int accountID, double val) {
		Connection conn = cf.getConnection(); 
		String sql = "{ call SET_BALANCE(?,?)";
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setInt(1, accountID);
			call.setDouble(2, val);
			call.execute();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}


	@Override
	public String getAccountStatus(int accountID) {
		Connection conn = cf.getConnection(); 
		String sql = "SELECT status FROM BANK_ACCOUNTS account_id = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, accountID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account getAccount(int accountID) {
		Account acc = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM BANK_ACCOUNTS WHERE account_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accountID);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			acc= new Account(rs.getInt(1)+"", rs.getString(2), rs.getDouble(3), rs.getString(4));
				 
		} catch (SQLException e) {
		
			e.printStackTrace();
		}	
		return acc; 
	}

	@Override
	public ArrayList<Account> getAll() {
		ArrayList<Account> accList = new ArrayList<Account>(); 
		Connection conn = cf.getConnection();
		try {
			Statement stEmpty = conn.createStatement();
			ResultSet rs;
			rs = stEmpty.executeQuery("SELECT * FROM BANK_ACCOUNTS");
			Account a = null;
			while (rs.next()) {
				a = new Account(rs.getInt(1)+"", rs.getString(2), rs.getDouble(3), rs.getString(4));
				accList.add(a); 
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}	
		return accList; 
	}
	
	public void printAll() {
		ArrayList<Account> accounts = this.getAll();
		for(Account a: accounts) {
			System.out.println(a.toString());
		}
	}

	@Override
	public double getBalance(int accountID) {
		int out = -1;
		Connection conn = cf.getConnection();
		String sql = "SELECT balance FROM BANK_ACCOUNTS WHERE account_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accountID);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
				 
		} catch (SQLException e) {
		
			e.printStackTrace();
		}	
		return out; 
	}

}
