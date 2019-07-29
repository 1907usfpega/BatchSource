package com.revature.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.driver.Driver;

/*
 * Scanner = new Scanner() to reset.
 * input = sc.nextLine() to read the next input.
 * switch(input.toCharArray()[1]){ case(l): ...;break; case(r):...  to interpret the input
 *
 * 	 
 */

public class View {
	static String input = "";
	static final int MINIMUMNAMELENGTH = 3;
	static final int MAXIMUMNAMELENGTH = 10;
	static final int MINIMUMPASSLENGTH = 3;

	public static void catReader() {
		String path = "src/main/resources/lazyCat.txt";
		FileInputStream is = null;
		StringBuilder sb= new StringBuilder();
		int b = 0;
		try {
			File file = new File(path);
			is = new FileInputStream(file);
			while ((b = is.read()) != -1) {
				char c = (char) b;
					sb.append(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println(sb);
	}

	public static void startView() {
		Scanner sc = new Scanner(System.in);

		String cat1 = ":~-._                                                  _.-~:";
		String cat2 = ": :.~^o._        ________---------________        _.o^~.:.:";
		String cat3 = ": ::.`?88booo~~~.::::::::...::::::::::::..~~oood88P'.::.:";
		String cat4 = ":  ::: `?88P .:::....         ........:::::. ?88P' :::. :";
		String cat5 = " :  :::. `? .::......      . ...........:::. P' .:::. :";
		String cat6 = "   :  :::  .... .......       .. .::::......::.   :::. :";
		String cat7 = "   `  :' .... .. ..:::::.     . ..:::::::....:::.  `: .'";
		String cat8 = "   ' :..    ____:::::::::.  . . ....:::::::::____  ... :";
		String cat9 = "    :... `:~    ^~-:::::..  .........:::::-~^    ~::.::::";
		String cat10 = "    `.::. `|   ($) \b:::::..::.:.:::::::d/  ($)   /'.::::'";
		String cat11 = "     ::::.  ~-._v    |b.::::::::::::::d|    v_.-~..:::::";
		String cat12 = "    `.:::::... ~~^?888b..:::::::::::d888P^~...::::::::'";
		String cat13 = "     `.::::::::::....~~~ .:::::::::~~~:::::::::::::::'";
		String cat14 = "     `..:::::::::::   .   ....::::    ::::::::::::,'";
		String cat15 = "        `. .:::::::    .    .::::::.    "
				+ "::::::::'.'";
		String cat16 = "         `._ .:::    .       .:::::.    :::::_.'";
		String cat17 = "            `-. :    .       .:::::      :,-'";
		String cat18 = "               :.   :___     .:::___   .::";
		String cat19 = "     ..--~~~~--:+::. ~~^?b..:::dP^~~.::++:--~~~~--..";
		String cat20 = "       ___....--`+:::.    `~8~'    .:::+'--....___";
		String cat21 = "       ~~   __..---`_=:: ___gd8bg___ :==_'---..__   ~~";
		String cat22 = "      -~~~  _.--~~`-.~~~~~~~~~~~~~~~,-' ~~--._ ~~~-";
		String cat23 = "         -~~            ~~~~~~~~~   _ ___ _  ~~-";
		String[] meanCat = new String[] { cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10, cat11, cat12,
				cat13, cat14, cat15, cat16, cat17, cat18, cat19, cat20, cat21, cat22, cat23 };
		for (String cat : meanCat) {
			System.out.println(cat);
		}
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
			System.exit(0);;
			break;
		default:
			System.out.println("Choose -r or -l   (^_^)");
			startView();
			break;

		}
	}

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
		Driver.registerUser(userName, password);
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

	public static void employeeView() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome, " + Driver.getCurrentUserName()
				+ "! You are in your main menu. If you wish to display the open applications to make reject or deny those, enter -a."
				+ "To display all data, please enter -d. To log out, enter -logout.");
		input = sc.nextLine();
		if (input.equals("-logout")) {
			Driver.logout();
		}
		if (input.equals("-a")) {
			applicationsView();
		}
		if (input.equals("-d")) {
			dataView();
		}
		employeeView();
	}

