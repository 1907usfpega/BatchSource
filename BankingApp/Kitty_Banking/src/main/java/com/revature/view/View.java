package com.revature.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
//kitty banking
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.daoimpl.UserDaoImpl;
import com.revature.driver.Driver;
import com.revature.util.ConnFactory;

public class View {
	public static ConnFactory cf = ConnFactory.getInstance();
	static String input = "";
	static final int MINIMUMNAMELENGTH = 3;
	static final int MAXIMUMNAMELENGTH = 10;
	static final int MINIMUMPASSLENGTH = 3;

	public static void startView() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to kittycats banking bash!(^_^) \n To log in, enter -l, or to "
				+ "register an account, enter -r, -x to close. \n\n");
		input = sc.nextLine();
		if (input.length() < 2 || input.charAt(0) != '-') {
			System.out.println("Choose -r or -l   (^_^)");
			startView();
		}

		switch (input.charAt(1)) {
		case ('l'):
			loginView();
			break;
		case ('r'):
			registerView();
			break;
		case ('x'):
			System.exit(0);
			;
			break;
		default:
			System.out.println("Choose -r or -l   (^_^)");
			startView();
			break;
		}

	}

	// loginview
	public static void loginView() {
		Scanner sc = new Scanner(System.in);
		System.out.println("To login, enter your user name now. To cancel, enter -c");

		input = sc.nextLine();
		if (input.equals("-c")) {
			System.out.println("You cancelled the login and are back at the start screen.");
			startView();
		}
		if (input.length() < MINIMUMNAMELENGTH) {
			System.out.println("Usernames are longer than two character. To cancel, enter -c");
			loginView();
		}
		String userName = input;
		System.out.println("please now give password or cancel with -c");
		sc = new Scanner(System.in);
		input = sc.nextLine();
		if (input.equals("-c")) {
			System.out.println("You cancelled the login and are back at the start screen."); // extract that method?
																								// ("login",
																								// redirectViewIndex)
			startView();
		}
		if (input.length() < MINIMUMPASSLENGTH) {
			System.out.println("Too short of a password - please try again!");
			loginView();
		}
		String password = input;
		Driver.loginUser(userName, password);
	}

	// register view
	public static void registerView() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome! Please enter a Username, longer than one character. "
				+ "You may not choose a name that already exists. -c to return to the main menu.");
		input = sc.nextLine();
		if (input.equals("-c")) {
			System.out.println("You cancelled the registration and are back at the start screen.");
			startView();
		}
		if (MAXIMUMNAMELENGTH < input.length() || input.length() < MINIMUMNAMELENGTH) {
			System.out.println("Your name should consist of 3 to 10 characters. Please try again.");
			registerView();
		}
		String userName = input;
		System.out.println(
				"Now please enter a strong password with at least 3 characters. enter -c to return to the main menu");
		sc = new Scanner(System.in);
		input = sc.nextLine();
		if (input.equals("-c")) {
			System.out.println("You cancelled the registration and are back at the start screen.");
			startView();
		}
		if (input.length() < MINIMUMPASSLENGTH) {
			System.out.println("Password should be longer! Please enter more than 3 letters.");
			registerView();
		}
		String password = input;
		Driver.registerUser(userName, password, 0, 0); // STRING STRING vs STRING INT
	}

	public static void customerView() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome, " + Driver.getCurrentUserName()
				+ "! You are in your main menu. If you wish to display your accounts to make withdraws, "
				+ "deposits, transfers, or apply for a new account, please enter -a. To log out, enter -logout ");
		input = sc.nextLine();
		if (input.equals("-logout")) {
			Driver.logout();
		}
		if (input.equals("-a")) {
			accountsView();
		}
		customerView();
	}

	public static void accountsView() {
//		Connection conn = cf.getConnection();
		Scanner sc = new Scanner(System.in);
		ArrayList<Account> accounts = Driver.getCurrentUserAccounts();
		System.out.println(accounts);
		
		System.out.println(" To Create an account, enter -g To deposit, withdraw, or delete an account, please enter -d, -w, -r respectively. "
			 + " To return to the previous menu, enter -c");
		input = sc.nextLine();
		if (input.length() != 2 || input.charAt(0) != '-') {
			System.out.println("Enter -d, -w, -r, or -c next time, so your command can be understood.");
			accountsView();
		}
		sc = new Scanner(System.in);
		switch (input.charAt(1)) {
		case ('g'):
			createAccountView();
			break;
		case ('d'):
			depositView();
			break;
		case ('w'):
			withdrawView();
			break;
		case ('c'):
			System.out.println("Back to your main menu!");
			customerView();
			break;
		case('r'):
			deleteView();
			break;
		}

	}
	// deposit, withdraw, transfer

	public static void depositView() {
		Scanner sc = new Scanner(System.in);
		double intput = 0.00;
		ArrayList<Account> accounts = Driver.getCurrentUserAccounts();
		//Account newAcc = new Account();
		System.out.println("Available Accounts:");
		for (Account account : accounts) {
			System.out.println(account);
		}
		System.out.println(
				"Choose an account with which to make a deposit by entering the Number now. You may cancel with -c.");
		try {
			input = sc.nextLine();
			if (input.equals("-c")) {
				System.out.println("you returned to the main menu");
				customerView();
			} else {
				intput = Integer.parseInt(input);
			}
		} catch (Exception e) {
			System.out.println("please enter a number or -c");
			depositView();
		}
		int accountID = Integer.parseInt(input);
		int acctID = accounts.get(Integer.parseInt(input)).getAccountId();
		sc = new Scanner(System.in);
		System.out.println("How much would you like to deposit?");
		try {
			input = sc.nextLine();
			if (input.equals("-c")) {
				System.out.println("you returned to the main menu");
				customerView();
			} else {
				intput = Double.parseDouble(input);
				UserDaoImpl udi = new UserDaoImpl();
				udi.depositBalance(Integer.valueOf(input), acctID);

			}
		} catch (Exception e) {
			System.out.println("please enter a number or -c");
			depositView();
		}

		Driver.deposit(intput, accountID);

	}

	public static void withdrawView() {
		Scanner sc = new Scanner(System.in);
		double intput = 0.00;
		ArrayList<Account> accounts = Driver.getCurrentUserAccounts();
		System.out.println("Available Accounts:");
		for (Account account : accounts) {
			System.out.println(account);
		}
		System.out.println(
				"Choose an account with which to make a withdraw by entering the Number now. You may cancel with -c.");
		try {
			input = sc.nextLine();
			if (input.equals("-c")) {
				System.out.println("you returned to the main menu");
				customerView();
			} else {
				intput = Integer.parseInt(input);
			}
		} catch (Exception e) {
			System.out.println("please enter a number or -c");
			withdrawView();
		}
		sc = new Scanner(System.in);
		int accountID = Integer.parseInt(input);
		int acctID = accounts.get(accountID).getAccountId();
		System.out.println("How much would you like to withdraw?");
		try {
			input = sc.nextLine();
			if (input.equals("-c")) {
				System.out.println("you returned to the main menu");
				customerView();
			} else {
				intput = Double.parseDouble(input);
				UserDaoImpl udi = new UserDaoImpl();
				udi.withdrawBalance(Integer.valueOf(input), acctID);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("please enter a number or -c");
			withdrawView();
		}

		Driver.withdraw(intput, accountID);
	}
	
	public static void deleteView()
	{
		Scanner sc = new Scanner(System.in);
		double intput = 0.00;
		ArrayList<Account> accounts = Driver.getCurrentUserAccounts();
		System.out.println("Available Accounts:");
		for (Account account : accounts) {
			System.out.println(account);
		}
		System.out.println(
				"Choose an account with which to delete by entering the Number now. You may cancel with -c.");
		try {
			input = sc.nextLine();
			if (input.equals("-c")) {
				System.out.println("you returned to the main menu");
				customerView();
			} else {
				intput = Integer.parseInt(input);
			}
		} catch (Exception e) {
			System.out.println("please enter a number or -c");
			deleteView();
		}
		sc = new Scanner(System.in);
		int accountID = Integer.parseInt(input);
		int acctID = accounts.get(Integer.parseInt(input)).getAccountId();
		intput = Double.parseDouble(input);
		UserDaoImpl udi = new UserDaoImpl();
		try {
			udi.deleteAccount(acctID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		Driver.deleteAcct(accountID);
	}
	
	public static void createAccountView() {
		
		UserDaoImpl udi = new UserDaoImpl();
		try {
			udi.createAccount(Driver.getCurrentUser().getUserId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Account Created!");
				
	}

}