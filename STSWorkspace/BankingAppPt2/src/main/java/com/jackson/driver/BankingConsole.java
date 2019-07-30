package com.jackson.driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import com.jackson.beans.BankAccount;
import com.jackson.beans.Transaction;
import com.jackson.beans.UserAccount;
import com.jackson.daoimpl.BankAccountDaoImpl;
import com.jackson.daoimpl.UserAccountDaoImpl;

import cam.jackson.exceptions.*;

public class BankingConsole 
{
	public static UserAccountDaoImpl userDao = new UserAccountDaoImpl();
	public static BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
	
	public static UserAccount loggedIn;
	public static ArrayList<BankAccount> currentAccounts = new ArrayList<BankAccount>();
	public static ArrayList<Transaction> currentTransactions = new ArrayList<Transaction>();
	public static Properties prop = new Properties();
	public static String adminUser = prop.getProperty("user"); 
	public static String adminPass = prop.getProperty("password");
	
	public static void main(String[] args)
	{
		try
		{
			//userDao.createNewUser("Hello World", "hworld", "earthy");
			//bankDao.createNewAccount(1, "Checking", 120.0);
			System.out.println(userDao.getUserList());
			System.out.println(bankDao.getAccountsList());
		}
		catch(SQLException e)
		{
			System.out.println("damn that didnt work. ");
		}
		
		Scanner s = new Scanner(System.in);
		String input = "n";
		do
		{
			run();
			System.out.print("Do you wish to quit?(Y/N): ");
			input = s.next().toLowerCase();
		}while(input.equals("n"));
	}
	
