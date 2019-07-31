package user.screens;

import java.util.HashMap;

public class AdminScreen {

	static void adminMenu(AdminDao user, HashMap<Integer, Account> accounts, HashMap<String, User> users) {

		int adminOption;
		do {	
			System.out.println("************************************");
			System.out.println("** Welcome to Community Bank B.A. **");  //<--Prints welcome message
			System.out.println("************************************");

			System.out.println("\nHello " + user.name + "!");
			System.out.println("Please type either 1, 2, 3, 4, 5, 6, or 7 to active the following: ");  //<--Asks Admin what they'd like to do
			System.out.println("(1)Approve/Deny Apps  (2)Approve/Deny Accounts (3)Withdraw  (4)Deposit  (5)Transfer  \n(6)Close Account   (7)Logout");

			adminOption = UserInput.isInt();  //<--Stores input into int

			//Checks that input was one of the listed options
			while(adminOption != 1 & adminOption != 2 & adminOption != 3 & adminOption != 4 & adminOption != 5 & adminOption != 6 & adminOption != 7) {
				System.out.println("\n**************************");
				System.out.println("Invalid menu option.");
				System.out.println("Please enter: (1)Approve/Deny Apps  (2)Approve/Deny Accounts (3)Withdraw  (4)Deposit  (5)Transfer  \n(6)Close Account   (7)Logout" );
				adminOption = UserInput.isInt();
			}

			switch(adminOption) {  //<--Executes the method chosen by the user
			case 1:
				UserActions.accountApproval(accounts);
				break;
			case 2:
				UserActions.adminApproval(users);
				break;
			case 3:
				UserActions.customerInfo(users);

				System.out.println("Please select a Username from the above list:");  //<--Prompts the admin to select a customer
				String username = UserInput.isString();
				//Checks if user entered a valid username
				while(!users.containsKey(username)) {  
					System.out.println("\n**************************");
					System.out.println("The Username given was not found. Please reenter your Username: ");
					username = UserInput.isString();
				}

				UserActions.withdraw((CustomerDao)users.get(username), accounts, users);
				
				break;
			case 4:
				UserActions.customerInfo(users);

				System.out.println("Please select a Username from the above list:");  //<--Prompts the admin to select a customer
				String username1 = UserInput.isString();
				//Checks if user entered a valid username
				while(!users.containsKey(username1)) {  
					System.out.println("\n**************************");
					System.out.println("The Username given was not found. Please reenter the Username: ");
					username1 = UserInput.isString();
				}

				UserActions.deposit((CustomerDao)users.get(username1), accounts, users);
				
				break;
			case 5:
				UserActions.customerInfo(users);

				System.out.println("Please select a Username from the above list:");  //<--Prompts the admin to select a customer
				String username2 = UserInput.isString();
				//Checks if user entered a valid username
				while(!users.containsKey(username2)) {  
					System.out.println("\n**************************");
					System.out.println("\"The Username given was not found. Please reenter the Username: \"");
					username2 = UserInput.isString();
				}

				UserActions.transfer((CustomerDao)users.get(username2), accounts, users);
				
				break;
			case 6:
				UserActions.listAccounts(accounts, users);
				
				System.out.println("Select id: ");  //<--Prompts the admin to select an id
				int id = UserInput.isInt();
				
				//Checks if user entered a valid username
				while(!accounts.containsKey(id)) {  
					System.out.println("\n**************************");
					System.out.println("The id given was not found. Please reenter the full id number: ");
					id = UserInput.isInt();
				}
				accounts.get(id).close();
				
				break;
			case 7:
				Logout.save(accounts, users);  //<--Saves all user's data into a file
				System.out.println("\n\nThanks for your dedication " + user.name + "!");
				System.out.println("\n***********************");
				System.out.println("** Logout Successful **");  //<--Prints goodbye screen
				System.out.println("***********************");
				break;
			}

		}while(adminOption != 7);

	}//end adminMenu()

}//end AdminScreen
