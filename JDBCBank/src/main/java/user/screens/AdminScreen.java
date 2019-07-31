package user.screens;

import java.sql.SQLException;

import daoimpl.UserDaoImpl;

public class AdminScreen {

	static void adminMenu(String username) {

		int adminOption;
		do {
			UserDaoImpl getUser = new  UserDaoImpl();
			int userID = 0;
			try {
				userID = getUser.getID(username); //<--Gets userID
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//--------------------------------------------Admin Menu--------------------------------------------------------------------------------	
			System.out.println("************************************");
			System.out.println("** Welcome to Community Bank B.A. **");  //<--Prints welcome message
			System.out.println("************************************");

			System.out.println("\nPlease type either 1, 2, 3, 4, or 5 to active the following: ");  //<--Asks Admin what they'd like to do
			System.out.println("(1)View Users  (2)Create Users  (3)Update Users (4)Delete Users  (5)Logout");

			adminOption = UserInput.isInt();  //<--Stores input into int


			//--------------------------------------------Runnable Options--------------------------------------------------------------------------------	
			switch(adminOption) { 
			case 1: //View
				AdminPrivileges.listUsers();  //<--Runs method to view users
				break;

			case 2: //Create
				AdminPrivileges.createUser();  //<--Runs method to create a user
				break;

			case 3: //Update
				AdminPrivileges.updateUser();  //<--Runs method to update a user
				break;

			case 4: //Delete
				AdminPrivileges.deleteUser(userID);  //<--Runs method to delete a user
				break;

			case 5: //Logout
				System.out.println("\n\nThank You!");
				System.out.println("\n***********************");
				System.out.println("** Logout Successful **");  //<--Prints goodbye screen
				System.out.println("***********************");
				break;
			}

		}while(adminOption != 5);

	}//end adminMenu()

}//end AdminScreen
