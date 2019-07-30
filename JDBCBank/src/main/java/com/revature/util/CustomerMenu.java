package com.revature.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.beans.Transaction;
import com.revature.daoimpl.AccountDaoImpl;
import com.revature.daoimpl.TransactionDaoImpl;
import com.revature.daoimpl.UserDaoImpl;
import com.revature.exceptions.InvalidLoginException;

/*
 * Extends Menu. For use for customer-enabled functionality. Customer facing point of contact with program.
 * AUTHOR: redc
 * TODO: 
 * 
 */

public class CustomerMenu extends Menu {
	private static Customer cust = null;
	private static Account acct = null;
	private static double val;
	
	
	//Initial logon page for customers. To be directed to before moving on to other account related issues.
	public static void login()
	{
		UserDaoImpl udi = new UserDaoImpl();
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter your username.");
		String username = in.next();
		System.out.println("Please enter your password.");
		String password = in.next();
		try {
			boolean bool = udi.verifyPassword(username, password);
			if (bool == false)
			{
				throw new InvalidLoginException();
			}
			cust = udi.getCustomer(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidLoginException e) {
			throw new InvalidLoginException("Invalid password. Please try again.", e);
		}
		mainMenu(cust);
			
	}
	
	//Main menu. Should have account/customer related functions accessible from here.
	public static void mainMenu(Customer cust)
	{
		System.out.println("Welcome, " + cust.getFirstname() + "!");
		System.out.println("1. Make a transaction \n2. Update your info \n3. Create new account \n4. Log off");
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
				newAccountMenu(cust);
			}
			case 4:
			{
				in.close();
				System.out.println("Thank you for your patronage. Have a great day!");
				System.exit(0);
			}
		}
	}
	
	//Method for creating new accounts for existing users.
	private static void newAccountMenu(Customer cust) {
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
			mainMenu(cust);
		}
		else
		{
			System.out.println("Great, we'll get that set up!");
			try {
				adi.createAccount(cust.getUserId(), val, type);
				acct = adi.getAccount(cust.getUserId());
				System.out.println("Fantastic! Your account has been setup. Your account number is " + acct.getAcctNo());
				System.out.println("Please keep it in a safe place. \n\nYou're all set! Please login again to get started. Have a great day!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				mainMenu(cust);
			}
		}
		
	}

	//Perhaps use this time to get account info?
	public static void transactionMenu(Customer cust)
	{
		AccountDaoImpl adi = new AccountDaoImpl();
		TransactionDaoImpl tdi = new TransactionDaoImpl();
		
		Scanner in = new Scanner(System.in);
		
		try {
			ArrayList<Account> accounts = new ArrayList<Account>(adi.getAccountsByUser(cust.getUserId()));
			for (int i = 0; i < accounts.size(); i++)
			{
				System.out.println("Account #" + accounts.get(i).getAcctNo() + "            Balance: $" + accounts.get(i).getBalance());
			}
			if (accounts.size() > 1)
			{
				System.out.println("Which account number would you like to access today?");
				int acctNo = in.nextInt();
				acct = adi.getAccountbyNo(acctNo);
			}
			else
			{
				acct = adi.getAccount(cust.getUserId());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Transaction menu");
		System.out.println("1. Deposit \n2. Withdrawal \n3. Transfer \n4. Balance Inquiry \n5. Transaction history \n6. Close account \n7. Return to main menu");
		int sel = in.nextInt();
		
		switch (sel)
		{
			//Deposits
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
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				transactionMenu(cust);
			}
			//Withdrawals
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
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				transactionMenu(cust);
			}
			//Transfers
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
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				transactionMenu(cust);
			}
			//Gets balance.
			case 4:
			{
				Double bal = acct.getBalance();
				System.out.println("Your current balance is $" + bal);
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println();
				System.out.println("Returning to top menu.");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				transactionMenu(cust);
			}
			//Returns transaction history.
			case 5:
			{
				try {
					System.out.println("TRANSACTION HISTORY");
					ArrayList<Transaction> transList = new ArrayList<Transaction>(tdi.transactionList(acct.getAcctNo()));
					for (int i = 0; i < transList.size(); i++)
					{
						System.out.println(transList.get(i).toString());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					try {
						TimeUnit.SECONDS.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					transactionMenu(cust);
				}
			}
			//Removes account iff balance = 0.00
			case 6:
			{
				System.out.println("What is the account number?");
				int acctNo = in.nextInt();
				try {
					acct = adi.getAccountbyNo(acctNo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Are you sure you want to close your account? (y/n)");
				String ans = in.next();
				if (ans.equals("y"))
				{
					if (acct.getBalance() == 0.0)
					{
						try {
							adi.closeAccount(acct.getAcctNo());
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
			//Returns to main menu.
			case 7:
			{
				mainMenu(cust);
			}
			//If other input is given, repeats menu.
			default:
			{
				transactionMenu(cust);
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
