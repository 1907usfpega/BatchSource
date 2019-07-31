package user.screens;

import java.sql.SQLException;

import daoimpl.AccountDaoImpl;
import daoimpl.CustomerDaoImpl;
import daoimpl.UserDaoImpl;

public class CustomerScreen {

	static void customerMenu(String username) {

		int customerOption;
		do {
			//--------------------------------------------User, Customer, and Account Info--------------------------------------------------------------------------------
			UserDaoImpl getUser = new  UserDaoImpl();
			int userID = 0;
			try {
				userID = getUser.getID(username); //<--Gets userID
			} catch (SQLException e) {
				e.printStackTrace();
			}


			CustomerDaoImpl getCustomer = new CustomerDaoImpl();  
			int customerID = 0;
			String name = "";
			try {
				customerID = getCustomer.getCustomerID(userID);  //<--Gets customerID
				name = getCustomer.getCustomerName(userID);  //<--Gets customerName
			} catch (SQLException e) {
				e.printStackTrace();
			}


			AccountDaoImpl checkAccounts = new AccountDaoImpl(); 
			boolean hasAccounts = false;
			try {
				hasAccounts = checkAccounts.getAccount(customerID); //<--Gets accountID
			} catch (SQLException e) {
				e.printStackTrace();
			}


			//--------------------------------------------Customer Menu--------------------------------------------------------------------------------	
			System.out.println("************************************");
			System.out.println("** Welcome to Community Bank B.A. **");  //<--Prints welcome message
			System.out.println("************************************");

			System.out.println("\nHello " + name + "!");
			System.out.println("Please type either 1, 2, 3, 4, 5, or 6 to active the following: ");  //<--Asks Customer what they'd like to do
			System.out.println("(1)View Accounts  (2)Create Account  (3)Delete Account  (4)Withdraw  (5)Deposit  (6)Logout");

			customerOption = UserInput.isInt();  //<--Stores input into int

			
			//--------------------------------------------Runnable Options--------------------------------------------------------------------------------	
			switch(customerOption) { 
			case 1: //View
				if(!hasAccounts) {
					System.out.println("You currently have no open accounts. \n");
				}else {
					UserActions.listAccounts(customerID);  //<--Runs method to view accounts
				}
				break;

			case 2: //Create
				UserActions.addAccount(customerID);  //<--Runs method to create an account
				break;

			case 3: //Delete
				if(!hasAccounts) {
					System.out.println("You currently have no open accounts. \n");
				}else {
					UserActions.removeAccount(customerID);  //<--Runs method to create an account
				}
				break;

			case 4: //Withdraw
				if(!hasAccounts) {
					System.out.println("You currently have no open accounts. \n");
				}else {
					UserActions.withdraw(customerID);  //<--Runs method to withdraw from an account
				}
				break;

			case 5: //Deposit
				if(!hasAccounts) {
					System.out.println("You currently have no open accounts. \n");
				}else {
					UserActions.deposit(customerID);  //<--Runs method to deposit into an account
				}
				break;

			case 6: //Logout
				System.out.println("\n\nThanks for visiting " + name + "!");
				System.out.println("\n***********************");
				System.out.println("** Logout Successful **");  //<--Prints goodbye screen
				System.out.println("***********************");
				break;
			}

		}while(customerOption != 6);

	}//end customerMenu()

}//end CustomerScreen