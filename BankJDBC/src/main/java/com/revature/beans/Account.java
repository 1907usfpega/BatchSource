package com.revature.beans;

public class Account {
	private int accountID;
	private String accountType;
	private String accountName;
	private int balance;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accountID, String accountName, String accountType, int balance) {
		super();
		this.accountID = accountID;
		this.accountType = accountType;
		this.accountName = accountName;
		this.balance = balance;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return accountType + " Account \"" + accountName + "\" balance: $" + balance;
	}

}
