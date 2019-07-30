//@JustinHua

package com.revature.pojo;

public class BankAccount {
	private int accountID;
	private double balance;
	private String type;
	private int userID;
	
	public BankAccount(int accountID, double balance) {
		super();
		this.accountID = accountID;
		this.balance = balance;
		this.type = type;
	
	}
	
	public BankAccount(int accountID, double balance, int userID) {
		super();
		this.accountID = accountID;
		this.balance = balance;
		this.type = type;
		
	}
	
	public int getAccountID() {
		return accountID;
	}
	
	public void setAccountID(int accountID) {
		this.accountID = accountID;

	}
	public double getBalance() {
		return balance;
		
	}
	public void setBalance(double balance) {
		this.balance = balance;
		
	}
	public String getType() {
		return type;
		
	}
	public void setType(String type) {
		this.type = type;
	}
}
