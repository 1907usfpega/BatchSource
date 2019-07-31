package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;

public class UserDAO {

	public UserDAO() {
		super();
	}
	
	public User getByUsername(String username) {
		
		User retrievedUser = null;
		String sql = "SELECT * FROM bank_user WHERE user_username = ?";
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			
			List<User> users = mapResultSet(pstmt.executeQuery());
			if (!users.isEmpty()) retrievedUser = users.get(0);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return retrievedUser;
	}
	
	public User getByCredential(String username, String password) {
		
		User retrievedUser = null;
		String sql = "SELECT * FROM bank_user WHERE user_username = ? AND user_password = ?";
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			List<User> users = mapResultSet(pstmt.executeQuery());
			if (!users.isEmpty()) retrievedUser = users.get(0);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return retrievedUser;
	}
	
	public List<String> getAllUsernames() {
		List<String> usernames = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			CallableStatement cstmt = conn.prepareCall("{CALL get_all_username(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			
			ResultSet rs = (ResultSet) cstmt.getObject(1);
			usernames = usernameResultSet(rs);
			
		} catch (SQLException sqle) {
			System.out.println("[ERROR] - " + sqle.getMessage());
			return null;
		}
		
		System.out.println(usernames.size());
		return usernames;

	}
	
	public void createNewUser(User user) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			conn.setAutoCommit(true);
			
			String sql1 = "INSERT INTO bank_user VALUES (0, ?, ?)";
			String sql2 = "INSERT INTO bank_account VALUES (0, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.execute();
			User temp = getByUsername(user.getUsername());
			PreparedStatement ps = conn.prepareStatement(sql2);
			ps.setInt(1, 0);
			ps.setInt(2, temp.getAccountId());
			ps.execute();
			
		} catch (SQLIntegrityConstraintViolationException sqlicve) {
			System.out.println("[LOG] - Username is already taken!");
			System.out.println("[ERROR] - " + sqlicve.getMessage());
		} catch (SQLException sqle) {
			System.out.println("[ERROR] - " + sqle.getMessage());
		}
		
	}
		
	private List<User> mapResultSet(ResultSet rs) throws SQLException {
		
		List<User> users = new ArrayList<>();
		
		while (rs.next()) {
			User temp = new User();
			temp.setUsername(rs.getString("user_username"));
			temp.setPassword(rs.getString("user_password"));
			temp.setAccountId(rs.getInt("user_id"));
			users.add(temp);
		}
		return users;
	}
	
	private List<String> usernameResultSet(ResultSet rs) throws SQLException {
		
		List<String> users = new ArrayList<>();
		
		while (rs.next()) {
			users.add(rs.getString("user_username"));
		}
		return users;
	}
	
}