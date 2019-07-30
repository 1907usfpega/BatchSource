/**
 * 
 */
package account;

import java.sql.SQLException;
import java.util.List;

import daoimpl.AccountDaoImpl;

/**
 * @author MajorKey
 *
 */
public class Account {

	private int accountid;
	private double balance;
	private int loginid;
	private int userid;
	
	/**
	 * @param accountid
	 * @param balance
	 * @param loginid
	 * @param userid
	 */
	public Account(int accountid, double balance, int loginid, int userid) {
		super();
		this.accountid = accountid;
		this.balance = balance;
		this.loginid = loginid;
		this.userid = userid;
	}

	/**
	 * @param loginid
	 * @param userid
	 */
	public Account(int loginid, int userid) {
		super();
		this.loginid = loginid;
		this.userid = userid;
	}

	/**
	 * 
	 */
	public Account() {
		super();
	}

	/**
	 * @return the accountid
	 */
	public int getAccountid() {
		return accountid;
	}

	/**
	 * @param accountid the accountid to set
	 */
	public void setAccountid(int accountid) {
		this.accountid = accountid;
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
	 * @return the loginid
	 */
	public int getLoginid() {
		return loginid;
	}

	/**
	 * @param loginid the loginid to set
	 */
	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}

	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", balance=" + balance + "]";
	}
	
	public static List<Account> viewAccounts(int userid) throws SQLException{
		AccountDaoImpl acc = new AccountDaoImpl();
		return acc.getAccounts(userid);
	}
	
	public static void createAccount(int userid, int loginid) throws SQLException {
		AccountDaoImpl acc = new AccountDaoImpl();
		acc.createAccount(userid, loginid);
	}
	
	public static void deleteAccount(int accountid) throws SQLException {
		AccountDaoImpl acc = new AccountDaoImpl();
		acc.deleteAccount(accountid);
	}
	
	public static void depositToAccount(int accountid, double amount) throws SQLException {
		AccountDaoImpl acc = new AccountDaoImpl();
		acc.deposit(accountid, amount);
	}
	public static void withdrawFromAccount(int accountid, double amount) throws SQLException {
		AccountDaoImpl acc = new AccountDaoImpl();
		acc.withdraw(accountid, amount);
	}
	
	public static Account checkAccount(int accountid, int userid) throws SQLException {
		//returns an account account exists and belongs to user
		AccountDaoImpl acc = new AccountDaoImpl();
		return acc.checkAccount(accountid, userid);
	}
	
	
}
