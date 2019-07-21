/**
 * 
 */
package Accounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author MajorKey
 *
 */
public class Account {
	private static List<Account> accounts = new ArrayList<Account>();
	
	private Map<String,String> login = new HashMap<String,String>();
	private String account_id;
	private double balance;
	
	
	public void deposit(double amount) {
		
	}
	public double withdraw(double amount) {
		return amount;
		
	}
	public void transfer(double amount, Account otherAccount) {
		
	}
	/**
	 * @return the accounts
	 */
	public static List<Account> getAccounts() {
		return accounts;
	}
	/**
	 * @param accounts the accounts to set
	 */
	public static void setAccounts(List<Account> accounts) {
		Account.accounts = accounts;
	}
	/**
	 * @return the login
	 */
	public Map<String, String> getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(Map<String, String> login) {
		this.login = login;
	}
	/**
	 * @return the account_id
	 */
	public String getAccount_id() {
		return account_id;
	}
	/**
	 * @param account_id the account_id to set
	 */
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
