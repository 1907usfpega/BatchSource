package com.revature.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

public class Account implements Serializable{

	// acc has ArrayList<User>, current balance, boolean isJoint, boolean isApproved
	// constructor, getter & setter, AND toString
	HashMap<User, Boolean> userApproval = new HashMap<User, Boolean>();
	final int accountNumber;
	double currentBalance;
	static int accountCount;

	private Account(User user, double currentBalance, int accountNumber) {
		userApproval.put(user, false);
		this.currentBalance = currentBalance;
		this.accountNumber = accountNumber;
		accountCount++;
	}

	public Account(User user, double CurrentBalance) {
		this(user, CurrentBalance, accountCount);
	}

	public Account(User user) {
		this(user, 0);
	}
	public void addUser(User user) {
		userApproval.put(user, false);
	}
	public static int getAccountCount() {
		return accountCount;
	}
	
	
	public void setApproval(User user) {
		userApproval.replace(user, true);
	}
	
	public void rejectApplication(User user) {
		userApproval.remove(user);
	}
	
	public boolean checkApprovals() {
		return userApproval.containsValue(false);
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public boolean isApproved(User user) {
		return userApproval.get(user);
	}

	public Set<User> getUsers() {
		return userApproval.keySet();
	}

	public double getCurrentBalance() {
		return this.currentBalance ;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	@Override
	public String toString() {
		try {
			return "[Account Owner= " + userApproval.keySet().toArray()[0] + ", CurrentBalance= " + currentBalance
					+ ", isJoint= " + (userApproval.size() > 1) + ", AccountIndex= " + this.accountNumber +"]";
		} catch (Exception e) {
			return  "CurrentBalance= " + currentBalance
					+  ", AccountIndex= " + this.accountNumber +"]";
	
		}

	}

}