	public static void applicationsView() {
		Scanner sc = new Scanner(System.in);
		int intput = 0;
		System.out.println(
				"Welcome to the application view. Here you can see pending applications for new accounts / joint accounts. \n To reject or accept one, type -r or -a. to cancel, type -c.");
		for (Account account : Driver.getAccounts()) {
			if (account.checkApprovals()) {
				System.out.println(account);
			}
		}
		input = sc.nextLine();
		if (input.length() != 2 || input.charAt(0) != '-') {
			System.out.println("Enter -r, -a, or -c next time, so your command can be understood.");
			applicationsView();
		}
		sc = new Scanner(System.in);
		switch (input.charAt(1)) {
		case ('c'):
			System.out.println("you cancelled. Back to your main menu!");
			employeeView();
			break;
		case ('a'):
			System.out.println("Which application do you want to accept? Enter the account number first.");
			intput = sc.nextInt();
			if (intput <= Driver.getAccountCount() && Driver.getAccount(intput).checkApprovals()) {
				sc = new Scanner(System.in);
				System.out.println("Now tell me which user you want to accept here. Enter the Name, casesensitive.");
				input = sc.nextLine();
				try {
					if (!Driver.getAccount(intput).isApproved(Driver.findUser(input))) {
						Driver.acceptApplication(intput, Driver.findUser(input));
						break;
					}
				} catch (Exception e) {
					System.out.println("Wrong values were given, you are now logged out!");
					Driver.logout();
				}
			}
			System.out.println("you may have chosen a wrong number there, try again!");
			applicationsView();
			break;
		case ('r'):
			System.out.println("Which application do you want to reject? Enter the account number first.");
			intput = sc.nextInt();
			System.out.println(intput + " is being read correctly!" + Driver.getAccountCount()
					+ !Driver.getAccount(intput).checkApprovals());
			if (intput <= Driver.getAccountCount() && Driver.getAccount(intput).checkApprovals()) {
				sc = new Scanner(System.in);
				System.out.println("Now tell me which user you want to reject here. Enter the Name, casesensitive.");
				input = sc.nextLine();
				try {
					if (!Driver.getAccount(intput).isApproved(Driver.findUser(input))) {
						Driver.rejectApplication(intput, Driver.findUser(input));
						break;
					}
				} catch (Exception e) {
					System.out.println("Wrong values were given, you are now logged out!");
					Driver.logout();
				}
			}
			System.out.println("you may have chosen a wrong number there, try again!");
			applicationsView();
			break;
		}
		dataView();
	}

	public static void dataView() {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Welcome, " + Driver.getCurrentUserName() + "! You are in your data menu. To return, enter -c.;");
		if (Driver.isAdmin()) {
			System.out.println("To make changes, enter -e.");
		}
		for (Account account : Driver.getAccounts()) {
			System.out.println(account);
		}
		for (User user : Driver.getUsers()) {
			System.out.println(user);
		}
		input = sc.nextLine();
		if (input.equals("-c")) {
			System.out.println("You saw enough of the Data and returned to your main menu");
			employeeView();
		}
		System.out.println("Command not recognized - please enter -c to return!");
		dataView();
	}

