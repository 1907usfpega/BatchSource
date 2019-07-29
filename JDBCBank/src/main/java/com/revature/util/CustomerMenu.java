package com.revature.util;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.daoimpl.AccountDaoImpl;
import com.revature.daoimpl.TransactionDaoImpl;
import com.revature.daoimpl.UserDaoImpl;

/*
 * Extends Menu. For use for customer-enabled functionality.
 * 
 */

public class CustomerMenu extends Menu {
	private static Customer cust = null;
	private static Account acct = null;
	private static double val;
	
	
	//Initial logon page for customers. To be directed to before moving on to other account related issues.
	public static void logon()
	{
		UserDaoImpl udi = new UserDaoImpl();
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter your username.");
		String username = in.next();
		System.out.println("Please enter your password.");
		String password = in.next();
		try {
			cust = udi.getCustomer(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainMenu(cust);
			
	}
	
	//Main menu. Should have account/customer related functions accessible from here.
	public static void mainMenu(Customer cust)
	{
		System.out.println("Welcome, " + cust.getFirstname() + "!");
		System.out.println("1. Make a transaction \n2. Update your info \n3. Log off");
		Scanner in = new Scanner(System.in);
		int sel = in.nextInt();
		switch (sel)
		{
			case 1:
			{
				transactionMenu(cust);
				break;
			}
			case 2:
			{
				updateMenu(cust);
				break;
			}
			case 3:
			{
				in.close();
				System.out.println("Thank you for your patronage. Have a great day!");
				System.exit(0);
			}
		}
	}
	
	//Perhaps use this time to get account info?
	public static void transactionMenu(Customer cust)
	{
		AccountDaoImpl adi = new AccountDaoImpl();
		TransactionDaoImpl tdi = new TransactionDaoImpl();
		try {
			acct = adi.getAccount(cust.getUserId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner in = new Scanner(System.in);
		System.out.println("Transaction menu");
		System.out.println("1. Deposit \n2. Withdrawal \n3. Transfer \n4. Balance Inquiry \n5. Close account \n6. Return to main menu");
		int sel = in.nextInt();
		
		switch (sel)
		{
			case 1:
			{
				System.out.println("How much would you like to deposit today?");
				val = in.nextDouble();
				try {
					tdi.makeDeposit(acct, val);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Returning to top menu.");
				transactionMenu(cust);
			}
			case 2:
			{
				System.out.println("How much will you withdraw today?");
				val = in.nextDouble();
				try {
					tdi.makeWithdrawal(acct, val);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Don't spend it all in one place. :D \nReturning to top menu.");
				transactionMenu(cust);
			}
			case 3:
			{
				System.out.println("How much will you be transferring today?");
				val = in.nextDouble();
				System.out.println("What is the account number you will transfer to?");
				int target = in.nextInt();
				try {
					tdi.makeXfer(acct, adi.getAccountbyNo(target), val);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Transfer complete. Returning to top menu.");
				transactionMenu(cust);
			}
			case 4:
			{
				Double bal = acct.getBalance();
				System.out.println("Your current balance is $" + bal);
				System.out.println();
				System.out.println("Returning to top menu.");
				transactionMenu(cust);
			}
			case 5:
			{
				System.out.println("Are you sure you want to close your account? (y/n)");
				String ans = in.next();
				if (ans.equals("y"))
				{
					if (acct.getBalance() == 0.0)
					{
						try {
							adi.closeAccount(cust.getUserId());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if (acct.getBalance() != 0.0)
					{
						System.out.println("We're sorry, you currently have a balance in your account. Please ensure your account is at $0.00, then please try again.");
						transactionMenu(cust);
					}
				}
				else if (ans.equals("n"))
				{
					System.out.println("Understood. Returning to top menu.");
					transactionMenu(cust);
				}
			}
			case 6:
			{
				mainMenu(cust);
			}
		}
	}
	
	public static void updateMenu(Customer cust)
	{
		UserDaoImpl udi = new UserDaoImpl();
		Scanner in = new Scanner(System.in);
		System.out.println("What do we need to change? Your options are in the field below.");
		System.out.println("FIRSTNAME | LASTNAME | EMAIL | ADDRESS | CITY | STATE | PASSWORD ");
		String ans = in.next();
		if (ans.equals("FIRSTNAME") == false || ans.equals("LASTNAME") == false || ans.equals("EMAIL") == false || ans.equals("ADDRESS") == false
				|| ans.equals("CITY") == false || ans.equals("STATE") == false || ans.equals("PASSWORD") == false)
		{
			System.out.println("Sorry, we didn't catch that. Please try again.");
			updateMenu(cust);
		}
		else
		{
			System.out.println("What's the new one?");
			String newVal = in.next();
			System.out.println("OK. We'll change your " + ans + " to " + newVal);
			try {
				udi.updateCustomer(cust.getUserId(), ans, newVal);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Do you need to change anything else? (y/n)");
		String ans2 = in.next();
		if (ans2.equals("y"))
		{
			updateMenu(cust);
		}
		else
		{
			mainMenu(cust);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
