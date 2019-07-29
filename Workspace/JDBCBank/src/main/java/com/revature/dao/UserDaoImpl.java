package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.util.ConnFactory;

public class UserDaoImpl implements UserDao {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createUser(String name, String password) {
		Connection conn = cf.getConnection();
		String sql = "{ call InsertCustomer(?,?) }";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, name);
			call.setString(2, password);
			call.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("pliz fix database");
		}
		
	}

	public void deleteUser(int id) {
		Connection conn = cf.getConnection();
		String sql = "{call DeleteCustomer(" + id +") }";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void updateUser(String name, String pass, int ind) {
		Connection conn = cf.getConnection();
		String sql = "{call UpdateCustomer(?,?,?)}";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, name);
			call.setString(2, pass);
			call.setInt(3, ind);			
			call.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateUserName(String name, int ind) throws SQLException{
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE customer_id = " + ind);
		String pass = "";
		while(rs.next()) {
			pass = rs.getString(2);
		}
		updateUser(name, pass, ind);
	}
	public void updateUserPass(String pass, int ind) throws SQLException{
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE customer_id = " + ind);
		String name = "";
		while(rs.next()) {
			name = rs.getString(1);
		}
		updateUser(name, pass, ind);
	}

	public ArrayList<User> getUsers() throws SQLException {
		ArrayList<User> userList = new ArrayList<User>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Customer");
		User u = null;
		while(rs.next()) {
			u = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			userList.add(u);
		}
		return userList;
	}

	public ArrayList<Account> getAccounts(int userId) throws SQLException {
		ArrayList<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String query = "SELECT * FROM bankaccount WHERE customer_id = " + userId;
		ResultSet rs = stmt.executeQuery(query);
		Account a = null;
		while(rs.next()) {
			a = new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			accountList.add(a);
		}
		return accountList;
	}

}
