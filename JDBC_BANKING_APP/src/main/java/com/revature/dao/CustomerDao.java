package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Customer;

public interface CustomerDao {
	//CRUD 
	public abstract void createCustomer(String customerName) throws SQLException;
	public abstract List<Customer> getCustomerList() throws SQLException;
}
