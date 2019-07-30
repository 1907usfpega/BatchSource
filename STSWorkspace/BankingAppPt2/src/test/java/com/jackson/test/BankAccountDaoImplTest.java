package com.jackson.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import cam.jackson.exceptions.OverdraftException;

import com.jackson.daoimpl.BankAccountDaoImpl;

class BankAccountDaoImplTest 
{
	BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
	

	@Test
	void testWithdrawFunds() 
	{
		assertThrows(OverdraftException.class,  () -> {
			//bankDao.withdrawFunds(1, 1);
	});
	}

	@Test
	void testDeleteAccount() 
	{
		assertThrows(NullPointerException.class,  () -> {
			bankDao.deleteAccount(12423423);
	});
	}

}
