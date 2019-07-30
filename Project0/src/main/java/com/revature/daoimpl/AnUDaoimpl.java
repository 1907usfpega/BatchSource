package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.revature.dao.AnUDao;
import com.revature.util.ConnFactory;

public class AnUDaoimpl implements AnUDao{
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void linkUserAndAccount(int uId, int aId) {
		
		Connection conn = cf.getConnection(); 
		String sql = "{ call LINK_USER_ACCOUNT(?,?)";
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setInt(1, uId);
			call.setInt(2, aId);
			call.execute();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		} 
		
	}

	@Override
	public void unlinkAllUsersAccounts(int uId) {
		Connection conn = cf.getConnection(); 
		String sql = "{ call UNLINK_USER(?)";
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setInt(1, uId);
			call.execute();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		} 
		
	}
	
	public void unlinkAllAccountUsers(int aId) {
		Connection conn = cf.getConnection(); 
		String sql = "{ call UNLINK_ACCOUNT(?)";
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setInt(1, aId);
			call.execute();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		} 
		
	}

	@Override
	public void unlinkUserAndAccount(int uId, int aId) {
		Connection conn = cf.getConnection(); 
		String sql = "{ call UNLINK_USER_ACCOUNT(?, ?)";
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setInt(1, uId);
			call.setInt(2, aId);
			call.execute();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		} 
		
	}

	@Override
	public ArrayList<Integer> allAccounts(int uId) {
		ArrayList<Integer> accountIdList = new ArrayList<Integer>(); 
		Connection conn = cf.getConnection();
		String sql = "SELECT account_id FROM ANULOOKUP WHERE user_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uId);
			ResultSet rs;
			rs = ps.executeQuery();
			
			while (rs.next()) {
				accountIdList.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}	
		return accountIdList; 
	}
	
	

	@Override
	public int currentAccountSEQ() {
		Connection conn = cf.getConnection(); 
		String sql = "SELECT account_id FROM bank_accounts MINUS SELECT account_id FROM anulookup";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public ArrayList<Integer> allUsers(int aId) {
		ArrayList<Integer> userIdList = new ArrayList<Integer>(); 
		Connection conn = cf.getConnection();
		String sql = "SELECT user_id FROM ANULOOKUP WHERE account_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, aId);
			ResultSet rs;
			rs = ps.executeQuery();
			
			while (rs.next()) {
				userIdList.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}	
		return userIdList; 
	}
	public ArrayList<Integer> allallUsers() {
		ArrayList<Integer> userIdList = new ArrayList<Integer>(); 
		Connection conn = cf.getConnection();
		String sql = "SELECT user_id FROM ANULOOKUP";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs;
			rs = ps.executeQuery();
			
			while (rs.next()) {
				userIdList.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}	
		return userIdList; 
	}
	
	public ArrayList<Integer> allallAccounts() {
		ArrayList<Integer> userIdList = new ArrayList<Integer>(); 
		Connection conn = cf.getConnection();
		String sql = "SELECT account_id FROM ANULOOKUP";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs;
			rs = ps.executeQuery();
			
			while (rs.next()) {
				userIdList.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}	
		return userIdList; 
	}

}
