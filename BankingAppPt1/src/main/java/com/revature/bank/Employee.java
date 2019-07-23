package com.revature.bank;

public class Employee {

	private String username = "employee", password = "revature";
	
	public void approve(Customer account) {
		account.setIsApproved(true);
		System.out.println(account.getName() + "'s Account has Been Approved!");
		System.out.println("");
		account.setAccountNumber(account.getTotalCustomerCount());
	}
	
	public void deny(Customer account) {
		account.setIsApproved(false);
	}
	
	public void viewPersonalInfo(Customer account) {
		System.out.println("Name: " + account.getName() + "		Phone Number: " + account.getPhoneNumber());
		System.out.println("Account Number: " + account.getAccountNumber());
		System.out.println("Joint Account: " + account.getAppliedForJointAccount());
		System.out.println("Approved: " + account.getIsApproved());
	}
	
	public void viewAccountBalance(Customer account) {
		System.out.println("Current Balance for " + account.getName() + ": $" + account.getBalance());
	}
	
	public void viewAccountInformation(Customer account) {
		System.out.println("Account Information for " + account.getName());
		System.out.println("Username: " + account.getUsername());
		System.out.println("Password: " + account.getPassword());
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
