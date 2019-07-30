package com.revature.bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String username, password, option, name;
		int phoneNumber;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Administrator admin = new Administrator(); // Administrator Object created to test Administrator interaction
		Employee employee = new Employee(); // Employee Object created to test Employee interaction
		Scanner sc = new Scanner(System.in);
		Customer c1 = new Customer(); // Creates a new Customer Object - move back to create
		
		Account transferAccount = new Account();
		// create a customer object
		// define that customers username, password and personal info
		// Mark the account as pending for approval or denial
		// store that object into an ArrayList that can be accessed or modified by an
		// Employee or Admin
		/**
		 * Customer Portal
		 */

		// System.out.println("What Action Would You Like To Perform?....\nEnter 1 to
		// Login.\nEnter 2 to Create An Account.");

		System.out.println(
				"What Action Would You Like To Perform?....\nEnter 1 to Login.\nEnter 2 to Create An Account.");

		option = sc.nextLine();
		boolean keepGoing = true;
		while (keepGoing) {
			// Log In
			if (option.equals("1")) {
				while (keepGoing) {
					System.out.println(
							"What Action Would You Like To Perform?....\nEnter 1 for Customer Login.\nEnter 2 for Employee Login.\nEnter 3 for Administrator Login.");
					switch (sc.nextInt()) {
					case 1: { // Customer Login
						while (keepGoing) {
							System.out.println(
									"What Action Would You Like To Perform?....\nEnter 1 to withdraw.\nEnter 2 to deposit.\nEnter 3 to transfer\nEnter 4 to Log Out.");
							switch (sc.nextInt()) {
							case 1: { // Withdraw Funds
								System.out.println("How Much Would You Like To Withdraw?");
								c1.withdraw(sc.nextDouble());
								break;
							}
							case 2: { // Deposit Funds
								System.out.println("How Much Would You Like To Deposit?");
								c1.deposit(sc.nextDouble());
								break;
							}
							case 3: { // Transfer Funds - change to account from the array
								System.out.println("How Much Would You Like To Transfer From Account "
										+ c1.getAccountNumber() + " to account " + transferAccount.getAccountNumber());
								c1.transfer(sc.nextDouble(), transferAccount);
								break;
							}
							case 4: {
								System.out.println("Logging Out...Goodbye!");
								keepGoing = false;
								break;
							}
							}
						}
						break;
					}
					case 2: { // Employee Login
						while (keepGoing) {
							System.out.println(
									"What Action Would You Like To Perform?....\nEnter 1 To Approve/Deny Account Applications.\nEnter 2 To Look Up Account.\nEnter 3 To Log Out.");
							switch (sc.nextInt()) {
							case 1: { // Approve/Deny Application
								// insert code here to check for objects that are not yet
								// approved***************************************
								while (keepGoing) {
									System.out.println(
											"What Action Would You Like To Perform?....\nEnter 1 To Approve Application.\nEnter 2 To Deny Application.\nEnter 3 To Log Out.");
									switch (sc.nextInt()) {
									case 1: { // Approve Application
										c1.setIsApproved(true);
										System.out.println("Application Approved!");
										break;
									}
									case 2: { // Deny Application
										c1.setIsApproved(false);
										System.out.println("Application Denied!");
										break;
									}
									case 3: { // Log Out
										System.out.println("Logging Out...Goodbye!");
										keepGoing = false;
										break;
									}
									}
								}
								break;
							}
							case 2: { // Look Up Account
								while (keepGoing) {
									System.out.println("Enter The Account Number You Wish To View.");
									// code here to select Customer
									// Account********************************************************
									System.out.println(
											"What Action Would You Like To Perform?....\nEnter 1 To Veiw Personal Information.\nEnter 2 To Veiw Account Balance.\nEnter 3 To Veiw Account Information.\nEnter 4 To Log Out.");
									switch (sc.nextInt()) {
									case 1: { // Veiw Personal Information
										System.out.println(
												"Personal Information For Account Number " + c1.getAccountNumber());
										System.out.println(
												"Name: " + c1.getName() + ", Phone Number: " + c1.getPhoneNumber());
										break;
									}
									case 2: { // Veiw Account Balance
										System.out
												.println("Account Balance For Account Number " + c1.getAccountNumber());
										System.out.println("$" + c1.getBalance());
										break;
									}
									case 3: { // Veiw Account Information
										System.out.println(
												"Account Information For Account Number " + c1.getAccountNumber());
										System.out.println("Username: " + c1.getName());
										System.out.println("Password: " + c1.getName());
										System.out.println("Account Approved: " + c1.getIsApproved());
										break;
									}
									case 4: { // Log Out
										System.out.println("Logging Out...Goodbye!");
										keepGoing = false;
										break;
									}
									}
								}
								break;
							}
							case 3: { // Log Out
								System.out.println("Logging Out...Goodbye!");
								keepGoing = false;
								break;
							}
							}
						}
						break;
					}
					case 3: { // Administrator Login
						while (keepGoing) {
							System.out.println(
									"What Action Would You Like To Perform?....\nEnter 1 To Approve/Deny Account Applications.\nEnter 2 To Look Up Account.\nEnter 3 To Log Out.");
							switch (sc.nextInt()) {
							case 1: { // Approve/Deny Application
								// insert code here to check for objects that are not yet
								// approved****************************************************
								while (keepGoing) {
									System.out.println(
											"What Action Would You Like To Perform?....\nEnter 1 To Approve Application.\nEnter 2 To Deny Application.\nEnter 3 To Logout.");
									switch (sc.nextInt()) {
									case 1: { // Approve Application
										c1.setIsApproved(true);
										System.out.println("Application Approved!");
										break;
									}
									case 2: { // Deny Application
										c1.setIsApproved(false);
										System.out.println("Application Denied!");
										break;
									}
									case 3: { // Log Out
										System.out.println("Logging Out...Goodbye!");
										keepGoing = false;
										break;
									}
									}
								}
								break;
							}
							case 2: { // Look Up Account
								while (keepGoing) {
									System.out.println("Enter The Account Number You Wish To View.");
									// code here to select Customer
									// Account*******************************************************************
									System.out.println(
											"What Action Would You Like To Perform?....\nEnter 1 To Veiw Personal Information.\nEnter 2 To Veiw Account Balance.\nEnter 3 To Veiw Account Information.");
									switch (sc.nextInt()) {
									case 1: { // Veiw Personal Information
										System.out.println(
												"Personal Information For Account Number " + c1.getAccountNumber());
										System.out.println(
												"Name: " + c1.getName() + ", Phone Number: " + c1.getPhoneNumber());
										break;
									}
									case 2: { // Veiw Account Balance
										System.out
												.println("Account Balance For Account Number " + c1.getAccountNumber());
										System.out.println("$" + c1.getBalance());
										break;
									}
									case 3: { // Veiw Account Information
										System.out.println(
												"Account Information For Account Number " + c1.getAccountNumber());
										System.out.println("Username: " + c1.getName());
										System.out.println("Password: " + c1.getName());
										System.out.println("Account Approved: " + c1.getIsApproved());
										break;
									}
									case 4: { // Withdraw
										System.out.println("How Much Would You Like To Withdraw?");
										c1.withdraw(sc.nextDouble());
										break;
									}
									case 5: { // Deposit
										System.out.println("How Much Would You Like To Deposit?");
										c1.deposit(sc.nextDouble());
										break;
									}
									case 6: { // Transfer
										System.out.println("How Much Would You Like To Transfer From Account "
												+ c1.getAccountNumber() + " to account "
												+ transferAccount.getAccountNumber());
										c1.transfer(sc.nextDouble(), transferAccount);
										break;
									}
									case 7: { // Cancel Account
										// code to delete selected Customer
										// Account*********************************************************
										System.out.println(
												"All Funds Removed And Given To Customer...Account Cancelled!");
									}
									case 8: { // Log Out
										System.out.println("Logging Out...Goodbye!");
										keepGoing = false;
										break;
									}
									}
								}
								break;
							}
							case 3: {
								System.out.println("Logging Out...Goodbye!");
								keepGoing = false;
								break;
							}
							}
						}
						break;
					}
					}
				}
				// Create Account
			} else if (option.equals("2")) { // If 2 is input then the following code is ran to create a customer
												// account
				System.out.println("Enter Username!");
				username = sc.nextLine(); // stores the username
				System.out.println("Enter Password!");
				password = sc.nextLine(); // Stores the password
				customers.add(c1); // Adds the Customer Object to the ArrayList of Customers
				c1.createAccount(username, password); // Creates the Customer Account
				System.out.println("What is your name?");
				name = sc.nextLine();
				c1.setName(name);
				System.out.println("What is your phone number?");
				phoneNumber = sc.nextInt();
				c1.setPhoneNumber(phoneNumber);
				break;
				// Invalid Input
			} else {
				System.out.println(
						"Invalid Input, Try Again! What Action Would You Like To Perform?....\nEnter 1 to Login.\nEnter 2 to Create An Account.");
				option = sc.nextLine();
			}
		}
	}

}
