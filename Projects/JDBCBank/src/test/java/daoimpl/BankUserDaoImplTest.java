package daoimpl;

import static org.junit.Assert.*;

import org.junit.Test;

import members.Account;
import members.Customer;

public class BankUserDaoImplTest {

	@Test
	public void retrieveUserID() {
		BankUserDaoImpl bu = new BankUserDaoImpl();
		Customer c= new Customer("gary","123");
		int actual = bu.getUserID(c);
		int expected = 1021;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testNewUser() {
		BankUserDaoImpl bu = new BankUserDaoImpl();
		boolean actual = bu.userAuthentication("popcaan", "yaow");
		boolean expected = true;
		assertEquals(actual, expected);
	}
	
	@Test
	public void testFalseNewUser() {
		BankUserDaoImpl bu = new BankUserDaoImpl();
		boolean actual = bu.userAuthentication("popcaa", "yaow");
		boolean expected = false;
		assertEquals(actual, expected);
	}
	
	@Test
	public void usernameInUse() {
		BankUserDaoImpl bu= new BankUserDaoImpl();
		boolean actual= bu.userAlreadyExists("popcaan");
		boolean expected= true;
		assertEquals(actual,expected);
	}
	
	@Test
	public void usernameNotInUse() {
		BankUserDaoImpl bu= new BankUserDaoImpl();
		boolean actual= bu.userAlreadyExists("BroGad");
		boolean expected= false;
		assertEquals(actual,expected);
	}
	
	@Test
	public void testUserId() {
		BankUserDaoImpl bu= new BankUserDaoImpl();
		Customer c= new Customer("gary","123");
		int actual =bu.getUserID(c);
		int expected =1021;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetCorrectAccount() {
		BankUserDaoImpl bu = new BankUserDaoImpl();
		Account a =bu.getBankAccount(10023);
		int actual = a.getAcctNum();
		int expected = 10023;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetWrongAccount() {
		BankUserDaoImpl bu = new BankUserDaoImpl();
		Account a =bu.getBankAccount(10023);
		int actual = a.getAcctNum();
		int expected = 100023;
		assertFalse(expected==actual);
	}
	
	@Test
	public void fetchAcct() {
		BankUserDaoImpl bu= new BankUserDaoImpl();
		boolean actual = bu.acctExists(10023);
		boolean expected =true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void fetchAcct1() {
		BankUserDaoImpl bu= new BankUserDaoImpl();
		boolean actual = bu.acctExists(100023);
		boolean expected =false;
		assertEquals(expected, actual);
	}

}
