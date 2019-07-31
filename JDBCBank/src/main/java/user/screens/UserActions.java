package user.screens;

import java.sql.SQLException;

import daoimpl.AccountDaoImpl;

public class UserActions {

	//------------------------------------View Account Info-------------------------------------------
	static void listAccounts(int customerID) {
		AccountDaoImpl list = new AccountDaoImpl();

		try {
			list.listAccounts(customerID);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}//end accountInfo()


	//------------------------------------Create Account-------------------------------------------
	static void addAccount(int customerID) {

		System.out.println("Please select your account type: ");
		System.out.println("(1)Checking  (2)Saving");
		int accountSelect = UserInput.isInt();  //<--Stores input as an int

		//Checks to make sure they are selecting an account listed to them
		while(accountSelect != 1 & accountSelect != 2) {
			System.out.println("\n**************************");
			System.out.println("Invalid account option. Please enter either 1 or 2.");
			accountSelect = UserInput.isInt();
		}


		//Stores the account type into a String
		String accountType = "";
		if(accountSelect == 1) {
			accountType = "checking";
		}else {
			accountType = "saving";
		}


		//Add initial funds to account
		System.out.println("Please enter the amount you'd like to open the account with: ");
		double balance = UserInput.isDouble();  //<--Stores input as a double


		//Creates the account with the above information
		AccountDaoImpl create = new AccountDaoImpl();
		try {
			create.createAccount(customerID, accountType, balance);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("This account has been successfully created.");
	}//end addAccount()


	//------------------------------------Delete Account-------------------------------------------
	static void removeAccount(int customerID) {

		//Shows user all accounts they have
		listAccounts(customerID);

		AccountDaoImpl checkAccount = new  AccountDaoImpl();

		//Tells user to select an account with a balance of 0
		System.out.println("Please type in the Account_ID of the account you wish to close. ");
		System.out.println("Note: You may only delete accounts with a balance of 0. ");
		int accountSelect = UserInput.isInt();  //<--Stores input as an int


		//Ensures the user is only selecting from accounts they own
		try {
			while(!checkAccount.verifyAccountID(customerID, accountSelect)) {
				System.out.println("You do not own the selected account. Please select one from this list: ");
				listAccounts(customerID);
				accountSelect = UserInput.isInt();  //<--Stores input as an int
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {	//Catches exceptions when calling the DaoImpl method
			e.printStackTrace();
		}


		//Checks balance of the selected account to make sure it is 0
		double balance = 0;
		try {
			balance = checkAccount.getBalance(accountSelect);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(balance == 0) {
			System.out.println("This account has been deleted.");
			try {
				checkAccount.deleteAccount(accountSelect);  //<--Deletes the selected account
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("The account has remaining funds and could not be deleted.");  //<--Return to customer menu if cannot delete account
		}

	}//end removeAccount()


	//------------------------------------Withdraw-------------------------------------------
	static void withdraw(int customerID) {

		System.out.println("\n** Withdraw **");  //<--Displays title
		System.out.println("Here are your accounts: " );  

		//Shows user all accounts they have
		listAccounts(customerID);

		AccountDaoImpl checkAccount = new  AccountDaoImpl();

		//Tells user to select an account with a balance of 0
		System.out.println("Please type in the Account_ID of the account you wish to withdraw from. ");
		System.out.println("Note: You may only withdraw from accounts with a balance greater than 0. ");
		int accountSelect = UserInput.isInt();  //<--Stores input as an int


		//Ensures the user is only selecting from accounts they own
		try {
			while(!checkAccount.verifyAccountID(customerID, accountSelect)) {
				System.out.println("You do not own the selected account. Please select one from this list: ");
				listAccounts(customerID);
				accountSelect = UserInput.isInt();  //<--Stores input as an int
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {	//Catches exceptions when calling the DaoImpl method
			e.printStackTrace();
		}


		//Checks balance of the selected account to make sure it is not 0
		double balance = 0;
		try {
			balance = checkAccount.getBalance(accountSelect);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(balance == 0) {
			System.out.println("This account cannot be withdrawn from.");  //<--Return to customer menu if cannot withdraw from account
		}
		else{
			System.out.println("Please specify the amount you'd like to withdraw:");  
			double amount = Math.round(UserInput.isDouble() * 100) / 100d;  //<--Stores input as a double

			//Checks to make sure they cannot overdraw account or input an invalid amount
			while(amount < 0 || amount > balance) {
				System.out.println("\n**************************");
				System.out.println("Invalid amount. Please specify the amount you'd like to withdraw:");
				amount = Math.round(UserInput.isDouble() * 100) / 100d;
			}

			//Withdraws from account
			balance -= amount;

			//Updates account with the new balance
			try {
				checkAccount.updateBalance(balance, accountSelect);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			System.out.println("\nYour withdrawl of $" + amount + " was successful.");
		}
	}//end withdraw()


	//------------------------------------Deposit------------------------------------------
	static void deposit(int customerID) {

		System.out.println("\n** Deposit **");  //<--Displays title
		System.out.println("Here are your accounts: " ); 

		//Shows user all accounts they have
		listAccounts(customerID);

		AccountDaoImpl checkAccount = new  AccountDaoImpl();

		//Tells user to select an account with a balance of 0
		System.out.println("Please type in the Account_ID of the account you wish to deposit into. ");
		int accountSelect = UserInput.isInt();  //<--Stores input as an int


		//Ensures the user is only selecting from accounts they own
		try {
			while(!checkAccount.verifyAccountID(customerID, accountSelect)) {
				System.out.println("You do not own the selected account. Please select one from this list: ");
				listAccounts(customerID);
				accountSelect = UserInput.isInt();  //<--Stores input as an int
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {	//Catches exceptions when calling the DaoImpl method
			e.printStackTrace();
		}


		//Gets the current balance of the account
		double balance = 0;
		try {
			balance = checkAccount.getBalance(accountSelect);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//Asks user how much they want to deposit
		System.out.println("Please specify the amount you'd like to deposit:");  
		double amount = Math.round(UserInput.isDouble() * 100) / 100d;  //<--Stores input as a double

		//Deposits into account
		balance += amount;

		//Updates account with the new balance
		try {
			checkAccount.updateBalance(balance, accountSelect);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("\nYour deposit of $" + amount + " was successful.");

	}//end deposit()

}//end UserActions class
