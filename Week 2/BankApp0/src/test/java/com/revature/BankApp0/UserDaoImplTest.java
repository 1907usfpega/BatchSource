package com.revature.BankApp0;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import daoimpl.UserDaoImpl;

public class UserDaoImplTest {

	@Test
	public void getUIDTest() {
		UserDaoImpl udi = new UserDaoImpl();
		int expected = 2;
		int actual = 0;
		try {
			actual = udi.getUID("Tien");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(expected, actual);
	}

}
