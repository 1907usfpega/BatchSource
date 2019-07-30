//package com.revature.bankingapppt1_2;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//import org.junit.jupiter.api.Test;
//
//import com.revature.bankingapppt1_2.AccountDatabase;
//import com.revature.beans.Account;
//
//class AccountDatabaseTest {
//
//	static AccountDatabase accDB = new AccountDatabase("10", "Checking", "RevatureAccount");
//
//	@Test
//	void approveTest() {
//		AccountDatabase accDB = new AccountDatabase("10", "Checking", "RevatureAccount");
//		accDB.approve("10");
//		assertTrue(accDB.getAccount("10").getStatus().equals("Approved"));
//		assertFalse(accDB.getAccount("11").getStatus().equals("Denied"));
//	}
//
//	@Test
//	void denyTest() {
//		AccountDatabase accDB = new AccountDatabase("10", "Checking", "RevatureAccount");
//		accDB.approve("10");
//		assertTrue(accDB.getAccount("10").getStatus().equals("Approved"));
//		accDB.deny("10");
//		assertTrue(accDB.getAccount("10").getStatus().equals("Denied"));
//	}
//
//	@Test
//	void addAccountTest() {
//		assertFalse(accDB.addAccount("10", "Checking", "RevatureAccount"));
//		assertTrue(accDB.addAccount("2", "Checking", "RevatureAccount"));
//	}
//
//	@Test
//	void removeAccountTest() {
//		accDB.addAccount("2", "Checking", "RevatureAccount");
//		assertTrue(accDB.checkIfExists("2"));
//		accDB.removeAccount("2");
//		assertFalse(accDB.checkIfExists("2"));
//	}
//
//	@Test
//	void checkIfExists() {
//		assertTrue(accDB.checkIfExists("10"));
//		assertFalse(accDB.checkIfExists("2"));
//	}
//
//	@Test
//	void getAccountTest() {
//		assertFalse(accDB.getAccount("10").equals(new Account("11", "Checking", "RevatureAccount")));
//		assertTrue(accDB.getAccount("10").equals(new Account("10", "Checking", "RevatureAccount")));
//	}
//
//	@Test
//	void addUserTest() {
//		accDB.addUser("10", "foo");
////		assertTrue(accDB.getAccount("10").getUsers().contains("foo"));
////		assertFalse(accDB.getAccount("10").getUsers().contains("bar"));
//	}
//
//	@Test
//	void removeUserTest() {
//		accDB.addUser("10", "car");
////		assertTrue(accDB.getAccount("10").getUsers().contains("car"));
////		accDB.addUser("10", "tool");
////		accDB.removeUser("10", "car");
////		assertTrue(!accDB.getAccount("10").getUsers().contains("car"));
//
//	}
//
//	@Test
//	void updateBalanceTest() {
//		accDB.updateBalance("10", 100.0);
//		assertTrue(accDB.getAccount("10").getBalance() == 100.0);
//		accDB.updateBalance("10", -100.0);
//		assertTrue(accDB.getAccount("10").getBalance() == 0);
//	}
//
//	@Test
//	void getBalanceTest() {
//		accDB.updateBalance("10", 100.0);
//		assertTrue(accDB.getAccount("10").getBalance() == 100.0);
//		accDB.updateBalance("10", -100.0);
//		assertTrue(accDB.getAccount("10").getBalance() == 0);
//	}
//
//	@Test
//	void setBalanceTest() {
//		accDB.setBalance("10", 100.0);
//		assertTrue(accDB.getAccount("10").getBalance() == 100.0);
//		accDB.setBalance("10", 0);
//		assertTrue(accDB.getAccount("10").getBalance() == 0);
//	}
//
//	@Test
//	void getUsersTest() {
//		accDB.addUser("10", "one");
//		accDB.addUser("10", "two");
//		assertTrue(accDB.getUsers("10").contains("one"));
//		assertTrue(accDB.getUsers("10").contains("two"));
//		assertFalse(accDB.getUsers("10").contains("three"));
//	}
//	@Test
//	void getAllTest() {
//		accDB.addAccount("100", "Checking", "Micky Boi");
//		accDB.addAccount("101", "Checking", "Ducky Boi");
//		accDB.approve("100"); 
//		assertTrue(accDB.getAll("Pending").contains("101"));
//		assertFalse(accDB.getAll("Pending").contains("100"));
//
//	}
//
//}
