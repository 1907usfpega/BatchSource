package com.revature.driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.daoimpl.UserDaoImpl;
import com.revature.view.View;
//kitty banking, need loginuser and registeruser methods

public class Driver {
	private static User currentlyLoggedInUser = null;
	static ArrayList<User> users = new ArrayList<User>();
	static ArrayList<Account> accounts = new ArrayList<Account>();

	public static void main(String[] args) {

		View.startView();

	}

	public static void registerUser(String userName, String userPASS, int userID, int ACCOUNTBALANCE) {
		// making connection with UserDaoImpl
		UserDaoImpl userDaoImp = new UserDaoImpl();
		ArrayList<User> users = new ArrayList<User>();
		try {
			users = userDaoImp.getAllUsers();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			userDaoImp.createUsers(userName, userPASS, userID, ACCOUNTBALANCE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (User user : users) {
			if (userName.equals(user.getUserName())) {
				System.out.println(
						"The user you want to create already exists. Please chose another name and try again!");
				View.registerView();
			}
		}
//		User newUser = new User(userName, userPASS, userID, ACCOUNTBALANCE);
//		users.add(newUser);
		// TODO Serialize the list (maybe extra method)
		System.out.println("Your account was created, congratulations! ");
		View.loginView();
	}

	public static void loginUser(String userName, String password) {

		UserDaoImpl udi = new UserDaoImpl();
		ArrayList<User> users = null;
		try {
			users = udi.getAllUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (User user : users) {
			if (userName.equals(user.getUserName())) {
				if (password.equals(user.getUserPass())) {
					System.out.println("hurray! " + user.getUserName() + ", u totally just logged in! Ameowzing. :3 ");
					currentlyLoggedInUser = user;
//					if (user.getRole() == 0)
					View.customerView();
//					if (user.getRole() >= 1)
//						View.employeeView();
				}
//				
				System.exit(0);
				View.loginView();
			}
		}
		System.out.println("We could not find a user named \"" + userName
				+ "\" in our Database. Please check the spelling and loggin again, or cancel with -c to register a new account.");
		View.loginView();

	}

	public static void logout() {
		currentlyLoggedInUser = null;
		System.out.println("You logged out. Cya~~~ :3");
		View.startView();
	}

	public static String getCurrentUserName() {
		if (currentlyLoggedInUser == null)
			return "";
		return currentlyLoggedInUser.getUserName();
	}

	public static User getCurrentUser() {
		if (currentlyLoggedInUser == null)
			return null;
		return currentlyLoggedInUser;
	}

	public static void deposit(double depositAmount, int accountNumber) {

		double balance = accounts.get(accountNumber).getBalance(); // replace with a variable
		if (depositAmount < 0) {
			System.out.println("You cannot do that!!??");
			View.depositView();
		}
		accounts.get(accountNumber).setBalance(balance + depositAmount);
		System.out.println("Current balance is " + accounts.get(accountNumber).getBalance());
		View.customerView();
	}

	public static Account getAccount(int x) {
		return accounts.get(x);
	}
	
	public static void setAccount(Account a, int index)
	{
		accounts.set(index, a);
	}

	public static Collection<Account> getAccounts() {
		return accounts;
	}

	public static void withdraw(double withdrawAmount, int accountNumber) {

		double balance = accounts.get(accountNumber).getBalance(); // replace with a variable
		if (withdrawAmount < 0) {
			System.out.println("sorry, no moneyprinting!");
			withdrawAmount = 0;
		} else if (withdrawAmount > accounts.get(accountNumber).getBalance()) {
			System.out.println("Nice try, but we are credit sharks and not baitfishes!");
			withdrawAmount = 0;
		}
		accounts.get(accountNumber).setBalance(balance - withdrawAmount);
		System.out.println("Current balance is " + accounts.get(accountNumber).getBalance());
		View.customerView();
	}
	
	public static void deleteAcct(int accountNumber)
	{
		if (accounts.get(accountNumber).getBalance() > 0) 
		{
			System.out.println("sorry, no deleting an account with nonzero funds!");
			View.customerView();
		}
		accounts.remove(accountNumber);
		System.out.println("Account Deleted");
		View.customerView();
	}

	public static ArrayList<Account> getCurrentUserAccounts() {
		//gets the logged in user's bank accounts
		UserDaoImpl udi = new UserDaoImpl();
		accounts = new ArrayList<Account>();
		try {
			accounts  = udi.getAccounts(currentlyLoggedInUser.getUserId());
		} catch (SQLException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}

		return accounts;

	}

}