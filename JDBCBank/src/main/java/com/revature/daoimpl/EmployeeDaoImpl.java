package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Admin;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.util.ConnFactory;

/*
 * Implementation of EmployeeDao.
 * TODO: Begin fleshing out removeEmployee & getEmployeeList methods(time permitting).
 */

public class EmployeeDaoImpl implements EmployeeDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createEmployee(String first, String last, String email, String address, String city, String state,
			String username, String pw, String employeeType) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call add_employee(?,?,?,?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, first);
		call.setString(2, last);
		call.setString(3, email);
		call.setString(4, address);
		call.setString(5, city);
		call.setString(6, state);
		call.setString(7, username);
		call.setString(8, pw);
		call.setString(9, employeeType);
		call.execute();

	}

	public void updateEmployee(Integer userid, String field, String newVal) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE EMPLOYEE SET ? = ? WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, field);
		ps.setString(2, newVal);
		ps.setInt(3, userid.intValue());
		ps.executeUpdate();
	}

	public void removeEmployee(Integer employeeId) throws SQLException {
		// TODO Auto-generated method stub

	}

	public Employee getEmployee(String username, String password) throws SQLException {
		Employee worker = null;
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = ? AND PASSWORD = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			worker = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)
					,rs.getString(9), rs.getString(10));
		}
		return worker;
	}

	public List<Customer> getCustomerList() throws SQLException {
		List<Customer> customerList = new ArrayList<Customer>();
		Connection conn = cf.getConnection();
		//Statement - compiles on SQL side. Generally terrible. Allows for SQL Injection. Headaches. DON'T DO IT.
		Statement stmt = conn.createStatement();
		//SEMICOLON built into query. Nice. :D
		ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER");
		Customer s = null;
		while (rs.next())
		{
			//ResultSet columns start at 1.
			s = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
			customerList.add(s);
		}
		return customerList;
	}

}
