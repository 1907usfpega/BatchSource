package com.revature.beans;

public class Account {
	private int id;
	private int balance;
	private int userId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", userId=" + userId + "]";
	}
	public Account(int id, int balance, int userId) {
		super();
		this.id = id;
		this.balance = balance;
		this.userId = userId;
	}
	public Account() {
		
	}
}
