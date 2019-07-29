package com.revature.driver;

import java.sql.SQLException;

import com.revature.beans.Customer;
import com.revature.daoimpl.UserDaoImpl;

public class Driver {
	
	/*
	 * Test cases for functionality.
	 */

	public static void main(String[] args) {
		
		UserDaoImpl testUserDao = new UserDaoImpl();
		try {
			Customer test = testUserDao.getCustomer("milliondollarman", "MONEY");
			System.out.println("I'm " + test.getFirstname() + " " + test.getLastname());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
