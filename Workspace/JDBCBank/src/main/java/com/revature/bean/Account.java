package com.revature.bean;

public class Account {
	private int account_id;
	private double balance;
	private int user_id;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int account_id, double balance, int user_id) {
		super();
		this.account_id = account_id;
		this.balance = balance;
		this.user_id = user_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", balance=" + balance + ", user_id=" + user_id + "]";
	}
	
	

}
