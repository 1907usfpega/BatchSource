package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Customer;

/*
 * Interface for all basic user account creation needs.
 */

public interface UserDao {

	//CRUD ops. Needs exception throw, ID key handled by SQL sequence.
		public abstract void createCustomer(String first, String last, String email, String address, String city, String state, 
				String username, String pw) throws SQLException;
				
		public abstract void updateCustomer(Integer userid, String field, String newVal) throws SQLException;
		
		public abstract Customer getCustomer(String username, String password) throws SQLException;

}
