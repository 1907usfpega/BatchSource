package members;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {
	double myPi = 22.0d / 7.0d;
	@Test
	public void depositNegative() {
		Account a =new Account();
		boolean actual = a.deposit(-20.0);
		boolean expected=false;
		assertEquals(actual,expected);
	}
	
	@Test
	public void depositCorrect() {
		Account a =new Account();
		boolean actual = a.deposit(20.0);
		boolean expected=true;
		assertEquals(actual,expected);
	}
	@Test
	public void depositCheckBalance() {
		Account a =new Account();
		a.deposit(20.0);
		double actual= a.getBalance();
		double expected=20.0;
		assertEquals(actual,expected,myPi);
	}
	
	@Test
	public void withdrawNegative() {
		Account a =new Account();
		boolean actual = a.withdraw(-20.0);
		boolean expected=false;
		assertEquals(actual,expected);
	}
	
	@Test
	public void withdrawMoreThanAvailable() {
		Account a =new Account();
		a.deposit(20.0);
		boolean actual = a.withdraw(30.0);
		boolean expected=false;
		assertEquals(actual,expected);
	}
	
	@Test
	public void withdrawAll() {
		Account a =new Account();
		a.deposit(20.0);
		boolean actual = a.withdraw(20.0);
		boolean expected=true;
		assertEquals(actual,expected);
	}
	
	@Test
	public void withdrawCheckBalance() {
		Account a =new Account();
		a.deposit(20.0);
		a.withdraw(10.0);
		double actual =a.getBalance();
		double expected=10.0;
		assertEquals(actual,expected, myPi);
	}
	
	@Test
	public void transferSuccess() {
		Account a = new Account();
		Account b = new Account();
		a.deposit(20);
		boolean actual =a.transfer(20,b);
		boolean expected =true;
		assertEquals(actual,expected);
	}
	
	@Test
	public void transferFail() {
		Account a = new Account();
		Account b = new Account();
		a.deposit(20);
		boolean actual = a.transfer(21, b);
		boolean expected = false;
		assertEquals(actual, expected);
	}
	
	@Test
	public void transferCheckBalanceOfSender() {
		Account a = new Account();
		Account b = new Account();
		a.deposit(20);
		a.transfer(20, b);
		double actual=a.getBalance();
		double expected = 0;
		assertEquals(actual, expected,myPi);
	}
	
	@Test
	public void transferCheckBalanceOfReceiver() {
		Account a = new Account();
		Account b = new Account();
		a.deposit(20);
		a.transfer(20, b);
		double actual=b.getBalance();
		double expected = 20;
		assertEquals(actual, expected,myPi);
	}
	

}
