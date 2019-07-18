package com.revature.MoneyFolder;

import java.util.Scanner;

public class MoneyFolder {

	public static void main(String[] args) {
		// Variables
		Scanner keyboardScanner = new Scanner(System.in);
		String newCustomer;
		String userName;
		String password;
		String verifyPassword;
		
		System.out.print("Welcome to the Money Folder Electronic Banking System!\n\nAre you a new customer? (y/n): ");
		
		// Determining if a customer is new
		do {
			newCustomer = keyboardScanner.nextLine();
			newCustomer = newCustomer.toLowerCase();
			// New Customer
			if (newCustomer.equals("y")) {
				System.out.print("Please enter a username: ");
				userName = keyboardScanner.nextLine();
				System.out.print("Please enter a password: ");
				password = keyboardScanner.nextLine();
				System.out.print("Please re-enter your password: ");
				verifyPassword = keyboardScanner.nextLine();
				while (!password.equals(verifyPassword)) {
					System.out.print("Passwords did not match.\n\nPlease enter a password: ");
					password = keyboardScanner.nextLine();
					System.out.print("Please re-enter your password: ");
					verifyPassword = keyboardScanner.nextLine();
				}
				System.out.println("Account has been successfully created, you will now be redirected to user log in.");
			// Checking for valid input
			} else if (!newCustomer.equals("n")) {
				System.out.println("Invalid input, please enter y or n");
			}
		} while (newCustomer.equals("y") && newCustomer.equals("n")); // Start over if invalid input, if customer is not new they
																	  // can proceed to the log in stage.
		
		
		
		keyboardScanner.close();
	}

}
