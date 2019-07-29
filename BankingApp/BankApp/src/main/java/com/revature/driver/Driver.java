package com.revature.driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.view.View;

public class Driver {
	static ArrayList<Account> applications = new ArrayList<Account>();
	static HashMap<Integer, Account> accounts = new HashMap<Integer, Account>();
	static ArrayList<User> users = new ArrayList<User>();
	private static User currentlyLoggedInUser = null;

	// methods to checkPassword for a user who tried to login, to
	// withdraw,transfer,deposit (maybe
	// we should throw exceptions from model instead?)
	public static void main(String[] args) {
		// redirects into view;
		createMockUpData(); // later, this will read out our serialized files/file.
		// System.out.println(View.factorial(5));
		View.catReader();
		View.startView();
		
	}

	public static void logout() {
		currentlyLoggedInUser = null;
		System.out.println("You logged out. Cya~~~ :3");
		View.startView();
	}

	public static void createBankAccount(int input) {
		if (input >= Account.getAccountCount()) {
			Account newAcc = new Account(currentlyLoggedInUser);
			accounts.put(newAcc.getAccountNumber(), newAcc);
			System.out.println(
					"Your Account application was submitted and if accepted, you'll be able to deposit money on it!");
			View.accountsView();
		} else if (input < Account.getAccountCount()) {
			System.out.println(
					"You applied for a Joint Account with " + accounts.get(input).getUsers().toArray()[0] + ".");
			accounts.get(input).addUser(currentlyLoggedInUser);
			View.accountsView();
		}
	}

	public static ArrayList<Account> getCurrentUserAccounts() {
		ArrayList<Account> userAccounts = new ArrayList<Account>();
		for (Account account : accounts.values()) {
			if (account.getUsers().contains(currentlyLoggedInUser)) {
				userAccounts.add(account);
			}
		}
		return userAccounts;
	}

	public static void acceptApplication(int input, User user) {
		accounts.get(input).setApproval(user);
	}

	public static void rejectApplication(int input, User user) {
		accounts.get(input).rejectApplication(user);
	}

	public static User findUser(String name) {
		for (User user : users) {
			if (user.getName().equals(name)) {
				return user;
			}
		}
		return null;
	}

	public static String getCurrentUserName() {
		if (currentlyLoggedInUser == null)
			return "";
		return currentlyLoggedInUser.getName();
	}

	public static User getCurrentUser() {
		if (currentlyLoggedInUser == null)
			return null;
		return currentlyLoggedInUser;
	}

	public static int getAccountCount() {
		return Account.getAccountCount();
	}

	public static ArrayList<User> getUsers() {
		return users;
	}

	public static Account getAccount(int x) {
		return accounts.get(x);
	}

	public static Collection<Account> getAccounts() {
		return accounts.values();
	}

	public static void loginUser(String userName, String password) {
		for (User user : users) {
			if (userName.equals(user.getName())) {
				if (password.equals(user.getPassword())) {
					System.out.println("hurray! " + user.getName() + ", u totally just logged in! Ameowzing. :3");
					currentlyLoggedInUser = user;
					if (user.getRole() == 0)
						View.customerView();
					if (user.getRole() >= 1)
						View.employeeView();
				}
				System.out.println(
						"Your password did not match, if you forgot your password, please contact a system-admin, or register from the main menu!");
				View.loginView();
			}
		}
		System.out.println("We could not find a user named \"" + userName
				+ "\" in our Database. Please check the spelling and loggin again, or cancel with -c to register a new account.");
		View.loginView();

	}

	public static boolean isAdmin() {
		return (currentlyLoggedInUser.getRole() == 2);
	}

	public static void registerUser(String userName, String password) {
		for (User user : users) {
			if (userName.equals(user.getName())) {
				System.out.println(
						"The user you want to create already exists. Please chose another name and try again!");
				View.registerView();
			}
		}
		User newUser = new User(userName, password);
		users.add(newUser);
		// TODO Serialize the list (maybe extra method)
		System.out.println("Your account was created, congratulations! ");
		View.loginView();
	}

