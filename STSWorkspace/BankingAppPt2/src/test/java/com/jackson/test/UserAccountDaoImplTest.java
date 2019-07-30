package com.jackson.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.jackson.daoimpl.UserAccountDaoImpl;

class UserAccountDaoImplTest 
{

UserAccountDaoImpl userDao = new UserAccountDaoImpl();
	
	@Test
	void testUpdateUser() 
	{
		assertThrows(SQLException.class,  () -> {
			userDao.updateUser(12423423);
	});
	}

	@Test
	void testDeleteUser() 
	{
		assertThrows(SQLException.class,  () -> {
			userDao.deleteUser(42342352);
	});
	}
}
