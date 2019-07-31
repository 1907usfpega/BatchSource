package ProjectTest;

public class Menu {

	public static void main(String[] args) {
		
		System.out.println("************************************");
		System.out.println("** Welcome to Community Bank B.A. **");
		System.out.println("************************************");
		
		System.out.println("\nPlease type either 1 or 2 to active the following: ");
		System.out.println("(1)Register as a New User  (2)Login as Prexisting Users  ");
		
		int login = TestInput.isInt();
	
		while(login != 1 & login != 2) {
			System.out.println("**************************");
			System.out.println("Invalid menu option." );
			System.out.println("Please enter (1)Register or (2)Login." );
			login = TestInput.isInt();
		}
		
		//Registration
		if(login == 1) {
			//Call Registration menu
			//Or call same username & password field, both check, but one adds to database
			System.out.println("**************************");
			System.out.println("Please enter a Username: " );
			String username = TestInput.isString();
			//Check user name against database
				//Return error if already exists
				//Continue to password if not
			System.out.println("Please create a Password: " );
			String password = TestInput.isString();
			
			//Enter user info
			System.out.println("Please enter your Name: " );
			String name = TestInput.isString();
			System.out.println("Please enter your account type: " );
			System.out.println("(1)Customer  (2)Employee  (3)Admin");
			int userType = TestInput.isInt();
			while(userType != 1 & userType != 2 & userType != 3) {
				System.out.println("**************************");
				System.out.println("Invalid account type." );
				System.out.println("Please enter: (1)Customer  (2)Employee  (3)Admin" );
				userType = TestInput.isInt();
			}
			
			
			//Customer account
			if(userType == 1) {
				//Add this to Customer Map
				System.out.println("Please input your SSN (without space or special characters."); //<--Need to get name
				System.out.println("Example: 342XXXX77");
				TestInput.isDouble();
				//Connect to customerScreen;
			}
			
			//Employee account
			else if(userType == 2) {
				//Puts in request for approval
				//Run newEmployee();
				//Connect to employeeScreen;
			}
			
			else if(userType == 3) {
				//Puts in request for approval
				//Run newAdmin();
				//Connect to adminScreen;
			}
		}
		
		//Login
		else if(login == 2) {
			//Call Login menu
			//Or call same username & password field, both check, but one adds to database
			System.out.println("**************************");
			System.out.println("Please enter your username: " );
			String username = TestInput.isString();
			//Check user name against database
				//Return error if not already exists
				//Continue to password if not
			System.out.println("Please enter your password: " );
			String password = TestInput.isString();
			//Verify password is connected to username
				//If not, loop back through username & password
			
			//If successful, go onto to customer, employee, or admin screen
			/*
			 * if(something parsed == 1){
			 * 		run customerScreen();
			 * }
			 * if(something parsed == 2){
			 * 		run employeeScreen();
			 * }
			 * if(something parsed == 3){
			 * 		run adminScreen();
			 * }
			 */
		}
		
		//Call user main screen
		
	}//end main

}//end Menu class
