package com.revature.bankingapppt1_2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1164597552643650754L;

	private String uniqueID;
	private String accountType;
	private double balance;
	private List<String> users = new ArrayList<String>();
	private String status;

	public Account(String ID, String type, String initialUser) {
		this.uniqueID = ID;
		this.accountType = type;
		this.balance = 0;
		this.users.add(initialUser);
		this.status = "Pending";
	}
	public Account(String ID, String type, double bal, String status) {
		this.uniqueID = ID;
		this.accountType = type;
		this.balance = bal;
		this.status = status;
	}
	public Account(String ID, String type, double bal, String status, List<User> userL) {
		this.uniqueID = ID;
		this.accountType = type;
		this.balance = bal;
		this.status = status;
		for(User u : userL)
			this.users.add(u.getUserName());
	}

	public void approve() {
		this.status = "Approved";
	}

	public void deny() {
		this.status = "Denied";
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	public void updateBalance(double change) {
		this.balance += change;
		this.balance = Math.round(this.balance * 100.0) / 100.0;
	}

	public void addUser(String newUser) {
		this.users.add(newUser);
	}

	public boolean removeUser(String oldUser) {
		if (this.users.size() > 1) {
			this.users.remove(oldUser);
			return true;
		}
		return false;
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
		System.out.println(this.toString());
	}

	@Override
	public boolean equals(Object a) {
		if(a instanceof Account) {
		if(((Account) a).getUniqueID() == this.getUniqueID()) {
			return true;
		}
		}
		return false;
		
	}

	@Override
	public String toString() {
		return "| ID: " +uniqueID + " | Type: "+ accountType + " | Bal: " 
				+ balance + " | Status: " + status + " | Users: " + users;
	}
}
