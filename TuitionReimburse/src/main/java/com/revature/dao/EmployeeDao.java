package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.Employee;

public interface EmployeeDao {

	public abstract Employee getEmployee(int userID) throws SQLException;
	
	public abstract void employeeReg(String first, String last, String dob, String sup, String addr) throws SQLException;
	
	public abstract int verifyPassword(String username, String password) throws SQLException;

	
}
