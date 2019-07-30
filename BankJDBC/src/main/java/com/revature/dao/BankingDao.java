package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Customer;

public interface BankingDao {
	public abstract void createCustomer (String username, String password, String firstName, String lastName) throws SQLException;
	public abstract void createAccount (String accountName, String accountType, int customerID) throws SQLException;
	public abstract List<Customer> getCustomerList() throws SQLException;
	public abstract List<Account> getAccountListPersonal(Customer c) throws SQLException;
	public abstract List<Account> getAccountListEmployee(Customer c) throws SQLException;
	
	
	
}
