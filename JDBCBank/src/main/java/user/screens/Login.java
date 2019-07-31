package user.screens;

import java.sql.SQLException;
import daoimpl.AdminDaoImpl;
import daoimpl.CustomerDaoImpl;
import daoimpl.UserDaoImpl;

public class Login{

	public static void main(String[] args) {

		//--------------------------------------------Registration & Login Selection--------------------------------------------------------------------
		//Prints welcome screen
		System.out.println("************************************");
		System.out.println("** Welcome to Community Bank B.A. **");
		System.out.println("************************************");

		System.out.println("\nPlease type either 1 or 2 to active the following: "); //<--Prompts user to Register or Login
		System.out.println("(1)Register as a New User  (2)Login as Prexisting Users  ");  

		int login = UserInput.isInt(); //<--Tests users input for int and stores it

		//If user's input exceeds the menu options, they will be reprompted to select a menu option
		while(login != 1 & login != 2) {
			System.out.println("**************************");
			System.out.println("Invalid menu option." );
			System.out.println("Please enter (1)Register or (2)Login." );
			login = UserInput.isInt();
		}


		//--------------------------------------------Registration--------------------------------------------------------------------------------
		if(login == 1) {

			//Username
			System.out.println("\n**************************");
			System.out.println("Please create a Username: ");  //<--Prompts user to create a username
			String username = UserInput.isString();  //<--Stores username into String

			//Checks if they created a unique username, reprompted to enter a new one if not
			UserDaoImpl newUser = new  UserDaoImpl();
			try {
				while(!newUser.checkUsername(username)) {  
					System.out.println("\n**************************");
					System.out.println("This Username already exists. Please create a new Username: ");
					username = UserInput.isString();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {	//Catches exceptions when calling the DaoImpl method
				e.printStackTrace();
			}


			//Password
			System.out.println("Please create a Password: ");
			String password = UserInput.isString();  //<--Stores password into String


			//Profile Type
			//Asks what type of user they are
			System.out.println("Please enter 1 or 2 for your profile type: ");
			System.out.println("(1)Customer  (2)Admin");  
			int profile = UserInput.isInt();  //<--Store type into int

			//Checks if they entered a number outside the suggested range 
			while(profile != 1 & profile != 2) {
				System.out.println("\n**************************");
				System.out.println("Invalid account type.");
				System.out.println("Please enter: (1)Customer  (2)Admin" );
				profile = UserInput.isInt();
			}

			//Stores the userType as a String for database input
			String userType;
			if(profile == 1) {
				userType = "customer";
			}else {
				userType = "admin";
			}

			//Adds user new user to database using a try/catch block
			try {
				newUser.createUser(username, password, userType);
			} catch (SQLException e) {
				e.printStackTrace();
			}


			//Gets user_id for name updating
			int id = 0;
			try {
				id = newUser.getID(username);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}


			//Name
			//Asks the user for their full name
			//This comes after b/c the record is made in the user table, name is updated in either the customer or admin table
			System.out.println("Please enter your full name: ");
			String name = UserInput.isString();  //<--Stores name into String

			//Adds name to the database in either customer or admin depending on profile type 
			CustomerDaoImpl newCustomer = new CustomerDaoImpl();
			AdminDaoImpl newAdmin = new AdminDaoImpl();

			if(profile == 1) {
				try {
					newCustomer.updateCustomerName(name, id);  //<--Updates customer name
				} catch (SQLException e) {
					e.printStackTrace();
				}
				CustomerScreen.customerMenu(username);  //<--Loads in a method to display the customer menu options

			}else {
				try {
					newAdmin.updateAdminName(name, newUser.getID(username));  //<--Updates admin name
				} catch (SQLException e) {
					e.printStackTrace();
				}
				CustomerScreen.customerMenu(username);  //<--Loads in a method to display the customer menu options
			}

		}//end Registration


		//--------------------------------------------Login Username & Password--------------------------------------------------------------------------------
		//Login prexisting users
		else if(login == 2) {

			//Username
			System.out.println("\n**************************");
			System.out.println("Please enter your Username: ");  //<--Prompts user to enter their username
			String username = UserInput.isString();  //<--Stores username into String

			//Checks if the username is valid
			UserDaoImpl newUser = new  UserDaoImpl();
			try {
				while(newUser.checkUsername(username)) {  
					System.out.println("\n**************************");
					System.out.println("The Username given was not found. Please reenter your Username: ");
					username = UserInput.isString();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {	//Catches exceptions when calling the DaoImpl method
				e.printStackTrace();
			}


			//Password
			System.out.println("Please enter your Password: ");
			String password = UserInput.isString();  //<--Stores password into String

			//Checks if user's password matches the one tied to their username/account
			try {
				while(!newUser.checkPassword(username, password)) {
					System.out.println("\n**************************");
					System.out.println("Password did not match the Username. Please reenter your Password: ");
					password = UserInput.isString();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {	//Catches exceptions when calling the DaoImpl method
				e.printStackTrace();
			}


			//--------------------------------------------Login CUSTOMER, EMPLOYEE, & ADMIN--------------------------------------------------------------------------------
			
			//Gets the userType from returning users
			String userType = "";
			try {
				userType = newUser.getType(username);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			//CUSTOMER
			if(userType.equals("customer")) {
				CustomerScreen.customerMenu(username);  //<--Loads in a method to display the customer menu options
			}

			//ADMIN
			else {
				//CustomerScreen.customerMenu(username);  //<--Loads in a method to display the admin menu options
			}

		}//end Login

	}//end main

}//end Login class
