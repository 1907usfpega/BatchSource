package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Customer;
import com.revature.beans.Employee;

public interface EmployeeDao {
	/*
	 * Interface for Employee/Admin creation/manipulation of DBs.
	 * TODO: Time permitting, include a removeEmployee method.
	 */
	
	public abstract void createEmployee(String first, String last, String email, String address, String city, String state, 
			String username, String pw, String employeeType) throws SQLException;
	
	public abstract void updateEmployee(Integer userid, String field, String newVal) throws SQLException;
	
	public abstract void removeEmployee(Integer employeeId) throws SQLException;
	
	public abstract Employee getEmployee(String username, String password) throws SQLException;
	
	public abstract List<Customer> getCustomerList() throws SQLException;

}
