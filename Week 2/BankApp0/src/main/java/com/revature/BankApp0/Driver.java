package com.revature.BankApp0;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import daoimpl.AccountDaoImpl;
import daoimpl.UserDaoImpl;

public class Driver {

	static Scanner sc = new Scanner(System.in);
	static String username = "";
	static String password = "";

	public static void main(String[] args) {
		Menu.puar();
		boolean newUser = false;
		newUser = newUser();
		boolean loginSuccessful = false;

		if (!newUser) {
			loginSuccessful = login();
			if (!loginSuccessful) {
				sc.close();
				return;
			}
		}

		if (username.equals("Goku")) {

		} else {
			Menu.cls();
			Menu.puar();
			System.out.println("Welcome back " + username + "!");
			int inToInt = 0;
			String input = "";
			while (inToInt != 6) {
				Menu.mainMenu();
				System.out.print("> ");
				input = sc.nextLine();
				if(Util.isInteger(input)) {
					inToInt = Integer.parseInt(input);
				} else {
					Menu.cls();
					Menu.puar();
					System.out.println("Invalid Input: You must enter a number!");
					continue;
				}
				switch(inToInt) {
				case 1:
					break;
				case 2:
					Menu.createAccountMenu();
					System.out.print("> ");
					input = sc.nextLine();
					try {
						AccountDaoImpl adi = new AccountDaoImpl();
						UserDaoImpl udi = new UserDaoImpl();
						adi.createAccount(input, udi.getUID(username));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Menu.cls();
					Menu.puar();
					System.out.println("Successfully Created Account!");
					break;
				case 3:
					Menu.deleteAccountMenu();
					System.out.print("> ");
					input = sc.nextLine();
					try {
						AccountDaoImpl adi = new AccountDaoImpl();
						UserDaoImpl udi = new UserDaoImpl();
						adi.deleteAccount(input, udi.getUID(username));
					} catch (SQLException e) {
						e.printStackTrace();
					}
					Menu.cls();
					Menu.puar();
					System.out.println("Successfully Deleted Account!");
					break;
				case 4:
					Menu.deposit1();
					input = sc.nextLine();
					// TODO: Check for Double Value (i.e., %#.##)
					if(!Util.isValidDouble(input)) System.out.println("That is not a valid dollar amount.\n");
					Menu.deposit2();
					
					break;
				case 5:
					break;
				case 6:
					Menu.cls();
					Menu.puar();
					break;
				default:
					Menu.cls();
					Menu.puar();
					System.out.println("Hey! Are you trying to push the odds in favor of Krillin!?\n");
					break;
				}
			}

		}

		System.out.println("Goodbye " + username + "!");
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
			if (newUser.equals("y")) {
				UserDaoImpl udi = new UserDaoImpl();
				boolean unique = false;
				do {
					System.out.print("Please enter a username: ");
					un = sc.nextLine();
					try {
						if (!udi.uniqueUserName(un)) {
							System.out.println("Username has already been taken.\n");
						} else {
							unique = true;
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} while (!unique);

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
				username = un;
				password = pw;
				try {
					udi.createUser(username, password);
				} catch (SQLIntegrityConstraintViolationException e) {
					// TODO Auto-generated catch block
					System.out.println("Username has already been taken, please try again.");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Account has been created. Logging you in.\n\n");
				return true;

			} else if (!newUser.equals("n")) {
				System.out.println("Invalid input, please enter y or n");
			}

		} while (!newUser.equals("y") && !newUser.equals("n"));

		System.out.println("Redirecting you to the log in screen.\n");
		return false;
	}

	public static boolean login() {
		// TODO: Attempt to log user in to SQL database.
		UserDaoImpl udi = new UserDaoImpl();
		boolean success = false;
		int count = 0;
		while (!success) {
			try {
				System.out.print("Enter your User Name: ");
				username = sc.nextLine();
				success = !udi.uniqueUserName(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!success && count < 2) {
				System.out.println("Username Not Found\n");
				count += 1;
			} else if (count == 2) {
				System.out.println("Login Failed, Please Try Again Later.");
				break;
			}
		}
		if (!success)
			return success;

		count = 0;
		success = false;

		while (!success) {
			try {
				System.out.print("Enter your Password: ");
				password = sc.nextLine();
				success = udi.correctPassword(username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!success && count < 2) {
				System.out.println("Incorrect Password");
				count += 1;
			} else if (count == 2) {
				System.out.println("Login Failed, Please Try Again Later.");
				break;
			}
		}

		return success;
	}

}
