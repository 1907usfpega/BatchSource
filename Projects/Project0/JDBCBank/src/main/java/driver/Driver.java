package driver;


import java.util.ArrayList;
import java.util.Scanner;

import daoimpl.BankUserDaoImpl;
import members.Account;
import members.Customer;
import menu.BankMenu;
import utilities.Helper;
import utilities.Transaction;

public class Driver {
	static Scanner sc = new Scanner(System.in);
	static String username="";
	static String password="";
	static String menuOptions="";
	static Customer c=null;
	static Helper h = new Helper();
	public static void main(String[] args) {
		boolean newUser=newUser();
		//Helper h =new Helper();
		if(!newUser) {
			int loginSuccessful=login();
			int chosenAction=0;
			startPlace(chosenAction, loginSuccessful);
			if(Integer.parseInt(menuOptions)==2) {
				startPlace(chosenAction, loginSuccessful);
			}


		}

	}

	public static void startPlace(int chosenAction, int loginSuccessful) {
		BankMenu m = new BankMenu();
		if(loginSuccessful==1) {
			//Admin access

			chosenAction=m.adminMenu();
		}
		else{

			chosenAction=m.userMenu();
		}
		if(chosenAction == 5) {System.out.println("\n\n\n\n\n\n\n");main(null);}
		if(username.equals("admin")) {
			if(chosenAction==3 ) {
				String select="";
				do {
					System.out.println("1. Do you want to create a new user");
					System.out.println("2. Do you want to create a new account from an exiting user");
					select=sc.nextLine();
					if(Integer.parseInt(select)<1|| Integer.parseInt(select)>2|| !h.isInteger(select)) {
						System.out.println("Invalid input, please pick a number that is shown\n");
						returnTo();
					}

				}
				while(Integer.parseInt(select)<1|| Integer.parseInt(select)>2|| !h.isInteger(select));
				if(Integer.parseInt(select)==1) {
					newUserByAdmin();
				}
				else if(Integer.parseInt(select)==2) {
					newAcctByAdmin();
				}
			}
			else if(chosenAction==4) {
				deleteAcctByAdmin();
			}
			else if(chosenAction==1 || chosenAction==2) {
				int action =m.adminTransMenu();
				makeTransactionsByAdmin(action);	
			}
		}
		else {
			if(chosenAction==3) {
				newAcct();
			}
			else if(chosenAction==4) {
				deleteAcct();
			}
			else if(chosenAction==5) {
				//Logout
			}
			else if(chosenAction==1 || chosenAction==2) {
				int action =m.transMenu();
				BankUserDaoImpl bu = new BankUserDaoImpl();
				ArrayList<Account> accts =bu.getBankAccounts(c.getUsername());
				makeTransactions(accts,action);

			}
		}
	}
	private static boolean newAcctByAdmin() {
		BankUserDaoImpl bu= new BankUserDaoImpl();
		//Helper h = new Helper();
		String usr="";
		Customer cus = new Customer();
		do {
			System.out.println("Enter the username of the person you want to add an account for");
			usr=sc.nextLine();
			cus.setUsername(usr);
		}
		while(!h.isInteger(usr)|| bu.getUserID(cus)!=-1);
		bu.getUserID(cus);
		if(bu.makeNewAcct(cus)) {
			System.out.println("Your new account has been created");
			returnToSmoothe();
			return true;
		}
		System.out.println("We failed to create a new account for you");
		returnToSmoothe();
		return false;

	}