	public static void run()
	{
		Scanner s = new Scanner(System.in);
		boolean q = false;
		do
		{
			System.out.println("Welcome!\n\t1. Login\n\t2. Create Account\n\t3. Quit");
			int mainMenuChoice = s.nextInt();
			switch(mainMenuChoice)
			{
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
		}while(q == false);
	}
	
	public static void login()
	{
		ArrayList<UserAccount> allAccounts = new ArrayList<UserAccount>();
		try 
		{
			allAccounts = userDao.getUserList();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		System.out.print("Enter your username: ");
		Scanner s = new Scanner(System.in);
		String userNameInput = s.nextLine();
		System.out.print("Enter your password: ");
		String passwordInput = s.nextLine();
		boolean b = false;
		for(int i = 0; i < allAccounts.size(); i++)
		{
			if(userNameInput.equals(allAccounts.get(i).getUsername()) && passwordInput.equals(allAccounts.get(i).getPassword()))
			{
				if (userNameInput.equals(adminUser) && passwordInput.equals(adminPass))
				{
					b = true;
					loggedIn = allAccounts.get(i);
					System.out.println("Admin Login Successful!");
					mainAdminMenu();
				}
				else
				{
					b = true;
					loggedIn = allAccounts.get(i);
					addAccountsToList();
					System.out.println("Login Successful!");
					mainCustomerMenu();
				}
			}
		}
		if(b == false)
		{
			System.out.println("That login was not found in our database");
		}
	}
	
	/*public static ArrayList<BankAccount> getUserBankAccounts(int userId) throws SQLException
	{
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		for(int i = 0; i < bankDao.getAccountsList().size(); i++)
		{
			if(bankDao.getAccountsList().get(i).getCustID() == loggedIn.getAccountID())
			{
				currentAccounts.add(bankDao.getAccountsList().get(i));
			}
		}
		return accounts;
	}*/
	
	public static void createUserAccount()
	{
		try
		{
			ArrayList<UserAccount> allAccounts = new ArrayList<UserAccount>();
			Scanner s = new Scanner(System.in);
			String firstNameInput = "", lastNameInput = "", userNameInput = "", passwordInput = "";
			System.out.print("Enter your first name: ");
			firstNameInput = s.nextLine();
			System.out.print("Enter your last name: ");
			lastNameInput = s.nextLine();
			System.out.print("Enter your username: ");
			userNameInput = s.next();
			System.out.print("Enter your password: ");
			passwordInput = s.next();
			
			for(int i = 0; i < allAccounts.size(); i++)
			{
				if(userNameInput.equals(allAccounts.get(i).getUsername()))
				{
					System.out.println("That username already exists");
				}
				else if(passwordInput.equals(allAccounts.get(i).getPassword()))
				{
					System.out.println("That password already exists");
					break;
				}
				else if(userNameInput.equals(allAccounts.get(i).getUsername()) && passwordInput.equals(allAccounts.get(i).getPassword()))
				{
					throw new InvalidLoginException();
				}
				else
				{
					userDao.createNewUser(userNameInput, passwordInput, firstNameInput, lastNameInput);
				}
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getStackTrace());
		}
		catch(InvalidLoginException e)
		{
			
			System.out.println("That username and password already exist");
		}
	}
	
	public static void mainCustomerMenu()
	{
		try
		{
			Scanner s = new Scanner(System.in);
			boolean q = false;
			do
			{
				System.out.println("\nWelcome back, "+loggedIn.getFullName()+"! What would you like to do? \n\t1. View Current Accounts\n\t2. Create a New Account\n\t3. Delete Account\n\t4. Deposit Funds\n\t5. Withdraw Funds\n\t6. Logout");
				System.out.print("Enter your input: ");
				int input = s.nextInt();
				int choice = 0;
				s.nextLine();
				switch(input)
				{
					case 1:
						printAccounts();
						break;
					case 2:
						createBankAccount();
						break;
					case 3:
						deleteBankAccount();
						break;
					case 4:
						System.out.println("Choose an account to deposit funds to:");
						choice = promptForAccount();
						bankDao.depositFunds(choice);
						break;
					case 5:
						System.out.println("Choose an account to withdraw funds from:");
						choice = promptForAccount();
						bankDao.withdrawFunds(choice);
						break;
					case 6:
						q = true;
						break;
				}
			}while(q == false);
		}
		catch(SQLException e)
		{
			System.out.println(e.getStackTrace());
		}
	}
	
	public static void addAccountsToList()
	{
		ArrayList<BankAccount> allAccounts = new ArrayList<BankAccount>();
		try 
		{
			allAccounts = bankDao.getAccountsList();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		for(int i = 0; i < allAccounts.size(); i++)
		{
			if(allAccounts.get(i).getCustID() == loggedIn.getAccountID())
			{
				currentAccounts.add(allAccounts.get(i));
			}
		}
	}

	public static void printAccounts()
	{
		for(int i = 0; i < currentAccounts.size(); i++)
		{
			if(currentAccounts.get(i).getCustID() == loggedIn.getAccountID())
			{
				System.out.println(currentAccounts.get(i).getAccountName()+"\n ID: "+currentAccounts.get(i).getBankacctID()+"\n Balance: $"+currentAccounts.get(i).getFunds());
			}
		}
	}
	
	public static int promptForAccount()
	{
		int input = 0;
		Scanner s1 = new Scanner(System.in);
		printAccounts();
		System.out.print("Enter the accountID: ");
		input = s1.nextInt();
		s1.nextLine();
		return input;
	}
	
	public static void createBankAccount()
	{
		try 
		{
			Scanner s = new Scanner(System.in);
			System.out.print("Enter the name of the account: ");
			String acctNameInput = s.nextLine();
			System.out.print("Please deposit a minimum of $25 into this account: ");
			double acctFundsInput = s.nextDouble();
			s.nextLine();
			bankDao.createNewAccount(loggedIn.getAccountID(), acctNameInput, acctFundsInput);
			System.out.println("New Account "+acctNameInput+" Created!");
		} 
		catch (SQLException e) //throw new exceptions too
		{
			e.printStackTrace();
		}
	}
	
	public static void deleteBankAccount()
	{
		try
		{
			Scanner s = new Scanner(System.in);
			System.out.print("Enter the id of the account you wish to delete: ");
			printAccounts();
			int acctIDInput = s.nextInt();
			s.nextLine();
			bankDao.deleteAccount(acctIDInput);
		} 
		catch (SQLException e) //throw new exceptions too
		{
			e.printStackTrace();
		}
	}
	
	public static void mainAdminMenu()
	{
		Scanner s = new Scanner(System.in);
		boolean q = false;
		do
		{
			System.out.println("\nWelcome back, "+loggedIn.getFullName()+"! What would you like to do? \n\t1. View Current User Accounts\n\t2. Create a New User Account\n\t3. Delete User Account\n\t4. Deposit Funds\n\t5. Withdraw Funds\n\t6. Logout");
			System.out.print("Enter your input: ");
			int input = s.nextInt();
			s.nextLine();
			switch(input)
			{
				case 1:
					printAccounts();
					break;
				case 2:
					createBankAccount();
					break;
				case 3:
					deleteBankAccount();
					break;
				case 4:
					System.out.println("Choose an account:");
					//BankAccount b1 = promptAccount(customerLoggedIn);
					//b1.deposit();
					break;
				case 5:
					System.out.println("Choose an account:");
					//BankAccount b2 = promptAccount(customerLoggedIn);
					//b2.withdraw();
					break;
				case 6:
					q = true;
					break;
			}
		}while(q == false);
	}
}
