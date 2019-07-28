package com.revature.BankApp0;

import java.util.Scanner;

public class Driver {

	static Scanner sc = new Scanner(System.in);
	static String username = "";
	static String password = "";

	public static void main(String[] args) {
		Util util = new Util();
		Menu menu = new Menu();
		menu.puar();
		boolean newUser = newUser();
		boolean loginSuccessful = false;
		
		if(!newUser) {
			loginSuccessful = login();
			if (!loginSuccessful) {
				return;
			}
		} else {
			// NEW USER, AUTOMATICALLY LOG THEM IN.
		}

		sc.close();
	}

	public static boolean newUser() {
		String un;
		String pw;
		String vpw;
		String newUser;

		System.out.print("\n\nWelcome to the Saiyan Banking Network!\nIs this your first time logging in? (y/n): ");
		do {
			newUser = sc.nextLine();
			newUser = newUser.toLowerCase();
			boolean available = true;
			if (newUser.equals("y")) {
				do {
					System.out.print("Please enter a username: ");
					un = sc.nextLine();
					if (userNameFound(un)) {
						System.out.println("Username has already been taken.\n");
					}
				} while (userNameFound(un));

				System.out.print("Please enter a password: ");
				pw = sc.nextLine();
				System.out.print("Please re-enter your password: ");
				vpw = sc.nextLine();
				while (!pw.equals(vpw)) {
					System.out.print("Passwords did not match.\n\nPlease enter a password: ");
					pw = sc.nextLine();
					System.out.print("Please re-enter your password: ");
					vpw = sc.nextLine();
				}
				// TODO: Add new user to SQL Database
				
				//
				username = un;
				password = pw;
				System.out.println("Account has been created. Logging you in.\n\n");
				return true;

			} else if (!newUser.equals("n")) {
				System.out.println("Invalid input, please enter y or n");
			}

		} while (!newUser.equals("y") && !newUser.equals("n"));

		System.out.println("Redirecting you to the log in screen.\n");
		return false;
	}

	public static boolean userNameFound(String un) {
		// TODO: Check SQL Database to see if user name exists.
		return false;
	}

	public static boolean login() {
		// TODO: Attempt to log user in to SQL database.
		System.out.print("Enter your User Name: ");
		username = sc.nextLine();
		if(userNameFound(username)) {
			
		} else {
			
		}
		
		return false;
	}
	
}
