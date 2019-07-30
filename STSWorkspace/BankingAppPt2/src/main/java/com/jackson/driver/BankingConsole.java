package com.jackson.driver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import com.jackson.beans.BankAccount;
import com.jackson.beans.UserAccount;
import com.jackson.daoimpl.BankAccountDaoImpl;
import com.jackson.daoimpl.UserAccountDaoImpl;

import cam.jackson.exceptions.*;

public class BankingConsole 
{
	public static UserAccountDaoImpl userDao = new UserAccountDaoImpl();
	public static BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
	
	public static UserAccount loggedIn;
	public static ArrayList<UserAccount> currentUsers = new ArrayList<UserAccount>();
	public static ArrayList<BankAccount> loggedInAccounts = new ArrayList<BankAccount>();
	public static Properties prop = new Properties();
	public static String adminUser; 
	public static String adminPass;
	
	public static void main(String[] args)
	{
		try
		{
			//userDao.createNewUser("Hello World", "hworld", "earthy");
			//bankDao.createNewAccount(1, "Checking", 120.0);
			currentUsers = userDao.getUserList();
			System.out.println(userDao.getUserList());
			System.out.println(bankDao.getAccountsList());
			prop.load(new FileReader("database.properties"));
			adminUser = prop.getProperty("user");
			adminPass = prop.getProperty("password");
		}
		catch(SQLException e)
		{
			System.out.println("damn that didnt work. ");
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
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
		if (userNameInput.equals(adminUser) && passwordInput.equals(adminPass))
		{
			b = true;
			System.out.println("Admin Login Successful!");
			mainAdminMenu();
		}
		for(int i = 0; i < allAccounts.size(); i++)
		{
			if(userNameInput.equals(allAccounts.get(i).getUsername()) && passwordInput.equals(allAccounts.get(i).getPassword()))
			{
				b = true;
				loggedIn = allAccounts.get(i);
				addAccountsToList();
				System.out.println("Login Successful!");
				mainCustomerMenu();
			}
		}
		if(b == false)
		{
			System.out.println("That login was not found in our database");
		}
	}
	
	public static void createUserAccount()
	{
		try
		{
			boolean found = false;
			ArrayList<UserAccount> allAccounts = userDao.getUserList();
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
			s.nextLine();
			
			for(int i = 0; i < allAccounts.size(); i++)
			{
				if(userNameInput.equals(allAccounts.get(i).getUsername()))
				{
					found = true;
					System.out.println("That username already exists");
					return;
				}
				else if(passwordInput.equals(allAccounts.get(i).getPassword()))
				{
					found = true;
					System.out.println("That password already exists");
					return;
				}
				else if(userNameInput.equals(allAccounts.get(i).getUsername()) && passwordInput.equals(allAccounts.get(i).getPassword()))
				{
					found = true;
					throw new InvalidLoginException();
				}
			}
			if(found == false)
			{
				System.out.println("New User Account "+userNameInput+" Created!");
				userDao.createNewUser(userNameInput, passwordInput, firstNameInput, lastNameInput);
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
						printBankAccounts(loggedIn.getAccountID());
						break;
					case 2:
						createBankAccount(loggedIn.getAccountID());
						addAccountsToList();
						break;
					case 3:
						deleteBankAccount(loggedIn.getAccountID());
						addAccountsToList();
						break;
					case 4:
						System.out.println("Choose an account to deposit funds to:");
						choice = promptForBankAcct(loggedIn.getAccountID());
						bankDao.depositFunds(choice, loggedIn.getAccountID());
						addAccountsToList();
						break;
					case 5:
						System.out.println("Choose an account to withdraw funds from:");
						choice = promptForBankAcct(loggedIn.getAccountID());
						bankDao.withdrawFunds(choice, loggedIn.getAccountID());
						addAccountsToList();
						break;
					case 6:
						q = true;
						break;
				}
			}while(q == false);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(OverdraftException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void addAccountsToList()
	{
		loggedInAccounts.removeAll(loggedInAccounts);
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
				loggedInAccounts.add(allAccounts.get(i));
			}
		}
	}
		
	public static int promptForUserAcct()
	{
		int input = 0;
		Scanner s = new Scanner(System.in);
		printUserAccounts();
		System.out.print("Enter the accountID: ");
		input = s.nextInt();
		s.nextLine();
		return input;
	}
	
	public static int promptForBankAcct(int userID)
	{
		int input = 0;
		Scanner s = new Scanner(System.in);
		printBankAccounts(userID);
		System.out.print("Enter the accountID: ");
		input = s.nextInt();
		s.nextLine();
		return input;
	}
	
	public static void printBankAccounts(int userID)
	{
		try
		{
			ArrayList<BankAccount> list = bankDao.getAccountsList();
			for(int i = 0; i < list.size(); i++)
			{
				if(list.get(i).getCustID() == userID)
				{
					System.out.println(list.get(i).getAccountName()+"\n ID: "+list.get(i).getBankacctID()+"\n Balance: $"+list.get(i).getFunds());
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void printUserAccounts()
	{
		try
		{
			ArrayList<UserAccount> list = userDao.getUserList();
			for(int i = 0; i < list.size(); i++)
			{
				System.out.println(list.get(i).getFullName()+"\n ID: "+list.get(i).getAccountID()+"\n Username: "+list.get(i).getUsername()+"\n Password: "+list.get(i).getPassword());
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void createBankAccount(int userID)
	{
		try 
		{
			Scanner s = new Scanner(System.in);
			System.out.print("Enter the name of the account: ");
			String acctNameInput = s.nextLine();
			double acctFundsInput = 0.0;
			do
			{
				System.out.print("Please deposit a minimum of $25 into this account: ");
				acctFundsInput = s.nextDouble();
				s.nextLine();
			}while(acctFundsInput < 25.0);
			bankDao.createNewAccount(userID, acctNameInput, acctFundsInput);
			System.out.println("New Account "+acctNameInput+" Created!");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void deleteBankAccount(int userID)
	{
		try
		{
			BankAccount b = new BankAccount();
			Scanner s = new Scanner(System.in);
			printBankAccounts(userID);
			System.out.print("Enter the id of the account you wish to delete: ");
			int acctIDInput = s.nextInt();
			s.nextLine();
			for(BankAccount current : userDao.getBankAccountList(userID))
			{
				if(current.getBankacctID() == acctIDInput)
				{
					b = current;
					if(b.getFunds() > 0.0)
					{
						System.out.println("Account must be empty in order to be deleted");
					}
					else
					{
						System.out.println("Account "+b.getAccountName()+" Deleted");
						bankDao.deleteAccount(acctIDInput);
					}
				}
			}
			
		} 
		catch (SQLException e) //throw new exceptions too
		{
			e.printStackTrace();
		}
	}
	
	public static void mainAdminMenu()
	{
		try
		{
			Scanner s = new Scanner(System.in);
			boolean q = false;
			do
			{
				System.out.println("\nWelcome back, Admin! What would you like to do? \n\t1. View Current User Accounts\n\t2. Create a New User Account\n\t3. Update User Account\n\t4. Delete User Account\n\t5. Add New Bank Account\n\t6. Deposit Funds\n\t7. Withdraw Funds\n\t8. Delete Bank Account\n\t9. Logout");
				System.out.print("Enter your input: ");
				int input = s.nextInt();
				s.nextLine();
				int userChoice = 0, userSecondChoice = 0;
				switch(input)
				{
					case 1:
						printUserAccounts();
						userChoice = promptForUserAcct();
						printBankAccounts(userChoice);
						break;
					case 2:
						createUserAccount();
						break;
					case 3:
						userChoice = promptForUserAcct();
						userDao.updateUser(userChoice);
						break;
					case 4:
						userChoice = promptForUserAcct();
						userDao.deleteUser(userChoice);
						break;
					case 5:
						userChoice = promptForUserAcct();
						createBankAccount(userChoice);
						break;
					case 6:
						printUserAccounts();
						userChoice = promptForUserAcct();
						userSecondChoice = promptForBankAcct(userChoice);
						bankDao.depositFunds(userSecondChoice, userChoice);
						break;
					case 7:
						printUserAccounts();
						userChoice = promptForUserAcct();
						userSecondChoice = promptForBankAcct(userChoice);
						bankDao.withdrawFunds(userSecondChoice, userChoice);
						break;
					case 8:
						userChoice = promptForUserAcct();
						deleteBankAccount(userChoice);
						break;
					case 9:
						q = true;
						break;
				}
			}while(q == false);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(OverdraftException e)
		{
			e.printStackTrace();
		}
	}

}
