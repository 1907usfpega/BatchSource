package avbank;

import java.util.InputMismatchException;
import java.util.Scanner;



/*
 * Bank Assignment 
Due: 7/30 5pm
Console application: 

A registered user can login with their username and password
An unregistered user can register by creating a username and password 
An Admin can view, create, update, and delete all users.

A user can view their own existing accounts and balances. 
A user can create an account.
A user can delete an account if it is empty.  
A user can add to or withdraw from an account. 
A user can execute multiple deposits or withdrawals in a session. 
A user can logout.

Use sequences to generate USER_ID and BANK_ACCOUNT_ID.   
Throw custom exceptions in the event of user error (overdraft, incorrect password, etc). 
Provide validation messages through the console for all user actions. 
Use the DAO design pattern.  
Store Admin username/password and database connection information in a properties file. 

Required technologies: 
PL/SQL with at least one stored procedure, JDBC with prepared and callable statements,
Scanner for user input, JUnit tests on as much of the program as possible. Transactions will be logged into a DB table with Log4J.

Bonus: 
A user may view transaction history. 

Create a Maven project with your solution as JDBCBank, include it in your branch with your DB creation script (JDBCBank.sql). 

Use log4J to log data transactions in the database and http appender and use JUnit for unit testing


 */

public class BankApp {
	
	
	public static void run(AwsConnection aws) {
		String[] loginInfo = new String[2]; // {Username, Password}
		// print welcome
		
		do {
			do {
				// ask if new or existing user
			} while(isBadInput);
			
			if (newUser) {
				do {
					// prompt for new userName
				} while (false); // do while username is not already in the DB
				do {
					// prompt for password
				} while(false); // do while password was entered incorrectly
			} else if (existingUser) {
				do {
					// prompt for username
				} while(false); // do while username is not in DB
				do {
					// prompt for password
				} while(); // do while password does not match with supplied username
				
			} else {
				// exit
				System.exit(0);
			}
			// time to log them in as either an admin or user
			if(isAdmin) {
				// display admin menu
			} else {
				// display user menu
			}
			// logout has occurred
		
		} while (true);		
	}
	
	public static void adminConsole(String[] loginInfo) {
		while(true) {
			do {
			// print menu
			// prompt for input
			} while(false); // do while user has not entered good input
			
			if (viewUsers) {
				// print users
			} else if (createUsers) {
				// prompt for user input
			} else if(updateExistingUser) {
				// prompt for user input
			} else if(deleteUser) {
				// promt for user input
			} else {
				// logout
				return;
			}
			
		} 
		
	}
	
	public static void customerConsole(String[] loginInfo) {
		while(true) {
			do {
			// print menu
			// prompt for input
			} while(false); // do while user has not entered good input
			
			if (listOwnedAccounts) {
				// print users
			} else if (createNewAccount) {
				// prompt for user input
			} else if(deleteExistingAccount) {
				// prompt for user input
			} else if(deposit) {
				// promt for user input
			} else if(withdraw) {
				// promt for user input
			} else {
				// logout
				return;
			}
			
		}
	}

	public static void main(String[] args) {
		String[] loginInfo = new String[2]; // {Username, Password}
		
		
		
		
		BankApp.run(aws);
		
		/*
		Scanner in = new Scanner(System.in);
		//--------------------------------------------Registration & Login Selection--------------------------------------------------------------------
		//Prints welcome screen
		System.out.println("************************************");
		System.out.println("** Welcome to Community Bank A.V. **");
		System.out.println("************************************");

		System.out.println("\nPlease type either 1 or 2 to select the following options: "); //<--Prompts user to Register or Login
		System.out.println("(1)Register as a New User  (2)Login as Prexisting User  ");  

		int mode = Integer.parseInt(in.next()); 

		//If user's input exceeds the menu options, they will be reprompted to select a menu option
		while(mode != 1 & mode != 2) {
			System.out.println("**************************");
			System.out.println("Invalid menu option." );
			System.out.println("Please enter (1)Register or (2)Login." );
			mode = Integer.parseInt(in.next());
		}
		
		if (mode == 1) {
			// create new user
			//Username
			System.out.println("\n**************************");
			System.out.println("Please create a Username: ");  //<--Prompts user to create a username
			String username = in.next();  //<--Stores username into String

			//Checks if they created a unique username, reprompt to enter a new one if not
			while(true) { // TODO  while userName exists in the customer.customerId column  
				System.out.println("\n**************************");
				System.out.println("This Username already exists. Please create a new Username: ");
				username = in.next();
			}


			//Password
			System.out.println("Please create a Password: ");
			// TODO maybe add some sort of input validation
			String password = in.next();  //<--Stores password into String


			//Account Type
			//Asks what type of user they are
			int userType = -1;
			do {
				System.out.println("Please enter 1 or 2 for your profile type: ");
				System.out.println("(1)Customer  (2)Admin");  //<--Employee & Admin will need approval
			
				try {
					userType = in.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Input not accepted.\n");
					continue;
				}
			} while (true);
			// TODO add the user to the database
		} else {
			// login existing user
			//Username
			System.out.println("\n**************************");
			System.out.println("Please enter your Username: ");  //<--Prompts user to enter their username
			String userName = in.next();  //<--Stores username into String

			//Checks if user entered a valid username
			while() {  // TODO  while userName does not exist in the customer.customerId column  
				System.out.println("\n**************************");
				System.out.println("The Username given was not found. Please reenter your Username: ");
				userName = in.next();
			}
			// Valid username has been determined
			loginInfo[0] = userName;

			//Password
			System.out.println("Please enter your Password: ");
			String password = in.next();  //<--Stores password into String

			//Checks if user's password matches the one tied to their username/account
			while() { // TODO
				System.out.println("\n**************************");
				System.out.println("Password did not match the Username. Please reenter your Password: ");
			}
		}
		// Now the user has either created a new user or logged in with an existing user/pass
		*/


	}

}
