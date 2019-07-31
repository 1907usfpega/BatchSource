package com.revature.bank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User>{

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createUser(String username, String password, String firstName, String lastName, String address, String city, String state, String phoneNumber) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call NEW_USER(?,?,?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		call.setString(2, password);
		call.setString(3, firstName);
		call.setString(4, lastName);
		call.setString(5, address);
		call.setString(6, city);
		call.setString(7, state);
		call.setString(8, phoneNumber);
		call.execute();	
	}
	
	public User athenticate(String username, String password) throws SQLException {
		List<User> users = getAll();
		boolean authenticated = false;
		 User user = null;
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUsername().equals(username)) {
				if(users.get(i).getPassword().equals(password)) {
					System.out.println("Authenticated!");
					user = users.get(i);
					authenticated = true;
					break;
				} 
			} 
		}
		if(authenticated == false) {
			System.out.println("Invalid Credentials!");
		}
		return user;
	}
	public boolean usernameAvailable(String username) throws SQLException {
		List<User> users = getAll();
		//boolean authenticated = false;
		 boolean available = true;
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUsername().equals(username)) {
				System.out.println("Username Is Already Taken, Choose A Different Username.");
				available = false;
				break;
			} 
		}
		return available;
	}
	
	//DAO Interface Methods
	public List<User> getAll() throws SQLException {
		List<User> userList = new ArrayList<User>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM USERTABLE");
		User u = null;
		while(rs.next()) {
			u = new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
			userList.add(u);
		}
		return userList;
	}


	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int accountNumber) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call DELETE_USER(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, accountNumber);
		call.execute();	
		System.out.println("Account Number " + accountNumber + " Has Been Deleted!");
	}
}
