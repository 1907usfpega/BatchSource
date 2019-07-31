package avbank;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;



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
	/**
	 * Assumes the input ResultSet only contains one column
	 * 
	 * @param rs
	 * @param test
	 * @return
	 * @throws SQLException
	 */
	public static boolean columnContains(ResultSet rs, String test) throws SQLException {
		String existingUser;
		while(rs.next()) {
			existingUser = rs.getString(1);
			if (test.equals(existingUser)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isInteger(String s) {
        return isInteger(s, 10);
    }
    
    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i), radix) < 0) return false;
        }
        return true;
    }
	
	
	public static void run() {
		String alphaNumRegex = "^[a-zA-Z0-9]+$";
		Pattern isAlphaNumeric = Pattern.compile(alphaNumRegex);
		
		AwsConnection aws = AwsConnection.getInstance();
		
		
		
		String[] loginInfo = new String[2]; // {Username, Password}
		Scanner consoleIn = new Scanner(System.in);
		String input;
		int choice = -1;
		
		System.out.println("************************************");
		System.out.println("** Welcome to Community Bank A.V. **");
		System.out.println("************************************");
		System.out.println();
		
		do {
			boolean isAdmin = false;
			do {
				
				// ask if new or existing user
				System.out.println("Please type your selection below.\n");
				System.out.println("Are you a new or existing user?");
				System.out.println("1. Existing user.");
				System.out.println("2. New user.");
				System.out.println("3. Exit application.");
				input = consoleIn.nextLine();
				
				if(isInteger(input)) {
					choice = Integer.valueOf(input);
					break;
				} else {
					System.out.println("Invalid input detected\n");
					continue;
				}
				
			} while(choice != 1 || choice != 2);
			
			if (choice == 2) {
				String potentialUserName;
				String potentialPassword;
				do {
					// prompt for new userName
					System.out.println("Please enter your desired user name. Only alphanumeric characters are allowed.");
					potentialUserName = consoleIn.nextLine();
					if (isAlphaNumeric.matcher(potentialUserName).matches()) {
						// TODO check if username exists in the database
						Statement stmt;
						ResultSet userSet;
						ResultSet passwordSet;
						try {
							stmt = aws.getConnection().createStatement();
							userSet = stmt.executeQuery("SELECT username FROM CUSTOMER");
							
							if (columnContains(userSet, potentialUserName)) {
								// username is taken
								System.out.println("Username is already in use.");
								continue;
							}
						} catch (SQLException e) {
							e.printStackTrace(); // TODO figure out what to do here
							System.exit(1);
						}
						break; // username is not taken and we can now ask the user for a password
					} else {
						System.out.println("Error: Please enter a valid user name.\n");
					}
				} while (true); // do while username is not already in the DB
				do {
					// prompt for password
					System.out.println("Please enter your desired password. Only alphanumeric characters are allowed.");
					potentialPassword = consoleIn.nextLine();
					if (isAlphaNumeric.matcher(potentialPassword).matches()) {
						break;
					} else {
						System.out.println("Error: Please enter a valid password.\n");
					}
				} while(true); // do while password was entered incorrectly
				// finish creating the user
				System.out.println("Thank you!");
				System.out.println("Please follow the prompts to finish creating your account.");
				String fName;
				String lName;
				String email;
				String phone;
				System.out.print("Please enter your first name: ");
				fName = consoleIn.nextLine();
				System.out.print("Please enter your last name: ");
				lName = consoleIn.nextLine();
				System.out.print("Please enter your email address: ");
				email = consoleIn.nextLine();
				System.out.print("Please enter your phoneNumber without any spaces: ");
				phone = consoleIn.nextLine();
				
				try {
					CallableStatement insertCall = aws.getConnection().prepareCall("{call insertNewCustomer(?, ?, ?, ?, ?, ?)}");
					insertCall.setString(1, potentialUserName);
					insertCall.setString(2, potentialPassword);
					insertCall.setString(3, fName);
					insertCall.setString(4, lName);
					insertCall.setString(5, email);
					insertCall.setString(6, phone);
					insertCall.execute();
					System.out.println("Created new user "+ potentialUserName);
					System.out.println();
					System.out.println();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.exit(11);
				}
				
			} else if (choice == 1) {
				String user;
				String pass;
				do {
					// prompt for username
					System.out.print("Please enter your user name: ");
					user = consoleIn.nextLine();
					System.out.print("Please enter your password: ");
					pass = consoleIn.nextLine();
					
					if(user.equals("admin") && pass.equals("admin")) {
						isAdmin = true;
						break;
					}
					Statement stmt;
					ResultSet userSet;
					ResultSet passwordSet;
					try {
						stmt = aws.getConnection().createStatement();
						userSet = stmt.executeQuery("SELECT username FROM CUSTOMER");
					
						if(columnContains(userSet, user)) {
							passwordSet = stmt.executeQuery("SELECT pass FROM CUSTOMER");
							if (columnContains(passwordSet, pass)) {
								// login successful
								System.out.println("Login Successful\n");
								loginInfo[0] = user;
								loginInfo[1] = pass;
								break;
							} else {
								System.out.println("Username/Password combination not found.\n");
								continue;
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
						System.exit(1); // TODO determine what to do here if an exception occurs
					}
				} while(true); // do while username/pass is not in DB
				
			} else if (choice == 3) {
				// exit
				consoleIn.close();
				System.exit(0);
			} else {
				System.out.println("Please enter 1, 2, or 3.\n");
				continue;
			}
			// time to log them in as either an admin or user
			if(isAdmin) {
				// display admin menu
				adminConsole(new String[]{"admin", "admin"}); // TODO fix this garbage
			} else {
				// display user menu
				customerConsole(loginInfo);
			}
			// logout has occurred
		
		} while (true);		
	}
	
	public static void adminConsole(String[] loginInfo) {
		AwsConnection aws = AwsConnection.getInstance();
		Scanner adminIn = new Scanner(System.in);
		
		String inputLine;
		System.out.println("\n\n\n\nWelcome to the Admin Console!\n");
		
		while(true) {
			do {
				// print menu
				System.out.println("Command list:");
				System.out.println("create <username> <password> <firstname> <lastname> <email> <phoneNumber> \n -- Create a new customer");
				System.out.println("delete <userID> \n -- Deletes a customer");
				//System.out.println("help \n -- Prints the command list");
				System.out.println("list \n -- Lists all customers.");
				System.out.println("logout \n -- Logs out of the current user session.");
				System.out.println("update <userID> <firstname> <lastname> <email> <phone> \n -- Updates the info of the specified user.");
				System.out.println();
				// prompt for input
				inputLine = adminIn.nextLine();
				Scanner sc = new Scanner(inputLine);
				if (sc.hasNext()) {
					String mode = sc.next();
					
					
					if(mode.equals("create")) { // CREATE MODE
						ArrayList<String> argList = new ArrayList<String>();
						while(sc.hasNext()) {
							argList.add(sc.next());
						}
						
						if(argList.size() == 6) { // we are ready to construct the call
							try {
								CallableStatement insertCall = aws.getConnection().prepareCall("{call insertNewCustomer(?, ?, ?, ?, ?, ?)}");
								for (int i = 0; i < 6 ; i++) {
									insertCall.setString(i+1, argList.get(i));
								}
								insertCall.execute();
								System.out.println("Created new user "+ argList.get(0));
								System.out.println();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								System.exit(11);
							}
						} else {
							System.out.println("Invalid create arguments supplied\n");
						}
						
						
					} else if (mode.equals("delete")) { // DELETE MODE
						// TODO handle delete
						if(sc.hasNext()) {
							try {
								CallableStatement deleteCall = aws.getConnection().prepareCall("{call deleteCustomer(?)}");
								deleteCall.setInt(1, sc.nextInt());
								deleteCall.execute();
								System.out.println("User Deleted\n\n");
								continue;
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InputMismatchException e) {
								System.out.println("Bad delete argument specified.\n\n");
								continue;
							}
						}
						
						
					} else if (mode.equals("help")) {
						// TODO maybe just delete this option
					} else if (mode.equals("list")) {
						
						try {
							Statement stmt = aws.getConnection().createStatement();
							ResultSet customerSet = stmt.executeQuery("SELECT * FROM CUSTOMER");
							System.out.println("\n\n");
							System.out.println("-------------------------------------------");
							while(customerSet.next()) {
								System.out.printf("Customer ID: %d%nUsername: %s Password: %s%nName: %s %s %nEmail: %s Phone: %s%n-------------------------------------------%n", customerSet.getInt(1), customerSet.getString(2), customerSet.getString(3), customerSet.getString(4), customerSet.getString(5), customerSet.getString(6), customerSet.getString(7));
							}
							System.out.println("\n\n");				
							
						} catch (SQLException e) {
							e.printStackTrace();
							System.exit(1);
						}
						
						
					} else if (mode.equals("logout")) {
						// handle logout
						System.out.println("Logging out...\n\n");
						sc.close();
						return;
					} else if (mode.equals("update")) { // UPDATE MODE
						ArrayList<String> argList = new ArrayList<String>();
						while(sc.hasNext()) {
							argList.add(sc.next());
						}
						
						if(argList.size() == 5) { // we are ready to construct the call
							try {
								CallableStatement updateCall = aws.getConnection().prepareCall("{call updateCustomerInfo(?, ?, ?, ?, ?)}");
								for (int i = 0; i < 5 ; i++) {
									updateCall.setString(i+1, argList.get(i));
								}
								updateCall.execute();
								System.out.println("Updated user "+ argList.get(0));
								System.out.println();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								System.exit(1);
							}
						} else {
							System.out.println("Invalid update arguments supplied\n");
						}
						
					} else {
						// handle help
						continue;
					}
				}
			} while(true); // do forever
		} 
	}
	
	public static void customerConsole(String[] loginInfo) {
		AwsConnection aws = AwsConnection.getInstance();
		Scanner customerIn = new Scanner(System.in);
		
		Statement stmt;
		ResultSet customerSet = null;
		ResultSet accountsSet;
		
		try {
			stmt = aws.getConnection().createStatement();
			customerSet = stmt.executeQuery("SELECT CUSTOMERID FROM CUSTOMER WHERE USERNAME='"+loginInfo[0]+"'");
			//accountsSet = stmt.executeQuery("SELECT * FROM MONEY_ACCOUNTS WHERE OWNERID="+customerSet.getString("CUSTOMERID"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String customerID = null;
		if (customerSet != null) {
			try {
				if (customerSet.next()) {
					customerID = customerSet.getString(1);
				} else {
					System.out.println("The database has refused our connection and the application must quit.");
					System.exit(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("The database has refused our connection and the application must quit.");
			System.exit(1);
		}
		
		String inputLine;
		while(true) {
			do {
				
			// print menu
				System.out.println("Welcome to the Customer Accounts Console!\n");
				System.out.println("Command List:");
				System.out.println("create <startingBalance>\n -- Create a new ");
				System.out.println("delete <AccountID> \n -- Deletes the account specified by <AccountID>");
				System.out.println("deposit <AccountID> <dollarAmount>\n -- Deposits the <dollarAmount> <AccountID>");
				System.out.println("list \n -- List all the accounts you own.");
				System.out.println("logout \n -- End the session and go back to the login screen.");
				System.out.println("withdraw <AccountID> <dollarAmount> \n -- Withdraw the dollarAmount for the specified account.");
				
				inputLine = customerIn.nextLine();
				Scanner sc = new Scanner(inputLine);
				if (sc.hasNext()) {
					String mode = sc.next();
					
					if (mode.equals("create")) {
						ArrayList<String> argList = new ArrayList<String>();
						while(sc.hasNext()) {
							argList.add(sc.next());
						}
						
						try {
							CallableStatement createCall = aws.getConnection().prepareCall("{call insertNewMoneyAccount(?, ?)}");
							for (int i = 0; i < 2 ; i++) {
								//createCall.setString(i+1, argList.get(i));
							}
							createCall.setString(1, customerID);
							createCall.setString(2, argList.get(0));
							createCall.execute();
							System.out.println("Created a new account for you.");
							System.out.println();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.exit(1);
						}
					} else if (mode.equals("delete")) {
						if(sc.hasNext()) {
							try {
								CallableStatement deleteCall = aws.getConnection().prepareCall("{call deleteMoneyAccount(?)}");
								deleteCall.setInt(1, sc.nextInt());
								deleteCall.execute();
								System.out.println("Account Deleted\n\n");
								continue;
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InputMismatchException e) {
								System.out.println("Bad delete argument specified.\n\n");
								continue;
							}
						}
					} else if (mode.equals("deposit")) {
						ArrayList<String> argList = new ArrayList<String>();
						while(sc.hasNext()) {
							argList.add(sc.next());
						}
						
						if(argList.size() == 2) { // we are ready to construct the call
							try {
								CallableStatement updateCall = aws.getConnection().prepareCall("{call deposit(?, ?)}");
								for (int i = 0; i < 2 ; i++) {
									updateCall.setInt(i+1, Integer.valueOf(argList.get(i)));
								}
								updateCall.execute();
								System.out.println("Deposited $"+ argList.get(1));
								System.out.println();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								System.exit(1);
							}
						} else {
							System.out.println("Invalid deposit arguments supplied\n");
						}
					} else if (mode.equals("list")) {
						try {
							Statement listStatement = aws.getConnection().createStatement();
							ResultSet customerAccounts = listStatement.executeQuery("SELECT ACCOUNTID, BALANCE, FIRSTNAME, LASTNAME FROM MONEY_ACCOUNT INNER JOIN CUSTOMER ON CUSTOMER.CUSTOMERID=MONEY_ACCOUNT.OWNERID WHERE USERNAME='"+loginInfo[0]+"'");
							System.out.println("\n\n");
							System.out.println("-------------------------------------------");
							while(customerAccounts.next()) {
								int accountID = customerAccounts.getInt(1);
								double accountBalance = customerAccounts.getDouble(2);
								String firstName = customerAccounts.getString(3);
								String lastName = customerAccounts.getString(4);
								System.out.printf("Account ID: %d%nAccountBalance: $%,.2f%nOwner Name: %s %s%n-------------------------------------------%n", accountID, accountBalance, firstName, lastName);
							}
							System.out.println("\n\n");				
							
						} catch (SQLException e) {
							e.printStackTrace();
							System.exit(1);
						}
						
					} else if (mode.equals("logout")) {
						System.out.println("Logging out...\n\n");
						sc.close();
						return;
					} else if (mode.equals("withdraw")) {
						ArrayList<String> argList = new ArrayList<String>();
						while(sc.hasNext()) {
							argList.add(sc.next());
						}
						
						if(argList.size() == 2) { // we are ready to construct the call
							try {
								CallableStatement updateCall = aws.getConnection().prepareCall("{call withdraw(?, ?)}");
								for (int i = 0; i < 2 ; i++) {
									updateCall.setInt(i+1, Integer.valueOf(argList.get(i)));
								}
								updateCall.execute();
								System.out.println("Withdrew $"+ argList.get(1));
								System.out.println();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								System.exit(1);
							}
						} else {
							System.out.println("Invalid withdraw arguments supplied\n");
						}
					} else {
						continue;
					}
				}
				
				
				
				
			// prompt for input
			} while(true); // do while user has not entered good input
			
			
		}
	}
	
	public static void main(String[] args) {
		//String[] loginInfo = new String[2]; // {Username, Password}
		
		
		
		//SAwsConnection aws = AwsConnection.getInstance();
		/*
		 * try { CallableStatement myCall =
		 * aws.getConnection().prepareCall("{call insertNewCustomer(?, ?, ?, ?, ?, ?)}"
		 * ); myCall.setString (1, "newUser1"); myCall.setString (2, "password");
		 * myCall.setString (3, "supercoolfirsname"); myCall.setString (4,
		 * "evenCoolerLastName"); myCall.setString (5, "collguy@gmail.com");
		 * myCall.setString (6, "(315) 555-4987"); //CallableStatement testCall =
		 * aws.getConnection().
		 * prepareCall("{call insertNewCustomer('cooluser3', 'coolpass', 'firstcoolname', 'lastcoolname', 'supercoolguy@gmail.com', '(315)876-3473')}"
		 * ); myCall.execute(); System.out.println("end test"); } catch (SQLException e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 */		
		BankApp.run();
		



	}

}
