package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Customer;
import com.revature.dao.UserDao;
import com.revature.util.ConnFactory;

public class UserDaoImpl implements UserDao {
	
	/*
	 * Implementation of UserDao. Elected to have usernames be unalterable after creation. since they are unique values, and for sake of account security.
	 */
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createCustomer(String first, String last, String email, String address, String city, String state,
			String username, String pw) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call add_customer(?,?,?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, first);
		call.setString(2, last);
		call.setString(3, email);
		call.setString(4, address);
		call.setString(5, city);
		call.setString(6, state);
		call.setString(7, username);
		call.setString(8, pw);

		call.execute();
		
	}

	//Note: May alter so that user can pass in args to determine what needs changed. Would save having to update an entire row everytime.
	public void updateCustomer(Integer userid, String field, String newVal) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE CUSTOMER SET ? = ? WHERE CUSTOMERID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, field);
		ps.setString(2, newVal);
		ps.setInt(3, userid.intValue());
		ps.executeUpdate();
	}

	//Returns SELECT query as a Customer object. Should be used in main point of access for customer/account related situations.(Private Customer = this?)
	//Need to figure out an error throw if no such value exists.
	public Customer getCustomer(String username, String password) throws SQLException {
		Customer cust = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM CUSTOMER WHERE USERNAME = ? AND PASSWORD = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (rs.equals(null))
		{
			System.out.println("Invalid login. Please try again.");
		}
		else
		{
			while (rs.next())
			{
				//ResultSet columns start at 1.
				cust = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
			}
		}
		
		return cust;
	}

}
