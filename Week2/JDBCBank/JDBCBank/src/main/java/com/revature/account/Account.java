package com.revature.account;


import java.sql.SQLException;
import java.util.List;

import com.revature.daoimpl.AccountDaoImpl;


public class Account {

	private int accountid;
	private double balance;
	private int loginid;
	private int userid;
	
	
	public Account(int accountid, double balance, int loginid, int userid) {
		super();
		this.accountid = accountid;
		this.balance = balance;
		this.loginid = loginid;
		this.userid = userid;
	}

	
	public Account(int loginid, int userid) {
		super();
		this.loginid = loginid;
		this.userid = userid;
	}

	
	public Account() {
		super();
	}

	
	public int getAccountid() {
		return accountid;
	}

	
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	
	public double getBalance() {
		return balance;
	}

	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	public int getLoginid() {
		return loginid;
	}

	
	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}

	
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

