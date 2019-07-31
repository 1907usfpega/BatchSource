package ProjectTest;

public class CustomerScreen {

	//Need to take in username to get info
	public static void main(String[] args) {

		//customerMenu() {
		int customerOption;
		do {	
		System.out.println("************************************");
		System.out.println("** Welcome to Community Bank B.A. **");
		System.out.println("************************************");

		System.out.println("\nHello " + "name!");//<--Need user's name
		System.out.println("Please type either 1, 2, 3, 4, 5 to active the following: ");
		System.out.println("(1)Make new Account  (2)Withdraw  (3)Deposit  (4)Transfer   (5)Logout");

		customerOption = TestInput.isInt();

		while(customerOption != 1 & customerOption != 2 & customerOption != 3 & customerOption != 4 & customerOption != 5) {
			System.out.println("\n**************************");
			System.out.println("Invalid menu option." );
			System.out.println("Please enter: (1)New Account  (2)Withdraw  (3)Deposit  (4)Transfer   (5)Logout" );
			customerOption = TestInput.isInt();
		}

		switch(customerOption) {
		case 1:
			//Redirect to new Account screen
			break;
		case 2:
			withdraw();
			break;
		case 3:
			deposit();
			break;
		case 4:
			transfer();
			break;
		case 5:
			System.out.println("\n\n**********************************");
			System.out.println("** Logout Successful, Thank You **");
			System.out.println("**********************************");
			break;
		}

		}while(customerOption != 5);
		
	}//end customerMenu

	
//------------------------------------Withdraw-------------------------------------------
	static void withdraw() {

		System.out.println("\n** Withdraw **");
		System.out.println("Here are your accounts: " );//<--Load in all accounts   ID + Type + Balance
		//For loop to display all accounts they have

		System.out.println("\nPlease specify which account you'd like to withdraw from.");
		System.out.println("Enter a number " + "(numbers of accounts)"); //<--Need list size

		//Need while loop to keep in scope
		int accountSelect = TestInput.isInt();
		//Get account at [accountSelection]
		//Save into variable

		System.out.println("\nThis account currently has " + "(balance)"); //<--Get balance of account
		System.out.println("Please specify the amount you'd like to withdraw:");

		//Need while loop so not greater than balance
		double amount = Math.round(TestInput.isDouble() * 100) / 100d;
		
		//Balance -= amount;
		//Update balance

		System.out.println("\nYour withdrawl of " + amount + " was successful."); 
		System.out.println("Your new balance is: " + "(balance)"); //<--Print updated balance

		//call customerMenu

	}//end withdraw()


//------------------------------------Deposit------------------------------------------
	static void deposit() {

		System.out.println("\n** Deposit **");
		System.out.println("Here are your accounts: " );//<--Load in all accounts   ID + Type + Balance
		//For loop to display all accounts they have

		System.out.println("\nPlease specify which account you'd like to deposit into.");
		System.out.println("Enter a number " + "(numbers of accounts)"); //<--Need list size

		//Need while loop to keep in scope
		int accountSelect = TestInput.isInt();
		//Get account at [accountSelection]
		//Save into variable

		System.out.println("\nThis account currently has " + "(balance)"); //<--Get balance of account
		System.out.println("Please specify the amount you'd like to deposit:");

		double amount = Math.round(TestInput.isDouble() * 100) / 100d;

		//Balance += amount;
		//Update balance

		System.out.println("\nYour deposit of " + amount + " was successful."); 
		System.out.println("Your new balance is: " + "(balance)"); //<--Print updated balance

		//call customerMenu

	}//end deposit()
	
	
//------------------------------------Transfer------------------------------------------
		static void transfer() {

			System.out.println("\n** Transfer **");
			System.out.println("Here are your accounts: " );//<--Load in all accounts   ID + Type + Balance
			//For loop to display all accounts they have

			System.out.println("\nPlease specify which account you'd like to transfer from.");
			System.out.println("Enter a number " + "(numbers of accounts)"); //<--Need list size

			//Need while loop to keep in scope
			int accountSelect = TestInput.isInt();
			//Get account at [accountSelection]
			//Save into variable
			
			System.out.println("\nPlease specify which account you'd like to transfer to.");
			System.out.println("Enter a number " + "(numbers of accounts)"); //<--Need list size

			//Need while loop to keep in scope
			int accountSelect2 = TestInput.isInt();
			//Get account at [accountSelection]
			//Save into variable

			System.out.println("\nYour account currently has " + "(balance)"); //<--Get balance of account
			System.out.println("Please specify the amount you'd like to transfer:");

			//Need while loop so not greater than balance
			double amount = Math.round(TestInput.isDouble() * 100) / 100d;

			//Balance -= amount;  <--accountSelect
			//Balance += amount;  <--accountSelect2
			//Update balances

			System.out.println("\nYour transfer of " + amount + " was successful."); 
			System.out.println("Your new balance is: " + "(balance)"); //<--Print updated balance of accountSelect

			//call customerMenu

		}//end transfer()
		
}//end CustomerScreen
