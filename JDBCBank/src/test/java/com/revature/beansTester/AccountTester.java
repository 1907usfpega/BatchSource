package com.revature.beansTester;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.revature.beans.Account;
import com.revature.daoimpl.AccountDaoImpl;

/*
 * Tester class for Account object.
 */

class AccountTester {
	private static AccountDaoImpl adi = new AccountDaoImpl();
	private static Account acct = new Account();
	
	//Do DaoImpl to get account from DB.
	@BeforeAll
	static void getAccount()
	{
		try {
			acct = adi.getAccount(1000);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName ("Constructor Test")
	void testAccount() {
		fail("Not yet implemented"); // TODO
	}

	//SQL call doesn't return any value. May need to adjust statement.
	@Test
	@DisplayName ("Balance Check")
	void testGetBalance() {
		adi = new AccountDaoImpl();
		try {
			acct = adi.getAccount(1000);
			double bal = adi.getBal(acct.getUserId()).doubleValue();
			System.out.println("Class Balance call: " + acct.getBalance());
			System.out.println("SQL Balance call:" + bal);
			if (acct.getBalance() != bal)
			{
				fail("Balances don't match! How did that happen?");
			}
		} catch (SQLException e) {
			fail("SQL error. Not pulling from the DB, huh?");
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName ("Account # Check")
	void testGetAcctNo() {
		if (acct.getAcctNo() != 100000)
		{
			fail("Account number doesn't match! How did that happen?");
		}
	}

	@Test
	@DisplayName ("User ID Check")
	void testGetUserId() {
		if (acct.getUserId() != 1000)
		{
			fail("User ID doesn't match! How did that happen?");
		}
	}

	@Test
	@DisplayName ("Account Type Check")
	void testGetAcctType() {
		if (acct.getAcctType().equals("savings") == false)
		{
			fail("That's the wrong type of account. C'mon already!");
		}
	}

	
	//Remaining methods either unused or soon to be removed. Sorry. :D
	@Test
	void testPrintBal() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testToString() {
		fail("Not yet implemented"); // TODO
	}

}
