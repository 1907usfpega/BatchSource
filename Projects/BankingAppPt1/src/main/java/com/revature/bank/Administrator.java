package com.revature.bank;

import java.util.ArrayList;

public class Administrator extends Employee {

	private String username = "admin", password = "revature";
	
	public void withdraw(Account account, double amount) {
		account.withdraw(amount);
	}
	
	public void deposit(Account account, double amount) {
		account.deposit(amount);
	}
	
	public void transfer(Account account, Account transfer, double amount) {
		account.transfer(amount, transfer);
	}
	
	public ArrayList<Customer> cancelAccount(Customer customer, ArrayList<Customer> arrayList) {
		for(int i = 0; i < arrayList.size(); i++) {
			if(customer == arrayList.get(i)) {
				arrayList.remove(i);
			}
		}
		return arrayList;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}

