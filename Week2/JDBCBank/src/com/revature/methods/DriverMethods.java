package com.revature.methods;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pojo.User;
import com.revature.sql.ConnectionUtil;

public class DriverMethods implements UserMethods {
	
	public static boolean doesUserNameExist(String desiredName) {
		String statement = "SELECT * FROM USER WHERE USER.NAME = " + desiredName;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(statement);
			ResultSet rs = pstmt.executeQuery();
	
			if(!rs.next())
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean createUser(String username, String password) {
		// TODO Auto-generated method stub
		User user = new User(username,password);
		String statement = "INSERT INTO BANK_USERS (USER_NAME,USER_PASSWORD,IS_ADMIN) VALUES (?,?,?)";
		
		try {
			PreparedStatement pstmt = ConnectionUtil.getConnection().prepareStatement(statement);;
			pstmt.setString(1,username);
			pstmt.setString(2, password);
			pstmt.setInt(3,0);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	private int getLatestUserID() {
		String stmt = "SELECT ID FROM USER ORDER BY ID DESC";
		
		try {
			PreparedStatement pstmt = ConnectionUtil.getConnection().prepareStatement(stmt);
			ResultSet rs = pstmt.executeQuery();
			if(!rs.next())
				return 1;
			else return rs.getInt(1)+1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public boolean deleteUser(String username) {
		// TODO Auto-generated method stub
		
		String deleteStmt = "DELETE FROM USERS WHERE USER_NAME = " + username ;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement psmt = connection.prepareStatement(deleteStmt);
			psmt.executeQuery();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		
		String statement = "SELECT * FROM BANK_USERS WHERE BANK_USERS.USER_NAME = ?";
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(statement);
			pstmt.setString(1,username);
			ResultSet rs = pstmt.executeQuery();
			
		
			if(rs.next() == false) {
				return null;
			}
				
			else {
				int colPass = rs.findColumn("USER_PASSWORD");
				return new User(username,rs.getString(colPass));	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public User getUser(String username, String password) {
		// TODO Auto-generated method stub
		String statement = "SELECT * FROM BANK_USERS WHERE BANK_USERS.USER_NAME = ? AND BANK_USERS.USER_PASSWORD = ?";
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(statement);
			pstmt.setString(1,username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
		
			if(rs.next() == false) {
				return new User(username,"");
			}
				
			else {
				return new User(username,password);				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}