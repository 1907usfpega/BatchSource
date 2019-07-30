package com.revature.bank;

public class Customer extends Account {

	//Data Variables
	private String username, password, name;
	private int  phoneNumber, totalCustomerCount = 2;
	
	public void createAccount(String username, String password) {
		this.username = username;
		this.password = password;
		addToCustomerCount();
	}
	
	public void applyForJointAccount() {
		setAppliedForJointAccount(true);
	}
	
	public void setPersonalInfo(String name, int phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public int getTotalCustomerCount() {
		return totalCustomerCount;
	}

	public void addToCustomerCount() {
		totalCustomerCount = totalCustomerCount + 1;
	}
}
