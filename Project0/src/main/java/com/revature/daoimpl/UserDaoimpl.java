package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.util.ConnFactory;

public class UserDaoimpl implements UserDao{
	
	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	/*
	 * inserts a new user into the table
	 * NOTE IT DOES WILL NOT ADD USERS WITH DUPLICATE NAMES
	 */
	public void insertUser(String username, String password, String type) {
		if(this.getUserId(username) != -1) {
			return;
		}
		Connection conn = cf.getConnection(); 
		String sql = "{ call INSERT_USER(?,?,?)";
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setString(1, username);
			call.setString(2, password);
			call.setString(3, type);
			call.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

	@Override
	public void deleteUser(String username) {
		int id = this.getUserId(username);
		if(id < 0) {
			return;
		}
		Connection conn = cf.getConnection(); 
		String sql = "{ call delete_user(?)";
		
		try {
			CallableStatement call = conn.prepareCall(sql); 
			call.setInt(1, id);
			call.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	/*
	 * changes user's status to @parm status
	 * will do nothing if the username is not found
	 */
	public void changeUserStatus(String username, String status) {
		int id = this.getUserId(username);
		if(id < 0) {
			return;
		}
		Connection conn = cf.getConnection(); 
		String sql = "{ call change_user_status(?, ?)";
		
		try {
			CallableStatement call = conn.prepareCall(sql); 
			call.setInt(1, id);
			call.setString(2, status);
			call.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public int getUserId(String username) {
		Connection conn = cf.getConnection(); 
		String sql = "SELECT user_id FROM BANK_USERS WHERE user_name = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return -1;
	}
	public void initUser() {
		if(this.getUserId("admin") != -1) {
			return;
		}
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO BANK_USERS VALUES(?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setString(2, "admin");
			ps.setString(3, "admin");
			ps.setString(4, "Admin");
			ps.setString(5, "Approved");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Returns user password as string. If not found
	 * return null
	 */
	@Override
	public String getUserPassword(String username) {
		Connection conn = cf.getConnection(); 
		String sql = "SELECT user_password FROM BANK_USERS WHERE user_name = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}

	@Override
	public String getUserStatus(String username) {
		Connection conn = cf.getConnection(); 
		String sql = "SELECT status FROM BANK_USERS WHERE user_name = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}

	@Override
	public String getUserType(String username) {
		Connection conn = cf.getConnection(); 
		String sql = "SELECT user_clearance_level FROM BANK_USERS WHERE user_name = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}

	@Override
	public String getClearance(String username) {
		Connection conn = cf.getConnection(); 
		String sql = "SELECT clearance_level FROM BANK_USERS WHERE user_name = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUser(String username) {
		
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM BANK_USERS WHERE user_name = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new User( rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
				
		
	}

	@Override
	public ArrayList<User> getAll() {
		ArrayList<User> userList = new ArrayList<User>(); 
		Connection conn = cf.getConnection();
		try {
			Statement stEmpty = conn.createStatement();
			ResultSet rs;
			rs = stEmpty.executeQuery("SELECT * FROM BANK_USERS");
			User u = null;
			while (rs.next()) {
				u = new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				userList.add(u); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return userList; 
		
	}
	
	public void printAll() {
		ArrayList<User> users = this.getAll();
		for(User u: users) {
			System.out.println(u.toString());
		}
	}
	
}