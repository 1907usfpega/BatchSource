package com.revature.driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.bean.Account;
import com.revature.bean.User;
import com.revature.daoimpl.AccountDaoImpl;
import com.revature.daoimpl.UserDaoImpl;

public class Driver {
	public static ArrayList<User> allUsers = new ArrayList<User>();
	public static User loggedInUser = null;

	public static void main(String[] args) {
		UserDaoImpl udi = new UserDaoImpl();
		try {
			allUsers = udi.getUserList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("New added text");
		
		
		// create user
		/*
		 * UserDaoImpl udi = new UserDaoImpl(); try { udi.createUser("Shecky Greene",
		 * "300879"); } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		// delete user
		/*
		 * UserDaoImpl udi2 = new UserDaoImpl(); try { udi2.deleteUser(1); } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		// view all users

		/*
		 * UserDaoImpl udi3 = new UserDaoImpl(); try {
		 * System.out.println(udi3.getUserList()); } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */

		/*
		 * UserDaoImpl udi4 = new UserDaoImpl(); try { udi4.updateUser(1,
		 * "Chilly Willy", "password"); } catch (SQLException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); }
		 */

		
		
		 

		/*
		 * AccountDaoImpl adi2 = new AccountDaoImpl(); try { adi2.deleteAccount(2); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		/*
		 * AccountDaoImpl adi3 = new AccountDaoImpl(); try { adi3.updateBalance(4,
		 * 200.00); } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		/*
		 * AccountDaoImpl adi4 = new AccountDaoImpl(); try {
		 * System.out.println(adi4.geAccountList()); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		run();
	}

	public static void run() {
		// PromptCollection promptList = new PromptCollection();
		// promptList.initialize();
		// int mainMenuChoice = printChoicePrompt(promptList.test);

		Scanner s = new Scanner(System.in);
		boolean q = false;
		do {
			System.out.println("Welcome!\n\t1. Login\n\t2. Create Account\n\t3. Quit");
			int mainMenuChoice = s.nextInt();
			switch (mainMenuChoice) {
			case 1:
				System.out.println("Login Sequence begin");
				login();
				break;
			case 2:
				System.out.println("Account creation sequence begin");
				createUserAccount();
				break;
			case 3:
				q = true;
				break;
			default:
				System.out.println("That is not a valid input. ");
				break;
			}
		} while (q == false);
	}

	public static void login() {
		System.out.print("Enter your username: ");
		Scanner s = new Scanner(System.in);
		String userNameInput = s.nextLine();
		System.out.print("Enter your password: ");
		String passwordInput = s.nextLine();
		for (int i = 0; i < allUsers.size(); i++) {
			if (userNameInput.equals(allUsers.get(i).getUsername())
					&& passwordInput.equals(allUsers.get(i).getPassword())) {
				loggedInUser = allUsers.get(i);
				mainUserMenu();
				return;
			}
		}
		// s.close();
		System.out.println("That login was not found in our database");
		// mainCustomerMenu(loggedInAccount);
	}

	public static void createUserAccount() {
		UserDaoImpl udi = new UserDaoImpl();
		
		Scanner s = new Scanner(System.in);
		// UserAccount.AccountType type = UserAccount.AccountType.Customer;
		String userNameInput = "", passwordInput = "";
		System.out.print("Enter your username: ");
		userNameInput = s.nextLine();
		System.out.print("Enter your password: ");
		passwordInput = s.nextLine();

		for (int i = 0; i < allUsers.size(); i++) {
			if (userNameInput.equals(allUsers.get(i).getUsername())) {
				System.out.println("That username already exists");
				return;
			} else {
				try {
					System.out.println(userNameInput + "  ||  " + passwordInput);
					udi.createUser(userNameInput, passwordInput);
					allUsers = udi.getUserList();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}

	public static void mainUserMenu() {
		UserDaoImpl udi = new UserDaoImpl();
		AccountDaoImpl adi = new AccountDaoImpl();
		try {
			adi.createAccount(25);
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Account> loggedInUserAccounts = new ArrayList<Account>();
		int selection = 0;
		do {
			
		
		try {
			loggedInUserAccounts = udi.getAccountList(loggedInUser.getUser_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Here are your Accounts: " + loggedInUserAccounts);
		System.out.println("You can logout now or create an account\nSelect 1 to logout\nSelect 2 to create Account");
		Scanner input = new Scanner(System.in);
		try {
			selection = input.nextInt();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: Please enter a valid number");
			continue;
		}
		if (selection == 1) {
			System.out.println("Bye, " + loggedInUser.getUsername() + "\nYou logged out!");
			loggedInUser = null;
			return;
		} else if (selection == 2) {
			try {
				adi.createAccount(loggedInUser.getUser_id());
				System.out.println("Your Account was created.");
				continue;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Please enter a valid number.");
			continue;
		}
		} while (selection != 1);
			

	}

}
