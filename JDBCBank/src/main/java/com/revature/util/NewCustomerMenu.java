package com.revature.util;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.daoimpl.AccountDaoImpl;
import com.revature.daoimpl.UserDaoImpl;

/*
 * Menu child class for account creation purposes..
 */

public class NewCustomerMenu extends Menu {
	private static String firstname;
	private static String lastname;
	private static String email;
	private static String addr;
	private static String city;
	private static String state;
	private static String username;
	private static String pw;
	private static Double val;
	
	
	public static void getUserParams()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Account Creation");
		System.out.println();
		System.out.println("We'd be happy to help! Let's start with your first name.");
		firstname = in.nextLine();
		System.out.println("And your last name?");
		lastname = in.nextLine();
		System.out.println("What's your email address?");
		email = in.nextLine();
		System.out.println("And your address.");
		addr = in.nextLine();
		System.out.println("City?");
		city = in.nextLine();
		System.out.println("State? (EX: FL, CA)");
		state = in.nextLine();
		System.out.println("What will your username be?");
		username = in.nextLine();
		System.out.println("And what will be your password?");
		pw = in.nextLine();
		
		System.out.println("Name: " + firstname + " " + lastname + "  Email: " + email);
		System.out.println("Address: " + addr + " " + city + "," + state);
		System.out.println("Username: " + username + "  Password: " + pw);
		System.out.println("Is this correct? (y/n)");
		String ans = in.next();
		if (ans.equals("y"))
		{
			System.out.println("Great. We'll get everything set up now. One moment.");
			createAccount(firstname, lastname, email, addr, city, state, username, pw);
		}
		else
		{
			System.out.println("OK. Let's try that again.");
			getUserParams();
		}
	}

	private static void createAccount(String first, String last, String emailAddr, String address, String cityN,
			String stateN, String user, String password) {
		UserDaoImpl udi = new UserDaoImpl();
		Customer cust = null;
		try {
			udi.createCustomer(first, last, emailAddr, address, cityN, stateN, user, password);
			cust = udi.getCustomer(user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("User account created! Your user ID number is " + cust.getUserId() + ". Be sure to keep it in a safe place!");
		System.out.println();
		System.out.println("We're almost done! We'll just need a couple more things to set up your bank account!");
		createBankAccount(cust);
	}

	private static void createBankAccount(Customer cust) {
		AccountDaoImpl adi = new AccountDaoImpl();
		Account acct = null;
		Scanner in = new Scanner(System.in);
		System.out.println("Will this be a checking or a savings account? (checking/savings)");
		String type = in.next();
		System.out.println("Finally, how much will you be depositing for your initial balance?");
		double val = in.nextDouble();
		if (val <= 0.00)
		{
			System.out.println("We're sorry, we require a deposit of any value to secure the account.");
			createBankAccount(cust);
		}
		else
		{
			System.out.println("Great, we'll get that set up!");
			try {
				adi.createAccount(cust.getUserId(), val, type);
				acct = adi.getAccount(cust.getUserId());
				System.out.println("Fantastic! Your account has been setup. Your account number is " + acct.getAcctNo());
				System.out.println("Please keep it in a safe place. \n\nYou're all set! Please login again to get started. Have a great day!");
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private static void exit()
	{
		Scanner in = new Scanner(System.in);
		in.close();
		System.exit(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
