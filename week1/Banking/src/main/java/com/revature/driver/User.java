package com.revature.driver;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Scanner;

import com.revature.io.Database;

public class User implements Serializable {

	private static final long serialVersionUID = -4949131007552114985L;
	private String username;
	private String password;
	private String name;
	private boolean loggedIn;
	private boolean isEmployee;
	protected boolean isAdmin;

	transient Scanner scan;

	protected User(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
		loggedIn = false;
	}

	protected User(String username, String password, String name, boolean isEmployee) {
		this(username, password, name);
		this.isEmployee = true;
	}

	public static User register(String username, String password, String name) {
		User u = new User(username.toUpperCase(), password, name);
		Database.addUser(u);
		return u;
	}// end register
	
	public static User registerAsEmployee(String username, String password, String name) {
		User u = new User(username.toUpperCase(), password, name, true);
		Database.addUser(u);
		return u;
	}// end register as employee

	public String getUserName() {
		return this.username;
	}
	public String getName() {
		return this.name;
	}
	

	public void logOut() {
		loggedIn = false;
		System.out.println("You have been logged out.");
		Database.updateUser(this);
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	@Override
	public String toString() {
		return "username: " + username + ", name: " + name + (isEmployee ? " | EMPLOYEE" : "")
				+ (isAdmin ? " || ADMIN" : "");
	}


	final boolean checkPassword(String attempt) {
		return attempt.equals(this.password);
	}

	public boolean equals(User u) {
		return this.username.equals(u.username);
	}

	/*
	 * 
	 * 
	 * 
	 */

	public void login() {
		scan = new Scanner(System.in);
		boolean in;
		String attempt;
		do {
			System.out.println("Please enter Password for " + username + " or enter 'Q' to quit");
			attempt = scan.nextLine();
			in = this.checkPassword(attempt);
		} while (!in && !attempt.toUpperCase().equals("Q"));

		if (in) {
			loggedIn = true;
			run();
		}
		// scan.close();
	}

	private static final int PERSONAL_INFO = 1;
	private static final int VIEW_ACCOUNTS = 2;
	private static final int NEW_ACCOUNT = 3;
	//employee only stuff
	private static final int VIEW_ALL_USERS = 4;
	private static final int VIEW_ALL_ACCTS = 5;
	private static final int APPROVE_DENY = 6;
	//jump to admin options
	private static final int ADMIN_FUNC = 7;

	private void run() {
		if (this.isLoggedIn()) {

			System.out.println("Welcome, " + name);
			String choice;
			int ch;
			boolean quit = false;
			do {
				System.out.println("\nMenu: ");
				System.out.println(PERSONAL_INFO + ".\t View Your Personal Info");
				System.out.println(VIEW_ACCOUNTS + ".\t View Your Accounts");
				System.out.println(NEW_ACCOUNT + ".\t Request a New Account");
				if (this.isEmployee) {
					//list employee only methods
					System.out.println("\n"+VIEW_ALL_USERS+".\t View all Users");
					System.out.println(VIEW_ALL_ACCTS+".\t View all Accounts");
					System.out.println(APPROVE_DENY+".\t Approve/Deny pending Accounts");
				}//end if(this.isEmployee)		
				if(this.isAdmin) {
					System.out.println(ADMIN_FUNC+".\t Further Admin Functions");
				}

				System.out.println("\nQ.\t Log Out");

				choice = scan.nextLine();
				if (choice.toUpperCase().equals("Q")) {
					// quit = true;
					break;
				} else {
					try {
						ch = Integer.parseInt(choice);
					} catch (NumberFormatException e) {
						System.out.println("Please enter a number.");
						continue;
					} // catch
				} // end else

				switch (ch) {
				case NEW_ACCOUNT:
					this.createNewAccount();
					break;
				case PERSONAL_INFO:
					this.viewPersonalInfo();
					break;
				case VIEW_ACCOUNTS:
					this.viewAccounts();
					break;
				case VIEW_ALL_USERS:
					if(isEmployee) {
						Database.printUsers();
						break;
					}
				case VIEW_ALL_ACCTS:
					if(isEmployee) {
						Database.printAccounts();
						break;
					}
				case APPROVE_DENY:
					if(isEmployee) {
						viewRequests();
						break;
					}
				case ADMIN_FUNC:
					if(isAdmin) {
						Admin.run(this);
						break;
					}
				default:
					System.out.println("That is not a valid number.");
				}// end switch

			} while (!quit && this.isLoggedIn());

			System.out.println("Goodbye.");
			this.logOut();
		} // end if
	}// end run

	static final int CHECKING = 1;
	static final int SAVINGS = 2;
	static final int TRUST = 3;

	private void createNewAccount() {
		//TODO apply for joint account
		System.out.println(CHECKING + ".\t Create a new checking account");
		System.out.println(SAVINGS + ".\t Create a new savings account");
		System.out.println(TRUST + ".\t Create a new trust? account");
		String type = "";
		boolean quit = false;
		do {
			String s = scan.nextLine();
			try {
				int choice = Integer.parseInt(s);
				switch (choice) {
				case CHECKING:
					type = "Checking";
					quit = true;
					break;
				case SAVINGS:
					type = "Savings";
					quit = true;
					break;
				case TRUST:
					type = "Trust";
					quit = true;
					break;
				default:
					System.out.println("That is not a valid choice.");
				}

			} catch (NumberFormatException e) {
				System.out.println("Please enter a number.");
			} // end catch
		} while (!quit);
		System.out.println("Please enter a Name for your new " + type + " account");
		
		name = scan.nextLine();
		Account.requestAccount(type, name, username);
		System.out.println("Your account request has been submitted.");

		Database.updateUser(this);
	}// end createNewAccount

	private static final int CHANGE_PASSWORD = 1;
	private static final int CHANGE_NAME = 2;

	private void viewPersonalInfo() {
		if (this.isLoggedIn()) {

			boolean quit = false;
			String choice;
			int ch;

			do {
				System.out.println("\nUsername: " + username);
				System.out.println("Full Name: " + name);
				System.out.println("\nOptions:");
				System.out.println(CHANGE_PASSWORD + ".\t Change Password");
				System.out.println(CHANGE_NAME + ".\t Change Name");
				System.out.println("Q.\t Quit");

				choice = scan.nextLine();
				if (choice.toUpperCase().equals("Q")) {
					// quit = true;
					break;
				} else {
					try {
						ch = Integer.parseInt(choice);
					} catch (NumberFormatException e) {
						System.out.println("Please enter a number.");
						continue;
					} // catch
				} // end else

				switch (ch) {
				case CHANGE_NAME:
					this.changeName();
					break;
				case CHANGE_PASSWORD:
					this.changePassword();
					break;
				default:
					System.out.println("That is not a valid number.");
				}

			} while (!quit);
		} // end if(this.isLoggedIn())
	}// end viewPersonalInfo

	private void viewAccounts() {
		Iterator<Account> itr = Database.aList.iterator();

		while (itr.hasNext()) {
			Account a = itr.next();
			if (a.isOwner(username)) {
				System.out.println(a.toString());
				break;
			}

		}
	}

	private void changeName() {
		System.out.println("Current Name: " + name);
		System.out.println("New Name: ");
		String name = scan.nextLine();
		System.out.println("Please confirm your identity. Password:");
		String pass = scan.nextLine();
		if (this.checkPassword(pass)) {
			this.name = name;
			System.out.println("Name has been updated to " + name);
			Database.updateUser(this);
		} else {
			System.out.println("Incorrect.");
		}

	}// end changeName

	private void changePassword() {
		if (this.isLoggedIn()) {
			// boolean match = false;
			// while (!match) {
			System.out.println("New Password:");
			String newPass = scan.nextLine();
			System.out.println("Confirm New Password:");
			String confirmPass = scan.nextLine();
			if (newPass.equals(confirmPass)) {
				// match = true;
				System.out.println("Old Password:");
				String pass = scan.nextLine();
				if (this.checkPassword(pass)) {
					this.password = newPass;
					System.out.println("Your password has been successfully updated.");
					Database.updateUser(this);
				} else {
					System.out.println("Incorrect.");
				} // end else
			} // end if
				// } // end while
		} // end if
	}// end changePassword
	
	public void viewAllAccounts() {
		Iterator<Account> itr = Database.aList.iterator();
		while (itr.hasNext()) {
			Account b = itr.next();
			System.out.println(b.toString());
		}
	}

	// see all users
	public void viewAllUsers() {
		Iterator<User> itr = Database.pList.iterator();
		while (itr.hasNext()) {
			User b = itr.next();
			System.out.println(b.toString());
		}
	}
	
	private static final int APPROVE = 1;
	private static final int DENY = 2;
	
	private void viewRequests() {
		// TODO Auto-generated method stub

		boolean quit = false;
		String input;
		int index = 0;
		while (!quit && !Database.rList.isEmpty()) {
			Database.printRequests(true);
			System.out.println("\nEnter the number of a pending account or enter Q to exit");
			input = scan.nextLine();
			if (input.toUpperCase().equals("Q")) {
				quit = true;
			} else {
				try {
					index = Integer.parseInt(input);
				} catch (NumberFormatException e) {
				} // end catch
				if (index > Database.rList.size() - 1 || index < 0) {
					System.out.println("That is not a valid index.");
				} else {
					Account a = Database.rList.get(index);
					boolean goback = false;
					int choice = 0;
					while (!goback) {
						System.out.println(a + "\n");
						System.out.println(APPROVE + ".\t Approve");
						System.out.println(DENY + ".\t Deny");
						System.out.println("Q.\t Return to pending requests");
						input = scan.nextLine().toUpperCase();
						if (input.equals("Q")) {
							goback = true;
						} else {
							try {
								choice = Integer.parseInt(input);
							} catch (NumberFormatException e) {
								System.out.println("Please enter a number or Q");
							} // end catch
							switch (choice) {
							case APPROVE:
								Database.addAccount(a);
							case DENY:
								Database.removeRequest(a);
								goback = true;
								System.out.println("Account " + a + (choice == APPROVE ? "approved" : "")
										+ (choice == DENY ? "denied" : "") + ".");
								break;
							default:
								System.out.println("Invalid option.");
							}// end switch
						} // end else input != Q
					} // end while(!goback)
				} // end else (valid index)
			} // end else
		} // end while (!quit && !Database.rList.isEmpty());
		if (Database.rList.isEmpty()) {
			System.out.println("\nThere are no pending requests.");
		} // end if
	}// end viewRequests

}// end User