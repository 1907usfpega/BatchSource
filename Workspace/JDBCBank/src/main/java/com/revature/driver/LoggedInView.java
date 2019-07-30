package com.revature.driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.exception.NegativeNumberException;

import oracle.net.aso.e;

public class LoggedInView {
	private static User curUser = null;

	public static void UserMainMenu() {
		curUser = Driver.getLoggedInUser();
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n\n\n\n\n" + "Welcome, " + curUser.getName());
		System.out.println("You currently are logged in. If you want to display your accounts and make "
				+ "deposits or withdrawls, please enter \"a\". If you want to log out, enter x");
		String input = "";
		boolean stopped = false;
		do {
			input = sc.nextLine();
			if (input.length() > 1) {
				System.out.println(
						"\n\n\n\n\n\n" + "Please enter a valid option consisting of one character only. a to view show your accounts, or x to log out again.");
				continue;
			}
			switch (input.charAt(0)) {
			case ('a'):
				boolean goAgane = true;
				while (goAgane) {
					goAgane = accountView();
				}
				break;
			case ('x'):
				curUser = null;
				Driver.setLoggedInUser(curUser);
				System.out.println("\n\n\n\n\n\n" + "You logged out. \n");
				stopped = true;
			}
		} while (!stopped);
	}

	public static boolean accountView() { // if it returns true, it will be restarted, writing all the commands down
											// again for the user.
		AccountDaoImpl adi = new AccountDaoImpl();
		UserDaoImpl udi = new UserDaoImpl();
		ArrayList<Account> curUserAccounts = new ArrayList<Account>();
		// create, deposit with accountnumber, delete if empty. Return to main
		Scanner sc = new Scanner(System.in);
		String input = "";
		try {
			curUserAccounts = udi.getAccounts(curUser.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int[] accountIds = new int[curUserAccounts.size()];
		if (curUserAccounts.size() < 1) {
			System.out.println(
					"\n\n\n\n\n\n" + "You do not have any accounts at this moment. To create one, please enter c. If you want to return, please enter x.");

		} else {

			System.out.println(
					"\n\n\n\n\n\n" + "Here are your Accounts: Please enter the corresponding number on its left, if you want to make changes to it. "
							+ "You can also type x to return to your main menu, or c to create a new account.");
			for (int i = 0; i < accountIds.length; i++) {
				System.out.println((i + 1) + " " + curUserAccounts.get(i));
				accountIds[i] = curUserAccounts.get(i).getId();
				System.out.println();
			}
		}
		boolean stopped = false;
		while (!stopped) {
			input = sc.nextLine();
			sc = new Scanner(System.in);
			if (input.length() == 1 && (input.charAt(0) == 'x')) {
				return false;
			}
			if (input.length() == 1 && (input.charAt(0) == 'c')) {
				adi.createAccount(curUser.getId());
				System.out.println("\n\n\n\n\n\n" + "You created a brand new account! \n \n");
				return true;
			}
			Integer accountId = -1;
			try {
				accountId = Integer.parseInt(input);
				accountId--;
			} catch (Exception e) {
				System.out.println("\n\n\n\n\n\n" + "Not a correct input");
				return true;
			}
			if (accountId < 0 || !(accountId < accountIds.length)) {
				System.out.println(
						"Your input was not recognized as a Number of one of your accounts. Please enter either the number of one of your accounts, or c / x to create a new account, or return to the main menu.");
				return true;
			}
			withdrawOrDeposit(curUserAccounts.get(accountId));
			return true;

		}
		return false;
	}

	public static void withdrawOrDeposit(Account account) {
		System.out.println("\n\n" + "You chose to take further action with your " + account);
		Scanner sc = new Scanner(System.in);

		String input = "";
		do {
			System.out.println(
					"Enter d if you want to deposit, or w if you chose to withdraw from your account, or if it is empty delete it with q. With x you may return to your account overview.");
			input = sc.nextLine();

			if (input.length() != 1) {
				System.out.println(
						"\n\n\n\n\n\n" + "Please enter just one letter. x to chose another account, d/w to deposit or withdraw from your chosen account. With q you may qelete your "
								+ "account, assuming it is empty! We can't just burn the money you created from nothing.");
				return;
			}
			switch (input.charAt(0)) {
			case ('x'):
				System.out.println("You chose to go back to your accounts.");
				return;
			case ('d'):
				if (!deposit(account)) // Either breaks out of the switch-case and goes back into the do while loop, or
					break;
				return;
			case ('w'):
				if (!withdraw(account))
					break;
				return;
			case ('q'):
				if (account.getBalance() == 0) {
					System.out.println("DELETED");
					deleteAccount(account.getId());
					return;
				} else
					System.out.println(
							"\n\n" + "You still got funds that need to be used. Please do not just try and delete this account :/");
			}
		} while (input.charAt(0) != ('x'));
		return;
	}

	public static void deleteAccount(int accountId) {
		AccountDaoImpl adi = new AccountDaoImpl();
		adi.deleteAccount(accountId);
		System.out.println("Account was deleted.");
		Driver.userList = Driver.getUsers();
	}

	public static boolean deposit(Account account) {
		Scanner sc = new Scanner(System.in);
		AccountDaoImpl adi = new AccountDaoImpl();
		System.out.println("\n\n\n\n\n\n" + "Enter the amount which you want to deposit, keeping in mind it can only be positive!");
		String input = sc.nextLine();
		int amount;
		try {
			amount = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("\n\n" + "Not a valid number! Please try again.");
			return false;
		}
		if (amount < 0) {
			System.out.println(
					"\n\n\n\n\n\n" + "You can write down any number. But you chose to deposit a negative one? Why would you in a world where you can create free money, delete your own? Retry!");
			return false;
		}
		try {
			adi.depoOrWithdraw(account.getId(), amount, false);
		} catch (NegativeNumberException e) {
			// unreachable codddde
			return false;
		}

		return true;
	}

	public static boolean withdraw(Account account) {
		Scanner sc = new Scanner(System.in);
		AccountDaoImpl adi = new AccountDaoImpl();
		System.out.println("Enter the amount which you want to withdraw, keeping in mind you cannot go below zero!");
		String input = sc.nextLine();
		int amount;
		try {
			amount = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Not a valid number! Please try again.");
			return false;
		}
		if (amount < 0) {
			System.out.println("Maybe chose deposit instead?");
			return false;
		}
		if ((account.getBalance() - amount) < 0) {
			System.out
					.println("This withdrawl is too much. Please make more money and don't get this problem again :/ ");
			return false;
		}
		try {
			adi.depoOrWithdraw(account.getId(), amount, true);
		} catch (NegativeNumberException e) {
			// unreachable codddde as the check before already disables this exception from
			// happening
			return false;
		}

		return true;
	}

	public static void adminMainMenu() {
		curUser = Driver.getLoggedInUser();
		ArrayList<User> allUsers = Driver.userList;
		int[] localUserIds = new int[allUsers.size()];
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"If you want to update any users information, enter the numer displayed at its left. To create a "
						+ "new user, enter c and if you want to logout, enter x.");
		sc = new Scanner(System.in);
		for (int i = 0; i < localUserIds.length; i++) {
			localUserIds[i] = Driver.userList.get(i).getId();
			System.out.println((i + 1) + " " + allUsers.get(i));
		}
		String input = "";
		do {
			System.out.println("Number for editting options, c to create a new used & c to sign out.");
			input = sc.nextLine();

			if (input.length() == 1 && (input.charAt(0) == 'x')) {
				curUser = null;
				Driver.setLoggedInUser(curUser);
				System.out.println("You logged out.");
				return;
			}
			if (input.length() == 1 && (input.charAt(0) == 'c')) {
				MainMenu.registerView();
				System.out.println("You created a brand new user! \n \n");
				return;
			}
			Integer userId = -1;
			try {
				System.out.println("Input is: " + input);
				userId = Integer.parseInt(input);
				userId--;
				System.out.println("User = " + userId + ", UserAmount: " + localUserIds.length
						+ "   AND THE ACCOUNTS ARE: " + localUserIds[0]);
				System.out.println("AccountINdexDatabase = " + localUserIds[userId]);

			} catch (Exception e) {
				System.out.println("did not parse the int into an accountId");
				continue;
			}
			if (userId < 0 || !(userId < localUserIds.length)) {
				System.out.println(
						"Your input was not recognized as a Number of one of your accounts. Please enter either the number of one of your accounts, or c / x to create a new account, or return to the main menu.");
				return;
			}
			updateUser(userId);

		} while (input != "x");
	}

	public static void updateUser(int userId) {
		Scanner sc = new Scanner(System.in);
		String input = "";
		UserDaoImpl udi = new UserDaoImpl();
		boolean stopped = false;
		while (!stopped) {
			System.out.println("\n\nYou selected the " + Driver.userList.get(userId));
			System.out.println("Your options are delete d, update the Name n, update the password p or exit with x");
			input = sc.nextLine();
			sc = new Scanner(System.in);
			if (input.length() != 1) {
				System.out
						.println("The length of the input you gave is invalid. Please enter a one character command.");
				continue;
			} else {
				switch (input.charAt(0)) {
				case ('x'):
					System.out.println("You cancelled the editting.");
					return;
				case ('d'):
					System.out.println("enter delete if you are sure you want to delete the user and all his accounts");
					if (sc.nextLine() == "delete") {
						udi.deleteUser(userId);
					}
					return;
				case ('n'):
					if (editNameOrPass(userId, true))
						return;
					break;
				case ('p'):
					if (editNameOrPass(userId, false))
						return;
					break;
				}
			}

		}

	}

	public static boolean editNameOrPass(int userId, boolean changeName) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		UserDaoImpl udi = new UserDaoImpl();
		if (changeName) {
			System.out.println("enter stop to return to the user-view. Enter a name to set the name!");
			if (input.equals("stop"))
				return true;
			if (input.length() < 3) {
				System.out.println("Please use more than 2 characters for your username.");
				return false;
			} else {
				ArrayList<User> users = Driver.userList;
				if (input.equals(Driver.admin.getName())) {
					System.out.println("You better not take your own name, boi!");
					return false;
				}
				for (User user : users) {
					if (user.getName().equals(input)) {
						System.out.println("That name is already taken. ");
						return false;
					}
				}
				try {
					udi.updateUserName(input, userId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		
		} else
			System.out.println("enter stop to return to the user-view. Enter a new password to set the password!");
		
		sc = new Scanner(System.in);
		input = sc.nextLine();
		if (input.length() < 3) {
			System.out.println("Please use more than 2 characters for your password.");
			return false;
		}
		if (input.equals("stop"))
			return true;
		String password = input;
		System.out.println("Enter the same password again to check.");
		sc = new Scanner(System.in);
		input = sc.nextLine();
		if(input.equals(password)) {
			try {
				udi.updateUserPass(password, userId);
				Driver.userList = Driver.getUsers();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
}
