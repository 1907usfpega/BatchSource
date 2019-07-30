package com.revature.beans;


import com.revature.menus.MenuOptions;

public class Account {

	private String uniqueID;
	private String accountType;
	private double balance;
	private String status;

	public Account(String ID, String type, String initialUser) {
		this.uniqueID = ID;
		this.accountType = type;
		this.balance = 0;
		this.status = "Pending";
	}

	public Account(String ID, String type, double bal, String status) {
		this.uniqueID = ID;
		this.accountType = type;
		this.balance = bal;
		this.status = status;
	}

	public void approve() {
		this.status = "Approved";
	}

	public void deny() {
		this.status = "Denied";
	}

	public void updateBalance(double change) {
		this.balance += change;
		this.balance = Math.round(this.balance * 100.0) / 100.0;
	}

	//////// GETTERS AND SETTERS ////////
	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void printAccount() {
		System.out.println(this.toString() + MenuOptions.anu.allUsers(Integer.parseInt(uniqueID)));
	}

	@Override
	public boolean equals(Object a) {
		if (a instanceof Account) {
			if (((Account) a).getUniqueID() == this.getUniqueID()) {
				return true;
			}
		}
		return false;

	}

	@Override
	public String toString() {
		return "| " + uniqueID + " | " + accountType + " | Bal: " + balance + " | " + status + " | ";
	}
}