	//Fix this method
	private static void makeTransactionsByAdmin( int action) { 
		String deposit="";
		String acct="";
		String targetAcct="";
		//Helper help = new Helper();
		BankUserDaoImpl bu = new BankUserDaoImpl();
		boolean acctExists=false;

		if(action==1) {
			Transaction t = new Transaction(action);
			do {
				System.out.println("Enter account # you want to view");
				acct=sc.nextLine();
				if(!h.isInteger(acct) || !bu.acctExists(Integer.parseInt(acct))) {
					System.out.println("Please select a valid account number");
					returnTo();
				}	
			}
			while(!h.isInteger(acct) || !bu.acctExists(Integer.parseInt(acct)));
			t.doTransaction(bu.getBankAccount(Integer.parseInt(acct)));
		}

		else if(action ==2 ) {
			do {
				System.out.println("\nEnter the account # you want to deposit into: ");
				acct=sc.nextLine();
				System.out.println("Enter amount you want to deposit");
				deposit =sc.nextLine();
				if(!h.isInteger(acct) ||  !bu.acctExists(Integer.parseInt(acct))) {
					System.out.println("Invalid account number selected, please try again\n\n");
					returnTo();
				}
				else if(!h.isDouble(deposit)) {
					System.out.println("The number you selected is not valid for this transaction");
					returnTo();
				}
				else if(Double.parseDouble(deposit)>9999999) {
					System.out.println("Our bank doesn't do transactions this big, please enter a smaller amount\n\n");
					returnTo();
				}
				else if(Double.parseDouble(deposit)<-1) {
					System.out.println("You cannot deposit a negative number, please try again\n\n");
					returnTo();
				}
			}

			while(!h.isInteger(acct) || !h.isDouble(deposit) ||Double.parseDouble(deposit)>9999999|| !bu.acctExists(Integer.parseInt(acct)));
			Transaction t= new Transaction(action,Double.parseDouble(deposit));
			t.doTransaction(bu.getBankAccount(Integer.parseInt(acct)));

		}

		else if(action ==3 ) {
			do {
				System.out.println("\nEnter the account # you want to withdraw from: ");
				acct=sc.nextLine();
				System.out.println("Enter amount you want to withdraw: ");
				deposit =sc.nextLine();
				if(!h.isInteger(acct) ||  !bu.acctExists(Integer.parseInt(acct))) {
					System.out.println("Invalid account number selected, please try again\n\n");
					returnTo();
				}
				if(!h.isDouble(deposit)) {
					System.out.println("The number you selected is not valid for this transaction");
					returnTo();
				}
				if(Double.parseDouble(deposit)>9999999) {
					System.out.println("Our bank doesn't do transactions this big, please enter a smaller amount\n\n");
					returnTo();
				}
				if(Double.parseDouble(deposit)<-1) {
					System.out.println("You cannot withdraw a negative number, please try again\n\n");
					returnTo();
				}
			}

			while(!h.isInteger(acct) || !h.isDouble(deposit) ||Double.parseDouble(deposit)>9999999|| !bu.acctExists(Integer.parseInt(acct)));
			Transaction t= new Transaction(action,Double.parseDouble(deposit));
			t.doTransaction(bu.getBankAccount(Integer.parseInt(acct)));

		}

		else if(action==4) {
			do {
				System.out.println("\nWhich account are you transfering from: ");
				acct=sc.nextLine();
				System.out.println("Enter account number you are transfering to");
				targetAcct=sc.nextLine();
				System.out.println("Enter amount you want to deposit");
				deposit =sc.nextLine();
				acctExists=bu.acctExists(Integer.parseInt(targetAcct));
				if(!h.isInteger(acct) || !bu.acctExists(Integer.parseInt(acct))) {
					System.out.println("Invalid account number selected, please try again\n\n");
					returnTo();
				}
				if(!h.isDouble(deposit)) {
					System.out.println("The number you selected is not valid for this transaction\n\n");
					returnTo();
				}
				if(Double.parseDouble(deposit)<-1) {
					System.out.println("You cannot deposit/withdraw a negative number, please try again\n\n");
					returnTo();
				}
				if(Double.parseDouble(deposit)>9999999) {
					System.out.println("Our bank doesn't do transactions this big, please enter a smaller amount\n\n");
					returnTo();
				}
				if(!acctExists) {
					System.out.println("The account you selected is not in our system, please enter a different account number\n\n");
					returnTo();
				}

			}	
			while(!h.isInteger(acct) ||!h.isInteger(targetAcct)||!acctExists||!h.isDouble(deposit) ||Double.parseDouble(deposit)>9999999||   !bu.acctExists(Integer.parseInt(acct)) );
			Account source = bu.getBankAccount(Integer.parseInt(acct));
			Account target = bu.getBankAccount(Integer.parseInt(targetAcct));
			Transaction t= new Transaction(action,target,Double.parseDouble(deposit));
			t.doTransaction(source);



		}
		returnToSmoothe();
	}



