package com.revature.driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.UserDaoImpl;

public class LoggedInView {
	private static User curUser = null;

	public static void UserMainMenu() {
		curUser = Driver.getLoggedInUser();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome, " + curUser.getName());
		System.out.println("You currently are logged in. If you want to display your accounts and make "
				+ "deposits or withdrawls, please enter \"a\". If you want to log out, enter x");
		String input = "";
		boolean stopped = false;
		do {
			input = sc.nextLine();
			if (input.length() > 1) {
				System.out.println(
						"Please enter a valid option consisting of one character only. a to view show your accounts, or x to log out again.");
				continue;
			}
			switch (input.charAt(0)) {
			case ('a'):
				boolean goAgane = true;
				while(goAgane) {
					goAgane = accountView();
				}
				break;
			case ('x'):
				curUser = null;
				Driver.setLoggedInUser(curUser);
				System.out.println("You logged out. \n");
				stopped = true;
			}
		} while (!stopped);
	}

	public static boolean accountView() {
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
					"You do not have any accounts at this moment. To create one, please enter c. If you want to return, please enter x.");

		} else {
			
			System.out.println(
					"Here are your Accounts: Please enter the corresponding number on its left, if you want to make changes to it. "
							+ "You can also type x to return to your main menu, or c to create a new account.");
			for (int i = 0; i < accountIds.length; i++) {
				System.out.println((i + 1) + " " + curUserAccounts.get(i));
				accountIds[i] = curUserAccounts.get(i).getId();
				System.out.println(" SOMETHING NEEWWWW"+accountIds[i]);
			}
		}
		boolean stopped = false;
		while(!stopped) {
			input = sc.nextLine();
			sc = new Scanner(System.in);
			if(input.length()==1 && (input.charAt(0) == 'x')) {
				return false;
			}if(input.length()==1 && (input.charAt(0) == 'c')) {
				adi.createAccount(curUser.getId());
				System.out.println("You created a brand new account! \n \n");
				return true;
			}
			Integer accountId = -1;
			try {
				System.out.println("INput is: " + input);
				accountId = Integer.parseInt(input);
				accountId--;
				System.out.println("AccountId = " + accountId + "AccountAmount: " + accountIds.length + "   AND THE ACCOUNTS ARE: " + accountIds[0]);
				System.out.println("AccountINdexDatabase = " + accountIds[accountId]);
				
			}catch(Exception e) {
				System.out.println("did not parse the int into an accountId");
			}
			if(accountId<0 || !(accountId < accountIds.length)) {
				System.out.println("Your input was not recognized as a Number of one of your accounts. Please enter either the number of one of your accounts, or c / x to create a new account, or return to the main menu.");
				return true;
			}
			withdrawOrDeposit(curUserAccounts.get(accountId));
			return true;
			
		}
		return false;
	}
	public static void withdrawOrDeposit(Account account) {
		System.out.println("account: " + account);
	}
}
