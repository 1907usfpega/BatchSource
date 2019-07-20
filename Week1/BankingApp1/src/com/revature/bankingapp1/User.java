package com.revature.bankingapp1;

import java.util.List;

public class User {
	
	private String userName;
	private String password;
	private String clearanceLevel;
	private List<String> accounts;
	
	//public void addAccount(Str)
	
	
	

	@Override
	public String toString() {
		return "| " + userName + " | " + password + " | " + clearanceLevel
				+ " | " + accounts;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getClearanceLevel() {
		return clearanceLevel;
	}
	public void setClearanceLevel(String clearanceLevel) {
		this.clearanceLevel = clearanceLevel;
	}
	public List<String> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<String> accounts) {
		this.accounts = accounts;
	}
	public User() {
		
	}
	public User(String name, String pass, String clearance) {
		this.userName = name;
		this.password = pass;
		this.clearanceLevel = clearance;
		
	}

}
