/**
 * 
 */
package bankapp;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Accounts.Account;

/**
 * @author Deonta Kilpatrick
 *
 */
class AccountTest {

	private  Account account ;
	private  Account account2;
	
	/**
	 * Test method for {@link Accounts.Account#deposit(double)}.
	 */
	@Test
	void testDeposit() {
		account = new Account();
		account.setBalance(500);
		account.deposit(55);
		double expected = 555;
		
		assertEquals(expected, account.getBalance(),0);
	}

	/**
	 * Test method for {@link Accounts.Account#withdraw(double)}.
	 */
	@Test
	void testWithdraw() {
		account = new Account();
		account.setBalance(555);
		account.withdraw(55);
		double expected = 500;
		assertEquals(expected, account.getBalance(),0);
	}

	/**
	 * Test method for {@link Accounts.Account#transfer(double, Accounts.Account)}.
	 */
	@Test
	void testTransfer() {
		account = new Account();
		account2 = new Account();
		account.setBalance(555);
		account2.setBalance(0);
		account.transfer(55, account2);
		double expected = 500;
		assertEquals(expected, account.getBalance(),0);
	}

}
