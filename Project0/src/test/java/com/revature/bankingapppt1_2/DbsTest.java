//package com.revature.bankingapppt1_2;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//
//class DbsTest {
//
//	
//	@Test
//	void test() {
//		Dbs.userData = new UserDatabase();
//		Dbs.accData = new AccountDatabase();
//		Dbs.userData.addUser("TestName", "TestPassword", "Customer");
//		Dbs.accData.addAccount("1000", "Checking", "TestName");
//		Dbs.userData.deny("TestName");
//		Dbs.accData.deny("1000");
//		assertTrue(Dbs.userData.checkIfExists("TestName"));
//		assertTrue(Dbs.accData.checkIfExists("1000"));
//		Dbs.deletAllDenied();
//		assertFalse(Dbs.userData.checkIfExists("TestName"));
//		assertFalse(Dbs.accData.checkIfExists("1000"));
//		
//		
//	}
//
//}