	private static boolean deleteAcctByAdmin() {
		BankUserDaoImpl bu = new BankUserDaoImpl();
		//Helper help = new Helper();
		String acctToDelete="";
		ArrayList<Account> accts =bu.getBankAccounts(c.getUsername());
		do {
			System.out.println("\nSelect account you want to delete: ");
			for(int x=0; x<accts.size();x++) {
				System.out.println(x+1+". "+accts.get(x).getAcctNum());
			}
			acctToDelete= sc.nextLine();
			if(!h.isInteger(acctToDelete) ||  Integer.parseInt(acctToDelete)<1 ||Integer.parseInt(acctToDelete)>accts.size()) {
				System.out.println("Invalid account number selected, please try again\n\n");
				returnTo();
			}

		}
		while(!h.isInteger(acctToDelete) ||  Integer.parseInt(acctToDelete)<1 ||Integer.parseInt(acctToDelete)>accts.size());
		if(accts.get(Integer.parseInt(acctToDelete)-1).getBalance()<1) {
			System.out.println("You can not delete this account because you still have money in it");
			returnToSmoothe();
			return false;
		}
		else {
			boolean deleted = bu.deleteAcct(accts.get(Integer.parseInt(acctToDelete)-1));
			returnToSmoothe();
			return deleted;
		}

	}



	private static boolean newUserByAdmin() {
		String verifyPassword;
		BankUserDaoImpl bu = new BankUserDaoImpl();
		do {
			System.out.print("Please enter a username: ");
			username = sc.nextLine();
			System.out.print("Please enter a password: ");
			password = sc.nextLine();
			System.out.print("Please re-enter your password: ");
			verifyPassword = sc.nextLine();
		}
		while (!password.equals(verifyPassword)) ;
		bu.createNewUser(username, password);
		System.out.println("Your account has been succesfully created!\n\nWe have deposited $100 in your account for opening a new bank account :)\n\n\n\n");
		returnToSmoothe();
		return true;
	}



	private static boolean deleteAcct() {
		BankUserDaoImpl bu = new BankUserDaoImpl();
		//Helper help = new Helper();
		String acctToDelete="";
		ArrayList<Account> accts =bu.getBankAccounts(c.getUsername());
		do {
			System.out.println("\nSelect account you want to delete: ");
			for(int x=0; x<accts.size();x++) {
				System.out.println(x+1+". "+accts.get(x).getAcctNum());
			}
			acctToDelete= sc.nextLine();
			if(!h.isInteger(acctToDelete) ||  Integer.parseInt(acctToDelete)<1 ||Integer.parseInt(acctToDelete)>accts.size()) {
				System.out.println("Invalid account number selected, please try again\n\n");
				returnTo();
			}

		}
		while(!h.isInteger(acctToDelete) ||  Integer.parseInt(acctToDelete)<1 ||Integer.parseInt(acctToDelete)>accts.size());
		if(accts.get(Integer.parseInt(acctToDelete)-1).getBalance()>0) {
			System.out.println("You can not delete this account because you still have money in it");
			returnTo();
			return false;
		}
		else {
			boolean deleted = bu.deleteAcct(accts.get(Integer.parseInt(acctToDelete)-1));
			returnToSmoothe();
			return deleted;
		}
	}

	private static boolean newAcct() {
		BankUserDaoImpl bu= new BankUserDaoImpl();
		bu.getUserID(c);
		if(bu.makeNewAcct(c)) {
			System.out.println("Your new account has been created");
			returnToSmoothe();
			return true;
		}
		System.out.println("We failed to create a new account for you");
		returnTo();
		return false;

	}

