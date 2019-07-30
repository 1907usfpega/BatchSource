//package com.revature.bankingapppt1_2;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import com.revature.bankingapppt1_2.UserDatabase;
//
//class UserDatabaseTest {
//	UserDatabase userDB = new UserDatabase("LeviApplebaum", "password123", "Admin");
//
//	@Test
//	void printDatabaseTest() {
//		assertEquals(userDB.printDatabase(), "| LeviApplebaum | password123 | Admin | Pending | []\n");
//	}
//
//	@Test
//	void checkIfExistsTest() {
//		assertTrue(userDB.checkIfExists("LeviApplebaum"));
//		assertFalse(userDB.checkIfExists("MattKnighten"));
//	}
//
//	@Test
//	void addUserTest() {
//		assertTrue(userDB.addUser("JosephSmith", "BrighamYoung", "Customer"));
//		userDB.approve("JosephSmith");
//		assertFalse(userDB.addUser("LeviApplebaum", "qwerty", "Customer"));
//	}
//
//	@Test
//	void removeUser() {
//		assertTrue(userDB.removeUser("LeviApplebaum"));
//		assertFalse(userDB.removeUser("BillyJoel"));
//	}
//
//	@Test
//	void getUserTest() {
//		userDB.addUser("ArtFisher", "Qualish", "Customer");
//		userDB.approve("ArtFisher");
//		assertEquals(userDB.getUser("ArtFisher").getUserName(), "ArtFisher");
//	}
//
//	@Test
//	void addAccountTest() {
//		assertTrue(userDB.addAccount("LeviApplebaum", "Primary"));
//		assertFalse(userDB.addAccount("LeviApplebaun", "Primary"));
//	}
//
//	@Test
//	void removeAccountTest() {
//		assertTrue(userDB.removeAccount("LeviApplebaum", "Primary"));
//		assertFalse(userDB.removeAccount("LevsApplebaum", "Primary"));
//	}
//
//	@Test
//	void approveTest() {
//		assertTrue(userDB.approve("LeviApplebaum"));
//		assertFalse(userDB.approve("JohnyAppleseed"));
//	}
//
//	@Test
//	void denyTest() {
//		userDB.printDatabase();
//		assertTrue(userDB.deny("LeviApplebaum"));
//		assertFalse(userDB.deny("MarkTwain"));
//	}
//
//	@Test
//	void getAccountsTest() {
//		List<String> temp = new ArrayList<String>();
//		temp.add("Primary");
//		userDB.addAccount("LeviApplebaum", "Primary");
//		assertEquals(userDB.getAccounts("LeviApplebaum"), temp);
//	}
//
//	@Test
//	void getClearanceLevelTests() {
//		assertEquals("Admin", userDB.getClearanceLevel("LeviApplebaum"));
//	}
//
//	@Test
//	void setClearanceLevelTest() {
//		assertTrue(userDB.setClearanceLevel("LeviApplebaum", "Employee"));
//		assertFalse(userDB.setClearanceLevel("AlbertEinstein", "Customer"));
//	}
//
//	@Test
//	void getAllTest() {
//		List<String> temp = new ArrayList<String>();
//		temp.add("LeviApplebaum");
//		assertEquals(temp, userDB.getAll("Pending"));
//	}
//	
//}