	public static void createMockUpData() {
		User terry = new User("Terry", "kittycat", 0);
		User leo = new User("Leo", "doggobark", 0);
		User mett = new User("Matt", "RollTide", 1);
		User bASTET = new User("BASTET", "lifat almada", 2);

		User[] userArray = new User[] { terry, leo, mett, bASTET };
		users.addAll(Arrays.asList(userArray));
	}
	/*
	 * registerView customerView -logout (as logoutView?) -a(ccountView) accountView
	 * -w,d,t -a(pply) -logout employeeView -logout -a(pplicationView)
	 * -c(ustomerInfo) applicationView -a(ccept)/d(eny) -c adminView -logout
	 * -a(pplicationView) -c(ustomerInfo for admins) customerOverView(bool isAdmin
	 * for interactability) -c -e(dit: inputs would be: username as unique key to
	 * find user, then 0/1/2/3 for which variable, then new value; -c to cancel,
	 * still check for same name, length,...)
	 * 
	 * MainFunctions: Login, Register UserFunctions:
	 */

	public static void deposit(double depositAmount, int accountNumber) {

		double balance = accounts.get(accountNumber).getCurrentBalance(); // replace with a variable
		if (depositAmount < 0) {
			System.out.println("u stuped??");
			View.depositView();
		}
		accounts.get(accountNumber).setCurrentBalance(balance + depositAmount);
		System.out.println("Current balance is " + accounts.get(accountNumber).getCurrentBalance());
		View.customerView();
	}

	public static void depositForTrans(double depositAmount, int accountNumber) {

		double balance = accounts.get(accountNumber).getCurrentBalance(); // replace with a variable
		if (depositAmount < 0) {
			System.out.println("u stuped??");
			View.depositView();
		}
		accounts.get(accountNumber).setCurrentBalance(balance + depositAmount);
		System.out.println("Current balance is " + accounts.get(accountNumber).getCurrentBalance());
	}

	public static void withdraw(double withdrawAmount, int accountNumber) {

		double balance = accounts.get(accountNumber).getCurrentBalance(); // replace with a variable
		if (withdrawAmount < 0) {
			System.out.println("sorry, no moneyprinting!");
			withdrawAmount = 0;
		} else if (withdrawAmount > accounts.get(accountNumber).getCurrentBalance()) {
			System.out.println("Nice try, but we are credit sharks and not baitfishes!");
			withdrawAmount = 0;
		}
		accounts.get(accountNumber).setCurrentBalance(balance - withdrawAmount);
		System.out.println("Current balance is " + accounts.get(accountNumber).getCurrentBalance());
		View.customerView();
	}

	public static boolean withdrawForTrans(double withdrawAmount, int accountNumber) {

		double balance = accounts.get(accountNumber).getCurrentBalance(); // replace with a variable
		if (withdrawAmount < 0) {
			System.out.println("sorry, no moneyprinting!");
			withdrawAmount = 0;
		} else if (withdrawAmount > accounts.get(accountNumber).getCurrentBalance()) {
			System.out.println("Nice try, but we are credit sharks and not baitfishes!");
			withdrawAmount = 0;
		}
		accounts.get(accountNumber).setCurrentBalance(balance - withdrawAmount);
		System.out.println("Current balance is " + accounts.get(accountNumber).getCurrentBalance());
		return true;
	}

	public static void transfer(double amount, int root, int goal) {
		double balance = accounts.get(root).getCurrentBalance();
		double balance2 = accounts.get(goal).getCurrentBalance();
		if (amount < 0 || balance < amount) {
			System.out.println("You went either below 0 with your account, or entered an invalid number.");
			View.transferView();
		}
		if (withdrawForTrans(amount, root)) {
			depositForTrans(amount, goal); // need to use bank account to call this method
			System.out.println("Successfully transferred $" + amount + ". Your currenct balance is $"
					+ accounts.get(root).getCurrentBalance());
		}
		View.customerView();
	}
}
