/**
 * 
 */
package Accounts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Application.Application;


/**
 * @author MajorKey
 *
 */
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 762516089181692651L;

	private static List<Account> accounts = new ArrayList<Account>();
	
	private Map<String,String> login = new HashMap<String,String>();
	private String account_id;
	private String account_type;
	private double balance;
	
	public Account(Application app, double initialDeposit) {
		setAccount_id(app.getAccount_id());
		setLogin(app.getLogin());
		setBalance(initialDeposit);
		
	}
	public Account() {
		
	}
	public void deposit(double amount) {
		this.balance += amount;
	}
	public double withdraw(double amount) {
		if (amount <= this.balance && amount >=0) {
			this.balance -= amount;
			return amount;
		}
		System.out.println("Not enough in your account to withdraw this much.");
		return 0;
		
	}
	public void transfer(double amount, Account otherAccount) {
		if (amount <= this.balance) {
			this.balance -= amount;
			otherAccount.deposit(amount);
		} else {
			System.out.println("Not enough in your account to transfer this much.");
		}
	}
	
	//static getters & setters
	
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
	
	public static void addAccount(Account account) {
		Account.accounts.add(account);
	}
	
	public static void removeAccount(Account account) {
		Account.accounts.remove(account);
	}
	
	public static Account findAccount(String id) {
		for (int i = 0; i < Account.accounts.size(); i++) {
			if(Account.accounts.get(i).getAccount_id().equalsIgnoreCase(id)) {
				return Account.accounts.get(i);
			}
		}
		return null;
	}
	
	public static boolean checkUserNames(String user) {
		for (int i = 0; i < Account.accounts.size(); i++) {
			if(Account.accounts.get(i).getLogin().containsKey(user)) {
				return true;
			}
		}
		return false;
	}
	
	public static String generateAccountID() {
		int max = Integer.MAX_VALUE;
		int min = 1;
		int generated = (int) (Math.random() * ((max - min) + 1)) + min;
		
		return ("GB" + generated);
	}
	
	//non-static getters & setters
	
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
	public void addLogin(String username, String password) {
		if (this.login.size() < 1) {
			this.login.put(username, password);
		}
	}
	public void changeLogin(String username, String password) {
		this.login.replace(username, password);
	}
	public boolean checkLogin(String username, String password) {
		return password.equalsIgnoreCase(this.login.get(username));
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
	/**
	 * @return the account_type
	 */
	public String getAccount_type() {
		return account_type;
	}

	/**
	 * @param account_type the account_type to set
	 */
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
}
