package com.revature.driver;

import java.util.Iterator;
import java.util.Scanner;

import com.revature.database.Database;
import com.revature.user.User;

public class Driver {
	static Scanner sc;
	static final int LOGIN = 1;
	static final int NEW_ACCT = 2;
	static final int NEW_EMP = 3;
	static final int NEW_ADMIN = 4;

	static final String EMPLOYEE_CODE = "1234";
	static final String ADMIN_CODE = "4321";

	public static void main(String[] args) {
		Database.readUsers();
		Database.readAccounts();

		boolean q = false;

		System.out.println("Welcome to Diemer & co. banking!\n");
		while (!q) {
			System.out.println("Please choose an option from the menu below:\n");
			System.out.println(LOGIN + ".\t Login");
			System.out.println(NEW_ACCT + ".\t Register as a new User");
			System.out.println(NEW_EMP + ".\t Register as a new Employee");
			System.out.println(NEW_ADMIN + ".\t Register as a new Admin");
			System.out.println("\nQ.\t Quit the Application");
			sc = new Scanner(System.in);
			String input = sc.nextLine();
			int ch;
			if (input.toUpperCase().equals("Q")) {
				q = true;
			} else {
				try {
					ch = Integer.parseInt(input);
					switch (ch) {
					case LOGIN:
						login();
						break;
					case NEW_ACCT:
						registerAsUser();
						break;
					case NEW_EMP:
						registerAsEmployee();
						break;
					case NEW_ADMIN:
						registerAsAdmin();
						break;
					default:
						System.out.println("Invalid Input");
					}
				} catch (NumberFormatException e) {
					System.out.println("Please enter a number.");
					continue;
				} // catch
			} // end else (not q)
		} // end not q;
		System.out.println("Thank You for banking with Diemer & co.");
		sc.close();
		return;
	}

	private static void registerAsUser() {
		register(0, 0);
	}

	private static void registerAsEmployee() {
		System.out.println("Enter validation code.");
		String code = sc.nextLine();
		if (code.equals(EMPLOYEE_CODE)) {
			register(1234, 0);
		}
	}

	private static void registerAsAdmin() {
		System.out.println("Enter validation code.");
		String code = sc.nextLine();
		if (code.equals(ADMIN_CODE)) {
			register(1234, 4321);
		}
	}

	public static void login() {
		boolean found = false;
		System.out.println("Please Enter Your UserName:");
		String input = sc.next();
		// found = Database.userExists(input);
		Iterator<User> itr = Database.pList.iterator();
		while (itr.hasNext()) {
			User b = itr.next();
			if (input.equalsIgnoreCase(b.getUserName())) {
				b.login();
				found = true;
				break;
			}
		}
		if (!found)
			System.out.println("Username not Found");
	}

	public static void register(int isEmployee, int isAdmin) {
		boolean found;
		String use = null;
		do {
			System.out.println("Enter new username");
			use = sc.next();
			found = Database.userExists(use);
			if (found) {
				System.out.println("That UserName is taken, please use a new one");
			}
		} while (found);

		boolean match = false;
		String pass;
		do {
			System.out.println("Enter password");
			pass = sc.next();
			System.out.println("Confirm password");
			String conPass = sc.next();
			match = pass.equals(conPass);
			if (!match) {
				System.out.println("Passwords do not match.\n");
			}
		} while (!match);
		System.out.println("Enter full name:");
		sc.nextLine();
		String fname =sc.next();
		String lname = sc.next();
		User.register(use, pass, fname, lname, isEmployee, isAdmin);
		System.out.println("You have been registered.");
	}
}