	public static void accountsView() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Account> accounts = Driver.getCurrentUserAccounts();
		System.out.println("Available Accounts:");
		for (Account account : accounts) {
			if (account.isApproved(Driver.getCurrentUser())) {
				System.out.println("Balance: " + account.getCurrentBalance() + ";  Name: " + account.getUsers());
			}
		}
		System.out.println("Pending Accounts:");
		for (Account account : accounts) {
			if (!account.isApproved(Driver.getCurrentUser())) {
				System.out.println("Name: " + account.getUsers() + "AccountID: " + account.getAccountNumber()
						+ "Accepted yet: false.");
			}
		}
		System.out.println(
				"To deposit, withdraw, or transfer of one of your accounts, please enter -d,-w, or -t respectively. "
						+ "To apply for a new account, enter -a and to return to the previous menu, enter -c");
		input = sc.nextLine();
		if (input.length() != 2 || input.charAt(0) != '-') {
			System.out.println("Enter -d, -w, -t, or -c next time, so your command can be understood.");
			accountsView();
		}
		sc = new Scanner(System.in);
		switch (input.charAt(1)) {
		case ('d'):
			depositView();
			;
			break;
		case ('w'):
			withdrawView();
			;
			break;
		case ('t'):
			transferView();
			;
			break;
		case ('a'):
			System.out.println("Enter a Number higher than " + Driver.getAccountCount() + " to create a new account,"
					+ " or enter a lower number to apply for a joint account.");
			int intput = 0;

			try {
				intput = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Something went wrong. Enter a Number next time!");
				accountsView();
			}
			Driver.createBankAccount(intput);
			break;
		case ('c'):
			System.out.println("Back to your main menu!");
			customerView();
			break;
		}

	}
	/*
	 * registerView customerView -logout (as logoutView?) -a(ccountView) accountView
	 * -w,d,t -a(pply) -logout employeeView -logout -a(pplicationView)
	 * -c(ustomerInfo) applicationView -a(ccept)/d(eny) -c adminView -logout
	 * -a(pplicationView) -c(ustomerInfo for admins) customerView(bool isAdmin) -c
	 * -e(dit: inputs would be: username as unique key to find user, then 0/1/2/3
	 * for which variable, then new value; -c to cancel, still check for same name,
	 * length,...)
	 * 
	 * 
	 */

	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static void depositView() {
		Scanner sc = new Scanner(System.in);
		double intput = 0.00;
		ArrayList<Account> accounts = Driver.getCurrentUserAccounts();
		System.out.println("Available Accounts:");
		for (Account account : accounts) {
			if (account.isApproved(Driver.getCurrentUser())) {
				System.out.println("Balance: " + account.getCurrentBalance() + ";  Name: " + account.getUsers()
						+ "; Number: " + account.getAccountNumber());
			}
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
			withdrawView();
		}
		sc = new Scanner(System.in);
		if (intput > Driver.getAccountCount()) {
			System.out.println("You cannot enter a non assigned AccountIndex. Please stick to the rules! =)");
			depositView();
		}
		int accountNumber = (int) intput;
		System.out.println("How much would you like to deposit?");
		try {
			input = sc.nextLine();
			if (input.equals("-c")) {
				System.out.println("you returned to the main menu");
				customerView();
			} else {
				intput = Double.parseDouble(input);
			}
		} catch (Exception e) {
			System.out.println("please enter a number or -c");
			depositView();
		}

		Driver.deposit(intput, accountNumber);

	}

	public static void withdrawView() {
		Scanner sc = new Scanner(System.in);
		double intput = 0.00;
		ArrayList<Account> accounts = Driver.getCurrentUserAccounts();
		System.out.println("Available Accounts:");
		for (Account account : accounts) {
			if (account.isApproved(Driver.getCurrentUser())) {
				System.out.println("Balance: " + account.getCurrentBalance() + ";  Name: " + account.getUsers()
						+ "; Number: " + account.getAccountNumber());
			}
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
		if (intput > Driver.getAccountCount() || !Driver.getAccount((int) intput).isApproved(Driver.getCurrentUser())) {
			System.out.println(
					"You cannot enter a non assigned AccountIndex and also cannot work on another account. Please stick to the rules! =)");
			depositView();
		}
		int accountNumber = (int) intput;
		System.out.println("How much would you like to withdraw?");
		try {
			input = sc.nextLine();
			if (input.equals("-c")) {
				System.out.println("you returned to the main menu");
				customerView();
			} else {
				intput = Double.parseDouble(input);
			}
		} catch (Exception e) {
			System.out.println("please enter a number or -c");
			depositView();
		}

		Driver.withdraw(intput, accountNumber);
	}

	public static void transferView() {
		Scanner sc = new Scanner(System.in);
		double intput = 0.00;
		ArrayList<Account> accounts = Driver.getCurrentUserAccounts();
		System.out.println("Available Accounts:");
		for (Account account : accounts) {
			if (account.isApproved(Driver.getCurrentUser())) {
				System.out.println("Balance: " + account.getCurrentBalance() + ";  Name: " + account.getUsers()
						+ "; Number: " + account.getAccountNumber());
			}
		}
		System.out.println(
				"Choose an account from which to make a transfer by entering the Number now. You may cancel with -c.");
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
			transferView();
		}
		sc = new Scanner(System.in);
		if (intput > Driver.getAccountCount() || !Driver.getAccount((int) intput).isApproved(Driver.getCurrentUser())) {
			System.out.println(
					"You cannot enter a non assigned AccountIndex and also cannot work on another account. Please stick to the rules! =)");
			transferView();
		}
		int rootAccountNumber = (int) intput;
		System.out.println(rootAccountNumber);
		sc = new Scanner(System.in);

		System.out.println("Where do you want to send money to? Enter a valid open account please.");
		intput = sc.nextInt();
		if (intput > Driver.getAccountCount()) {
			System.out.println("too big of a number!");
			transferView();
		}
		sc = new Scanner(System.in);
		int goalAccountNumber = (int) intput;
		System.out.println(goalAccountNumber);
		System.out.println("How much would you like to transfer? Cancel with -c");
		try {
			input = sc.nextLine();
			if (input.equals("-c")) {
				System.out.println("you returned to the main menu");
				customerView();
			} else {
				intput = Double.parseDouble(input);
			}
		} catch (Exception e) {
			System.out.println("please enter a number or -c");
			transferView();
		}
		System.out.println(intput + "method is called");
		Driver.transfer(intput, rootAccountNumber, goalAccountNumber);
	}

}
