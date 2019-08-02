package com.revature.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

public class Account implements Serializable{

	private int accountId;
	private int balance;
	private int userId;
	
	public Account() {}
	public Account(int accountId, int balance, int userId) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", userId=" + userId + "]";
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = (int)balance;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
