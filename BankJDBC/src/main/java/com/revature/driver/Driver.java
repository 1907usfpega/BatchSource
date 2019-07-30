package com.revature.driver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.daoimpl.BankingDaoImpl;

public class Driver {

	static Scanner scan;
	static BankingDaoImpl bdi;

	static final int NEW_ACCT = 1;
	static final int LOGIN = 2;
	static final int LOGIN_AS_ADMIN = 3;
	// static final int NEW_ADMIN = 4;

	public static void main(String[] args) {
		bdi = new BankingDaoImpl();
		try {
			scan = new Scanner(System.in);
			System.out.println("Welcome to Phoenix Banking.");
			bankMenu();
			System.out.println("Thank you for banking with Phoenix.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end main

	private static void bankMenu() throws SQLException {
		boolean quit = false;
		while (!quit) {
			System.out.println("Main Menu:\n");
			System.out.println(NEW_ACCT + ".\t Register as a new User");
			System.out.println(LOGIN + ".\t Login");
			// System.out.println(NEW_ADMIN + ".\t Register as a new Admin");
			System.out.println(LOGIN_AS_ADMIN + ".\t Login as Admin");
			System.out.println("\nQ.\t Quit the Application");

			String input = scan.nextLine();
			int ch;
			if (input.toUpperCase().equals("Q")) {
				quit = true;
			} else {
				try {
					ch = Integer.parseInt(input);
					switch (ch) {
					case LOGIN:
						login();
						break;
					case NEW_ACCT:
						registerAsUser();
						break;
					/*
					 * case NEW_ADMIN: registerAsAdmin(); break;
					 */
					case LOGIN_AS_ADMIN:
						loginAdmin();
						break;
					default:
						System.out.println("Invalid Input");
					}
				} catch (NumberFormatException e) {
					System.out.println("Please enter a number.");
					continue;
				} // catch
			} // end else (not q)
		} // end while not quit;

	}// end bankMenu

	private static void loginAdmin() throws SQLException {
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("database.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Admin Username:");
		String username = scan.nextLine();
		System.out.println("Admin Password: ");
		String password = scan.nextLine();
		if(username.equalsIgnoreCase(prop.getProperty("admin"))&&password.equals(prop.getProperty("adpass")) )
		{
			runAdmin();
		}else {
			System.out.println("Incorrect username or password");
		}
	}

	private static final int VIEW_USERS = 1;
	private static final int CREATE_USER = 2;

// An Admin can view, create, update, and delete all users.
	private static void runAdmin() throws SQLException {
		boolean quit = false;
		String choice;
		int ch;
		do {
			System.out.println("Admin menu: ");
			System.out.println(VIEW_USERS + ".\t View All Users");
			System.out.println(CREATE_USER + ".\t Register New User");
			System.out.println("Q.\t Log out and Return to Main Menu");

			choice = scan.nextLine();
			if (choice.toUpperCase().equals("Q")) {
				quit = true;
			} else {
				try {
					ch = Integer.parseInt(choice);
					switch (ch) {
					case VIEW_USERS:
						viewUsers();
						break;
					case CREATE_USER:
						registerAsUser();
						break;
					default:
						System.out.println("That is not a valid choice.");
					}// end switch
				} catch (NumberFormatException e) {
					System.out.println("Please enter a number.");
				} // end catch
			} // end else
		} while (!quit);
	}// end runAdmin

	private static final int UPDATE_USER = 1;
	private static final int DELETE_USER = 2;

	private static void viewUsers() throws SQLException {
		boolean quit = false;
		do {
			System.out.println("All Customers of Phoenix Banking:");
			List<Customer> custList = bdi.getCustomerList();
			printList(custList, true);
			String input;
			int index;

			System.out.println("\nSelect a customer to update or delete, or enter Q to return to Admin Menu.");
			input = scan.nextLine();
			if (input.toUpperCase().equals("Q")) {
				quit = true;
			} else {
				try {
					index = Integer.parseInt(input);
					Customer c = custList.get(index);
					boolean exit = false;
					do {
						System.out.println(c);
						System.out.println("\nOptions:");
						System.out.println(UPDATE_USER + ".\t Update User Information");
						System.out.println(DELETE_USER + ".\t Delete User");
						System.out.println("Q.\t Quit");

						input = scan.nextLine();
						if (input.toUpperCase().equals("Q")) {
							exit = true;
						} else {
							try {
								switch (Integer.parseInt(input)) {
								case UPDATE_USER:
									exit = true;
									viewPersonalInfo(c);
									break;
								case DELETE_USER:
									exit = true;
									deleteUser(c);
									break;
								default:
									System.out.println("That is not a valid choice.");
								}// end switch
							} catch (NumberFormatException e) {
								System.out.println("Please enter a number or Q.");
							} // end catch
						} // end else
					} while (!exit);
				} catch (NumberFormatException e) {
					System.out.println("Please enter a number or Q");
				} // end catch
			} // end else(not q)
		} while (!quit);
	}

	private static void deleteUser(Customer c) throws SQLException {

		boolean delete = false;
		boolean invalidInput = true;
		String input;

		List<Account> accList = bdi.getAccountListPersonal(c);
		do {
			System.out.println("Are you sure you want to delete " + c.getUsername() + "?");
			if (!accList.isEmpty()) {
				boolean multipleAccs = accList.size() > 1;
				System.out.println(
						"They currently have " + (multipleAccs ? (accList.size() + " bank accounts") : "a bank account")
								+ " with us, and if you delete their user account, " + "they WILL lose access to "
								+ (multipleAccs ? "them" : "it") + ", and we'll have to do cleanup later.");
			}
			System.out.println("(y/n)");
			input = scan.nextLine().toUpperCase();
			switch (input) {
			case "Y":
			case "YES":
				invalidInput = false;
				delete = true;
				break;
			case "N":
			case "NO":
				invalidInput = false;
				delete = false;
				break;
			}// end switch
		} while (invalidInput);
		if (delete) {
			bdi.removeUser(c);
			System.out.println(c.getUsername() + " has been deleted.");
			// TODO delete accounts which now have no user.
			// (they're gone from the breakup table, but they still exist.)
			// (This issue is partly because the database supports joint accounts, but the
			// java doesn't yet)

		} // end if(delete)
	}

	private static void login() throws SQLException {
		boolean quit = false;
		List<Customer> customerList = bdi.getCustomerList();
		do {
			System.out.println("Username: ");
			String username = scan.nextLine();
			if (username.toUpperCase().equals("Q")) {
				quit = true;
			} else {
				System.out.println("Password: ");
				String password = scan.nextLine();
				Iterator<Customer> itr = customerList.iterator();
				boolean found = false;
				while (itr.hasNext() && !found) {
					Customer c = itr.next();
					if (c.getUsername().equalsIgnoreCase(username) && c.checkPassword(password)) {
						found = true;
						quit = true;
						System.out.println("Logging in... \n");
						run(c);
					}
				} // end while (itr.hasNext() && !found)
				if (!found) {
					System.out.println("Username or password incorrect.");
					System.out.println("Try again or enter Q to return to the main menu.\n");
				}
			} // end else username not q
		} while (!quit);
	}// end login

	private static void registerAsUser() throws SQLException {
		boolean quit = false;
		List<Customer> customerList = bdi.getCustomerList();
		do {
			System.out.println("Username: ");
			String username = scan.nextLine();
			if (username.toUpperCase().equals("Q")) {
				quit = true;
			} else {
				Iterator<Customer> itr = customerList.iterator();
				boolean found = false;
				while (itr.hasNext() && !found) {
					Customer c = itr.next();
					if (c.getUsername().equalsIgnoreCase(username)) {
						found = true;
						System.out.println("That username is already taken.");
						System.out.println("Try again or enter Q to quit.");
					} // end if
				} // end while (itr.hasNext() && !found)
				if (!found) {
					// Username not taken
					System.out.println("Create Password: ");
					String password = scan.nextLine();
					System.out.println("First Name: ");
					String firstName = scan.nextLine();
					System.out.println("Last Name: ");
					String lastName = scan.nextLine();

					bdi.createCustomer(username, password, firstName, lastName);
					System.out.println("You have been registered. ");
					quit = true;
				} // end username not taken
			} // end else username not q
		} while (!quit);
	}// end registerAsUser

	private static final int PERSONAL_INFO = 1;
	private static final int VIEW_ACCOUNTS = 2;
	private static final int NEW_ACCOUNT = 3;
	private static final int DEL_SELF = 4;

	private static void run(Customer c) throws SQLException {
		System.out.println("Welcome, " + c.getFirstName() + " " + c.getLastName() + "!");
		boolean deleted = false;
		boolean quit = false;
		String choice;
		int ch;
		do {
			System.out.println("\n User Menu:");
			System.out.println(PERSONAL_INFO + ".\t View Your Personal Info");
			System.out.println(VIEW_ACCOUNTS + ".\t View Your Bank Accounts");
			System.out.println(NEW_ACCOUNT + ".\t Create a New Bank Account");
			System.out.println(DEL_SELF + ".\t Delete your User Account");

			System.out.println("\nQ.\t Log Out and Return to Main Menu");

			choice = scan.nextLine();
			if (choice.toUpperCase().equals("Q")) {
				quit = true;
			} else {
				try {
					ch = Integer.parseInt(choice);
					switch (ch) {
					case NEW_ACCOUNT:
						createNewAccount(c);
						break;
					case PERSONAL_INFO:
						viewPersonalInfo(c);
						break;
					case VIEW_ACCOUNTS:
						viewAccounts(c);
						break;
					case DEL_SELF:
						deleted = deleteSelf(c);
						break;
					default:
						System.out.println("That is not a valid number.");
					}// end switch
				} catch (NumberFormatException e) {
					System.out.println("Please enter a number or Q.");
					continue;
				} // catch
			} // end else
		} while (!quit && !deleted);
		System.out.println("You have" + (deleted ? " permanently" : "") + " logged out of " + c.getUsername());

	}// end run(Customer c)

	static final int CHECKING = 1;
	static final int SAVINGS = 2;
	static final int TRUST = 3;

	private static void createNewAccount(Customer c) throws SQLException {
		boolean choosing = true;
		boolean cancel = false;
		String type = "unspecified";
		String accountName;
		do {
			System.out.println(CHECKING + ".\t Create a new checking account");
			System.out.println(SAVINGS + ".\t Create a new savings account");
			System.out.println(TRUST + ".\t Create a new trust account");
			System.out.println("Q.\t Cancel");
			String s = scan.nextLine();
			if (s.toUpperCase().equals("Q")) {
				choosing = false;
				cancel = true;
			} else {
				try {
					int choice = Integer.parseInt(s);
					switch (choice) {
					case CHECKING:
						type = "Checking";
						choosing = false;
						break;
					case SAVINGS:
						type = "Savings";
						choosing = false;
						break;
					case TRUST:
						type = "Trust";
						choosing = false;
						break;
					default:
						System.out.println("That is not a valid choice.");
					}

				} catch (NumberFormatException e) {
					System.out.println("Please enter a number or Q.");
				} // end catch
			} // end else

		} while (choosing);
		if (!cancel) {
			System.out.println("Please enter a Name for your new " + type + " account");
			accountName = scan.nextLine();

			// TODO add joint account functionality. The database will support it, but I
			// don't yet know how to make a stored procedure to add them.
			/*
			 * String input; boolean invalidInput = true; boolean joint = false; do {
			 * System.out.println("Do you want to make this a joint account?\n(y/n)"); input
			 * = scan.nextLine(); switch (input.toUpperCase()) { case "Y": case "YES":
			 * invalidInput = false; joint = true; break; case "N": case "NO": invalidInput
			 * = false; joint = false; break; }// end switch } while (invalidInput);
			 * 
			 * ArrayList<String> owners = new ArrayList<String>();
			 * owners.add(c.getUsername());
			 * 
			 * if (joint) { boolean done = false; do {
			 * System.out.println("Enter username to add to this account or Q to finish.");
			 * String user = scan.nextLine(); if (user.toUpperCase().equals("Q")) { done =
			 * true; } else if (userExists(user)) { System.out.println("User accepted.");
			 * owners.add(user); } else {
			 * System.out.println("That user is not in our system."); } // end else } while
			 * (!done); } // end if
			 */
			bdi.createAccount(accountName, type, c.getCustomerID());
			System.out.println("Your " + type + " account \"" + accountName + "\" has been created.");
		} // end if(!cancel)
	}

	private static final int CHANGE_NAME = 1;
	private static final int CHANGE_USERNAME = 2;
	private static final int CHANGE_PASSWORD = 3;

	private static void viewPersonalInfo(Customer c) throws SQLException {
		String input;
		boolean quit = false;
		do {
			System.out.println();
			System.out.println("Username: " + c.getUsername());
			System.out.println("Full Name: " + c.getFirstName() + " " + c.getLastName());

			System.out.println("\nOptions:");
			System.out.println(CHANGE_NAME + ".\t Change Name");
			System.out.println(CHANGE_USERNAME + ".\t Change Username");
			System.out.println(CHANGE_PASSWORD + ".\t Change Password");
			System.out.println("Q.\t Return to User Menu");
			input = scan.nextLine();
			if (input.toUpperCase().equals("Q")) {
				quit = true;
			} else {
				try {
					switch (Integer.parseInt(input)) {
					case CHANGE_NAME:
						System.out.println("Current Name: " + c.getFirstName() + " " + c.getLastName());
						System.out.println("New First Name: ");
						String fname = scan.nextLine();
						System.out.println("New Last Name: ");
						String lname = scan.nextLine();

						bdi.changeName(c, fname, lname);
						c.setFirstName(fname);
						c.setLastName(lname);
						System.out.println("Name updated.");
						break;
					case CHANGE_USERNAME:
						boolean working = true;
						System.out.println("Current Username: " + c.getUsername());
						do {
							System.out.println("New Username: ");
							String username = scan.nextLine();
							if (username.toUpperCase().equals("Q")) {
								working = false;
							} else if (userExists(username)) {
								System.out.println("Sorry, \"" + username + "\" is taken.");
							} else {
								working = false;
								bdi.changeUsername(c, username);
								c.setUsername(username);
								System.out.println("Username updated.");
							}
						} while (working);
						break;
					case CHANGE_PASSWORD:
						System.out.println("New Password: ");
						String password = scan.nextLine();
						System.out.println("Confirm change with old password: ");
						String oldPass = scan.nextLine();
						if (c.checkPassword(oldPass)) {
							bdi.changePassword(c, password);
							c.setPassword(password);
							System.out.println("Password Changed.");
						} else {
							System.out.println("Sorry, that is incorrect.");
						}
						break;
					}// end switch
				} catch (NumberFormatException e) {
					System.out.println("Please enter a number or Q.");
				}
			}

		} while (!quit);
	}// end viewPersonalInformation

	private static void viewAccounts(Customer c) throws SQLException {
		System.out.println("Accounts belonging to " + c.getUsername() + ":");
		List<Account> accList = bdi.getAccountListPersonal(c);
		if (accList.isEmpty()) {
			System.out.println("You have no accounts.");
		} else {
			printList(accList, true);
		}

		boolean quit = false;
		String input;
		int index;
		while (!quit && !accList.isEmpty()) {
			System.out.println("\nSelect account to log into, or enter Q to return to user menu");
			input = scan.nextLine();
			if (input.toUpperCase().equals("Q")) {
				quit = true;
			} else {
				try {
					index = Integer.parseInt(input);
					Account a = accList.get(index);
					run(a);
					quit = true;
				} catch (NumberFormatException e) {
					System.out.println("Please enter a number or Q");
				} // end catch
			} // end else(not q)
			System.out.println();
		} // end while(!quit)
	}

	static final int WITHDRAW = 1;
	static final int DEPOSIT = 2;
	static final int TRANSFER = 3;
	static final int BALANCE = 4;
	static final int DELETE_ACCOUNT = 5;

	private static void run(Account a) throws SQLException {
		boolean deleted = false;
		System.out.println("Opening account " + a);
		String choice;
		int ch;
		boolean quit = false;
		do {
			System.out.println("\nAccount Menu:");
			System.out.println(WITHDRAW + ".\t Withdraw Money");
			System.out.println(DEPOSIT + ".\t Deposit Money");
			System.out.println(TRANSFER + ".\t Transfer Money");
			System.out.println(BALANCE + ".\t View Balance");
			System.out.println(DELETE_ACCOUNT + ".\t Delete account");
			System.out.println("Q.\t Log Out and Return to User Menu");

			choice = scan.nextLine();
			if (choice.toUpperCase().equals("Q")) {
				quit = true;
			} else {
				try {
					ch = Integer.parseInt(choice);
					switch (ch) {
					case WITHDRAW:
						withdrawMoney(a);
						break;
					case DEPOSIT:
						depositMoney(a);
						break;
					case TRANSFER:
						transferMoney(a);
						break;
					case DELETE_ACCOUNT:
						deleted = deleteAccount(a);
						break;
					case BALANCE:
						viewBalance(a);
						break;
					default:
						System.out.println("That is not a valid choice.");
					}// end switch
				} catch (NumberFormatException e) {
					System.out.println("Please enter a number.");
				} // end catch
			} // end else
		} while (!quit && !deleted);
		System.out.println(
				"You have " + (deleted ? "permanently " : "") + "logged out of account \"" + a.getAccountName() + "\"");
	}// end run(Account a)

	private static void withdrawMoney(Account a) throws SQLException {
		boolean quit = false;
		if (a.getBalance() > 0) {
			viewBalance(a);
			System.out.println("How much money do you want to withdraw?");
			quit = false;
			String input;
			do {
				input = scan.nextLine();
				if (input.toUpperCase().equals("Q")) {
					quit = true;
				} else {
					try {
						int amount = Integer.parseInt(input);

						if (amount < 0) {
							System.out.println("Invalid amount.");
						} else if (amount > a.getBalance()) {
							System.out.println("Error: cannot withdraw more than the current balance");
						} else {
							bdi.withdraw(a, amount);
							System.out.println("Withdrawn $" + amount + " from " + a.getAccountName());
							updateBalance(a);
							viewBalance(a);
						} // end else
						quit = true;
					} catch (NumberFormatException e) {
						System.out.println("Please enter an integer or enter Q to exit.");
					}
				} // end else
			} while (!quit);
		} // end if you have money in your account
		else {
			System.out.println("There is no money to be withdrawn.");
			quit = true;
		}
	}

	private static void depositMoney(Account a) throws SQLException {
		boolean quit = false;
		System.out.println("How much money do you want to deposit?");
		quit = false;
		String input;
		do {
			input = scan.nextLine();
			if (input.toUpperCase().equals("Q")) {
				quit = true;
			} else {
				try {
					int amount = Integer.parseInt(input);

					if (amount < 0) {
						System.out.println("Invalid amount.");
					} else {
						bdi.deposit(a, amount);
						System.out.println("Depoited $" + amount + " to " + a.getAccountName());
						updateBalance(a);
						viewBalance(a);
					} // end else
					quit = true;
				} catch (NumberFormatException e) {
					System.out.println("Please enter an integer or enter Q to exit.");
				}
			} // end else
		} while (!quit);
	}

	private static void transferMoney(Account a) {

		System.out.println("\nWelcome to the method stub to transfer money! You can't do anything yet.");
		// TODO Auto-generated method stub
	}

	private static boolean deleteAccount(Account a) throws SQLException {
		boolean deleted = false;
		if (a.getBalance() > 0) {
			System.out.println("Account \"" + a.getAccountName() + "\" has a balance of $" + a.getBalance() + ".");
			System.out.println("It is against bank regulations to delete an account with a positive balance.");
			System.out.println("Please withdraw your money first.");
		} else {
			boolean delete = false;
			boolean invalidInput = true;
			String input;
			do {
				System.out.println("\nAre you sure you want to delete your account? \n(y/n)");
				input = scan.nextLine().toUpperCase();
				switch (input) {
				case "Y":
				case "YES":
					invalidInput = false;
					delete = true;
					break;
				case "N":
				case "NO":
					invalidInput = false;
					delete = false;
					break;
				}// end switch
			} while (invalidInput);
			if (delete) {
				bdi.removeAccount(a);
				deleted = true;
				System.out.println(a.getAccountName() + " has been deleted.");
			} // end if(delete)
		} // end else there isn't money in the account
		return deleted;
	}// end deleteAccount

	private static void updateBalance(Account a) throws SQLException {
		a.setBalance(bdi.getBalance(a));
	}

	private static void viewBalance(Account a) throws SQLException {
		System.out.println("Current Balance of " + a.getAccountName() + ": $" + a.getBalance());
	}

	private static boolean deleteSelf(Customer c) throws SQLException {
		boolean deleted = false;

		boolean delete = false;
		boolean invalidInput = true;
		String input;

		List<Account> accList = bdi.getAccountListPersonal(c);
		do {
			System.out.println("Are you sure you want to delete your user account?");
			if (!accList.isEmpty()) {
				boolean multipleAccs = accList.size() > 1;
				System.out.println(
						"You currently have " + (multipleAccs ? (accList.size() + " bank accounts") : "a bank account")
								+ " with us, and if you delete, " + "you WILL lose access to "
								+ (multipleAccs ? "them." : "it."));
			}
			System.out.println("(y/n)");
			input = scan.nextLine().toUpperCase();
			switch (input) {
			case "Y":
			case "YES":
				invalidInput = false;
				delete = true;
				break;
			case "N":
			case "NO":
				invalidInput = false;
				delete = false;
				break;
			}// end switch
		} while (invalidInput);
		if (delete) {
			bdi.removeUser(c);
			deleted = true;
			System.out.println("Your user account has been deleted.");
			// TODO delete accounts which now have no user.
			// (they're gone from the breakup table, but they still exist.)
			// (This issue is partly because the database supports joint accounts, but the
			// java doesn't yet)

		} // end if(delete)
		return deleted;
	}// end deleteSelf;

	private static void printList(List list, boolean indexed) {
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			Object o = itr.next();
			System.out.println((indexed ? (list.indexOf(o) + ".\t") : "") + o.toString());
		} // end while
	}// end printList

	private static void printList(List list) {
		printList(list, false);
	}

	private static boolean userExists(String username) throws SQLException {
		List<Customer> customerList = bdi.getCustomerList();
		Iterator<Customer> itr = customerList.iterator();
		boolean found = false;
		while (itr.hasNext() && !found) {
			Customer c = itr.next();
			if (c.getUsername().equalsIgnoreCase(username)) {
				found = true;
			} // end if
		} // end while (itr.hasNext() && !found)
		return found;
	}// end userExists

}// end Driver