	public static void makeTransactions(ArrayList<Account> accts, int action) {
		String deposit="";
		String sourceAcct="";
		String targetAcct="";
		//Helper help = new Helper();
		BankUserDaoImpl bu = new BankUserDaoImpl();
		boolean acctExists=false;

		if(action==1) {
			Transaction t = new Transaction(action);
			for(int x=0;x<accts.size();x++) {
				t.doTransaction(accts.get(x));
			}
		}

		else if(action ==2 ) {
			do {
				System.out.println("\nSelect an account: ");
				for(int x=0; x<accts.size();x++) {
					System.out.println(x+1+". "+accts.get(x).getAcctNum());
				}
				sourceAcct= sc.nextLine();
				System.out.print("Enter amount you want to deposit:  ");
				deposit =sc.nextLine();
				if(!h.isInteger(sourceAcct) ||  Integer.parseInt(sourceAcct)<1 ||Integer.parseInt(sourceAcct)>accts.size()) {
					System.out.println("Invalid account number selected, please try again\n\n");
					returnTo();
				}
				else if(!h.isDouble(deposit)) {
					System.out.println("The number you selected is not valid for this transaction");
					returnTo();
				}
				
				else if(Double.parseDouble(deposit)<0) {
					System.out.println("You cannot deposit a negative number, please try again\n\n");
					returnTo();
				}
				else if(Double.parseDouble(deposit)>9999999) {
					System.out.println("Our bank doesn't do transactions this big, please enter a smaller amount\n\n");
					returnTo();
				}
			}

			while(!h.isInteger(sourceAcct) || !h.isDouble(deposit) ||Double.parseDouble(deposit)>9999999|| Integer.parseInt(sourceAcct)<1 ||Integer.parseInt(sourceAcct)>accts.size() );
			Transaction t= new Transaction(action,Double.parseDouble(deposit));
			t.doTransaction(accts.get(Integer.parseInt(sourceAcct)-1));
		}

		else if(action ==3 ) {
			do {
				System.out.println("\nSelect an account: ");
				for(int x=0; x<accts.size();x++) {
					System.out.println(x+1+". "+accts.get(x).getAcctNum());
				}
				sourceAcct= sc.nextLine();
				System.out.print("Enter amount you want to withdraw:   ");
				deposit =sc.nextLine();
				if(!h.isInteger(sourceAcct) ||  Integer.parseInt(sourceAcct)<1 ||Integer.parseInt(sourceAcct)>accts.size()) {
					System.out.println("Invalid account number selected, please try again\n\n");
					returnTo();
				}
				if(!h.isDouble(deposit)) {
					System.out.println("The number you selected is not valid for this transaction");
					returnTo();
				}
				if(Double.parseDouble(deposit)>9999999) {
					System.out.println("Our bank doesn't do transactions this big, please enter a smaller amount\n\n");
					returnTo();
				}
				if(Double.parseDouble(deposit)<-1) {
					System.out.println("You cannot withdraw a negative number, please try again\n\n");
					returnTo();
				}
			}

			while(!h.isInteger(sourceAcct) || !h.isDouble(deposit) || Integer.parseInt(sourceAcct)<1 ||Double.parseDouble(deposit)>9999999||Integer.parseInt(sourceAcct)>accts.size() );
			Transaction t= new Transaction(action,Double.parseDouble(deposit));
			t.doTransaction(accts.get(Integer.parseInt(sourceAcct)-1));
		}

		else if(action==4) {
			do {
				System.out.println("\nWhich account are you transfering from: ");
				for(int x=0; x<accts.size();x++) {
					System.out.println(x+1+" "+accts.get(x).getAcctNum());
				}
				sourceAcct= sc.nextLine();
				System.out.println("Enter account number you are transfering to");
				targetAcct=sc.nextLine();
				System.out.print("Enter amount you want to deposit:  ");
				deposit =sc.nextLine();

				try {
					acctExists=bu.acctExists(Integer.parseInt(targetAcct));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(!h.isInteger(sourceAcct) ||  Integer.parseInt(sourceAcct)<1 ||Integer.parseInt(sourceAcct)>accts.size()) {
					System.out.println("Invalid account number selected, please try again\n\n");
					returnTo();
				}
				if(!h.isDouble(deposit)) {
					System.out.println("The number you selected is not valid for this transaction\n\n");
					returnTo();
				}
				if(Double.parseDouble(deposit)>9999999) {
					System.out.println("Our bank doesn't do transactions this big, please enter a smaller amount\n\n");
					returnTo();
				}
				if(Double.parseDouble(deposit)<-1) {
					System.out.println("You cannot deposit/withdraw a negative number, please try again\n\n");
					returnTo();
				}
				if(!acctExists) {
					System.out.println("The account you selected is not in our system, please enter a different account number\n\n");
					returnTo();
				}

			}
			while(!h.isInteger(sourceAcct) ||!h.isDouble(deposit) ||!h.isInteger(targetAcct)||!acctExists||  Double.parseDouble(deposit)>9999999||Integer.parseInt(sourceAcct)<1 ||Integer.parseInt(sourceAcct)>accts.size() );
			Account target;
			try {
				target = bu.getBankAccount(Integer.parseInt(targetAcct));
				Transaction t= new Transaction(action,target,Double.parseDouble(deposit));
				t.doTransaction(accts.get(Integer.parseInt(sourceAcct)-1));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		returnToSmoothe();
	}

	//If customer selects "y" then the begin the registration process
	public static boolean newUser() {

		String customerAnswers;
		String verifyPassword;
		BankUserDaoImpl bu = new BankUserDaoImpl();
		System.out.print("Welcome to the JDBC Banking Application\n\nAre you a new customer(y/n):  ");

		do {
			customerAnswers = sc.nextLine();
			
			if(customerAnswers.equals("y")|| customerAnswers.equals("Y")) {
				do {
				System.out.print("Please enter a username: ");
				username = sc.nextLine();
				if(bu.userAlreadyExists(username)) {
					System.out.println("\nThis username already exists\n");
				}
			}
				while(bu.userAlreadyExists(username));
				System.out.print("Please enter a password: ");
				password = sc.nextLine();
				System.out.print("Please re-enter your password: ");
				verifyPassword = sc.nextLine();
				while (!password.equals(verifyPassword)) {
					System.out.print("Passwords did not match.\n\nPlease enter a password: ");
					password = sc.nextLine();
					System.out.print("Please re-enter your password: ");
					verifyPassword = sc.nextLine();
				}
				
				bu.createNewUser(username, password);
				c=new Customer(username,password);
				System.out.println("\n\nYour account has been succesfully created!\n\nWe have deposited $100 in your account for opening a new bank account :)\n\n\n\n");
				return false;
				
			}
			else if(!customerAnswers.equals("n")|| !customerAnswers.equals("n")) {
				System.out.println("Invalid input, please try again!");
			}
		}
		while(!customerAnswers.equals("n") || customerAnswers.equals("N"));
		return false;

	}

	//if customer already has an account they login returns 1 if its the admin and 2 if it's a regular user
	public static int login() {
		BankUserDaoImpl bu = new BankUserDaoImpl();

		do {
			System.out.print("Enter username:  ");
			username = sc.nextLine();
			System.out.print("Enter password:  ");
			password = sc.nextLine();
			if(bu.userAuthentication(username,password)) {
				System.out.println("\n\nLogin Successful!\n\n");
				if(username.equals("admin")) {
					return 1;
				}
				c=new Customer(username,password);
				return 2;
			}
			else if(!bu.userAuthentication(username, password)) {
				System.out.println("The username/password is incorrect, please try again\n\n");


			}
		}
		while(!bu.userAuthentication(username, password));

		return -1;
	}
	//After successful transaction you press 1 to take yu back to the main menu
	public static void returnToSmoothe() {

		do { 
			System.out.println("Press 1 to continue"); 
			menuOptions=sc.nextLine(); 
			if(!h.isInteger(menuOptions) || Integer.parseInt(menuOptions)!=1) {
				System.out.println("Please do what I tell you, Thank you(:");
			}
		} 
		while(!h.isInteger(menuOptions) || Integer.parseInt(menuOptions)!=1);
		if(Integer.parseInt(menuOptions)==1) {
			if(username.equals("admin")) {
				startPlace(0,1);
			}
			else {
				startPlace(0,2); 
			}
		}
	}
	//after a user entry fails it either gives you the option to try again:1 or just return to the main main:2
	public static void returnTo() {

		do { 
			System.out.println("\n1. Continue trying");
			System.out.println("2. Go back to start menu"); 
			menuOptions=sc.nextLine();
			
		} 
		while(!h.isInteger(menuOptions) || Integer.parseInt(menuOptions)<1 && Integer.parseInt(menuOptions)>2);
		if(Integer.parseInt(menuOptions)==2) {
			if(username.equals("admin")) {
				startPlace(0,1);
			}
			else {
				startPlace(0,2); 
			}
		}
	}

}
