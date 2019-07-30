package com.revature.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.revature.account.Account;
import com.revature.database.Database;

public class User {
	private String username;
	private String password;
	private String fname;
	private String lname;
	private boolean loggedIn;
	private int userid;
	private int isEmployee;
	private int isAdmin;

	private boolean deleted;

	private ArrayList<Account> accts;
	Scanner scan;
	private boolean firstAccessAccts;

	public User(String username, String password, String fname, String lname, int isEmployee, int isAdmin, int userid) {
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		loggedIn = false;
		this.isEmployee = isEmployee;
		this.isAdmin = isAdmin;
		this.userid = userid;
	}

	public User(String username, String password, String fname, String lname) {
		this(username, password, fname, lname, 0, 0, 0);
	}
	
	public User(String username, String password, String fname, String lname, int isEmployee) {
		this(username, password, fname, lname, isEmployee, 0, 0);
	}

	public static User register(String username, String password, String fname, String lname, int isEmployee, int isAdmin) {
		User u = new User(username.toUpperCase(), password, fname, lname, isEmployee, isAdmin, 0);
		Database.addUser(u);
		return u;
	}// end register

	public String getUserName() {
		return this.username;
	}

	public int getIsAdmin() {
		return this.isAdmin;
	}

	public String getFirstName() {
		return this.fname;
	}
	public String getLastName() {
		return this.lname;
	}
	public String getpass() {
		return this.password;
	}
	public int getIsEmp() {
		return this.isEmployee;
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
		return "username: " + username + ", name: " + fname+" "+lname + (isEmployee==1234 ? " | EMPLOYEE" : "")
				+ (isAdmin==4321 ? " || ADMIN" : "");
	}

	public final boolean checkPassword(String attempt) {
		return attempt.equals(this.password);
	}

	public boolean equals(User u) {
		return this.username.equals(u.username);
	}

	/**
	 * 
	 * 
	 * 
	 */

	public void login() {
		if (!deleted) {
			firstAccessAccts = true;
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
		} else {
			delete();
		}
	}

	private static final int PERSONAL_INFO = 1;
	private static final int VIEW_ACCOUNTS = 2;
	private static final int NEW_ACCOUNT = 3;
	private static final int DEL_SELF = 4;
	// employee only stuff
	private static final int VIEW_ALL_USERS = 21;
	private static final int VIEW_ALL_ACCTS = 22;
	// admin only stuff
	private static final int MANIP_ACCTS = 31;
	private static final int CANCEL_ACCT = 32;
	private static final int DEL_USER = 33;
	private static final int MAKE_USER=34;
	private static final int UPDATE_USER=35;
	

	private void run() {
		if (this.isLoggedIn()) {

			System.out.println("Welcome, " + fname);
			String choice;
			int ch;
			boolean quit = false;
			do {
				System.out.println("\n User Menu:");
				System.out.println(PERSONAL_INFO + ".\t View Your Personal Info");
				System.out.println(VIEW_ACCOUNTS + ".\t View Your Bank Accounts");
				System.out.println(NEW_ACCOUNT + ".\t Request a New Bank Account");
				System.out.println(DEL_SELF + ".\t Delete your User Account");
				if (this.isEmployee==1234) {
					// list employee only methods
					System.out.println("\n Employees Only:");
					System.out.println(VIEW_ALL_USERS + ".\t View all Users");
					System.out.println(VIEW_ALL_ACCTS + ".\t View all Bank Accounts");
				} // end if(this.isEmployee)
				if (this.isAdmin==4321) {
					System.out.println("\n Admin Only:");
					System.out.println(MANIP_ACCTS + ".\t Deposit, Withdraw, or Transfer from other accounts");
					System.out.println(CANCEL_ACCT + ".\t Cancel an account");
					System.out.println(DEL_USER + ".\t Remove any User");
					System.out.println(MAKE_USER+".\t Create new User");
					System.out.println(UPDATE_USER+".\t Update any User");
				}

				System.out.println("\nQ.\t Log Out");

				choice = scan.nextLine();
				if (choice.toUpperCase().equals("Q")) {
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
					createNewAccount();
					break;
				case PERSONAL_INFO:
					viewPersonalInfo();
					break;
				case VIEW_ACCOUNTS:
					viewAccounts();
					break;
				case DEL_SELF:
					deleteSelf();
					break;
				case VIEW_ALL_USERS:
					if (isEmployee==1234) {
						Database.printUsers();
						break;
					}
				case VIEW_ALL_ACCTS:
					if (isEmployee==1234) {
						Database.printAccounts(false, true);
						break;
					}
				case MANIP_ACCTS:
					if (isAdmin==4321) {
						manipulateAccounts();
						break;
					}
				case CANCEL_ACCT:
					if (isAdmin==4321) {
						cancelAccount();
						break;
					}
				case DEL_USER:
					if (isAdmin==4321) {
						removeUser();
						break;
					}
				case MAKE_USER:
					if (isAdmin==4321) {
						makeUser();
						break;
					}
				case UPDATE_USER:
					if (isAdmin==4321) {
						viewInfo();
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
	
	private void makeUser() {
		boolean found;
		String use = null;
		int em,ad=0;
		do {
			System.out.println("Enter new username");
			use = scan.next();
			found = Database.userExists(use);
			if (found) {
				System.out.println("That UserName is taken, please use a new one");
			}
		} while (found);

		boolean match = false;
		String pass;
		do {
			System.out.println("Enter password");
			pass = scan.next();
			System.out.println("Confirm password");
			String conPass = scan.next();
			match = pass.equals(conPass);
			if (!match) {
				System.out.println("Passwords do not match.\n");
			}
		} while (!match);
		System.out.println("Enter full name:");
		scan.nextLine();
		String fname =scan.next();
		String lname = scan.next();
		scan.nextLine();
		System.out.println("Is the new user an employee\ny/n");
		String a=scan.nextLine();
		if (a.toUpperCase().equals("Y")){
			em=1234;
			System.out.println("Is the new user an Admin\ny/n");
			a=scan.nextLine();
			if (a.toUpperCase().equals("Y")){
				ad=4321;
			}
			else {
				ad=0;
			}
		}
		else em=0;
		
		User.register(use, pass, fname, lname, em, ad);
		System.out.println(use +" has been registered.");
	}

	private void deleteSelf() {
		System.out.println(
				"If you delete, you will lose access to ALL your Bank Accounts, AND you will no longer be registered at this bank.");
		String input;
		boolean invalidInput = true;
		boolean delete = false;
		do {
			System.out.println("Are you sure that you want to delete your user account?\n(y/n)");
			input = scan.nextLine();
			switch (input.toUpperCase()) {
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
			System.out.println("Enter your password to confirm user account deletion.");
			System.out.println("PLEASE NOTE: this is PERMANENT");
			String pass = scan.nextLine();
			if (checkPassword(pass)) {
				this.delete();
			} else {
				System.out.println("Incorrect password.");
			}
		} else {
			System.out.println("Alright, you live today.");
		}
	}//end delete self

	private void delete() {
		Database.removeUser(this);
		System.out.println("User account "+username+" has been deleted.");
		deleted = true;
		loggedIn = false;
		Iterator<Account> itr = Database.aList.iterator();
		while (itr.hasNext()) {
			Account a = itr.next();
			if (a.isOwner(username)) {
				a.removeOwner(username);
			} // end if
		} // end while
		
	}
	private void delete(User u) {
		if(u.getIsAdmin()==4321) {
			this.delete();
		}else {
			System.out.println("Invalid Authorization. \n(How did you even get in here? This is an admin-only space.)");			
		}
	}

	private void removeUser() {
		if (this.isAdmin==4321) {
			boolean quit = false;
			while (!quit) {
				Database.printUsers(true);
				System.out.println("Select User to remove.");
				String input = scan.nextLine();
				int index;
				if (input.toUpperCase().equals("Q")) {
					quit = true;
				} else {
					try {
						index = Integer.parseInt(input);
						if (index > Database.pList.size() - 1 || index < 0) {
							System.out.println("That is not a valid index.");
						} else {
							User u = Database.pList.get(index);
							System.out.println("Enter password to confirm deletion of " + u);
							String pass = scan.nextLine();
							quit = true;
							if (checkPassword(pass)) {
								u.delete(this);
							}else {
								System.out.println("Incorrect password.");
							}
						} // end else
					} catch (NumberFormatException e) {
						System.out.println("Please use the index reference.");
					} // end catch
				} // end else not Q
			}
		} else {
			System.out.println("Invalid Authorization. \n(How did you even get in here? This is an admin-only space.)");
		}
	}

	private void cancelAccount() {
		if (isAdmin==4321) {
			String input;
			int index;
			boolean quit = false;
			while (!quit && !Database.aList.isEmpty()) {
				Database.printAccounts(true);
				System.out.println("Which account do you want to cancel?");
				input = scan.nextLine();
				if (input.toUpperCase().equals("Q")) {
					quit = true;
				} else {
					try {
						index = Integer.parseInt(input);
						if (index > Database.aList.size() - 1 || index < 0) {
							System.out.println("That is not a valid index.");
						
						}
						else {
							Account account = Database.aList.get(index);
							if(account.getBalance()>0) {
								System.out.println("Unable to Cancel accounts with a balance Greater than 0\nPlease empty the account prior to cancelation");
								return;
							}
							System.out.println("Enter password to confirm deletion of " + account);
							String pass = scan.nextLine();
							if (checkPassword(pass)) {
								account.delete();
							}
						} // end else
					} catch (NumberFormatException e) {
						System.out.println("Please use the index reference.");
					} // end catch
				} // end else (not q)
			} // end while
		} else {
			System.out.println("Invalid Authorization (how did you even get in here?)");
		}
	}// end cancelAccount

	private static final int WITHDRAW = 1;
	private static final int DEPOSIT = 2;
	private static final int TRANSFER = 3;

	private void manipulateAccounts() {
		if (isAdmin==4321) {
			boolean quit = false;
			String input;
			int index = 0;

			while (!quit && !Database.aList.isEmpty()) {
				Database.printAccounts(true, true);
				System.out.println("\nEnter the number of an account or enter Q to exit");
				input = scan.nextLine();
				if (input.toUpperCase().equals("Q")) {
					quit = true;
				} else {
					try {
						index = Integer.parseInt(input);
						if (index > Database.aList.size() - 1 || index < 0) {
							System.out.println("That is not a valid index.");
						} else {
							Account a = Database.aList.get(index);
							boolean exit = false;
							int choice = 0;
							while (!exit) {
								System.out.println(a + "\n");
								System.out.println(WITHDRAW + ".\t Withdraw");
								System.out.println(DEPOSIT + ".\t Deposit");
								System.out.println(TRANSFER + ".\t Transfer");
								System.out.println("Q.\t Go Back");
								input = scan.nextLine().toUpperCase();
								if (input.equals("Q")) {
									exit = true;
								} else {
									try {
										choice = Integer.parseInt(input);
									} catch (NumberFormatException e) {
										System.out.println("Please enter a number or Q");
									} // end catch
									switch (choice) {
									case WITHDRAW:
										a.withdrawAsAdmin(this);
										exit = true;
										break;
									case DEPOSIT:
										a.depositAsAdmin(this);
										exit = true;
										break;
									case TRANSFER:
										a.transferAsAdmin(this);
										exit = true;
										break;
									default:
										System.out.println("Invalid option.");
									}// end switch
								} // end else input != Q
							} // end while(!goback)
						} // end else (valid index)
					} catch (NumberFormatException e) {
						System.out.println("You must enter either an integer or Q");
					} // end catch
				} // end else (input != Q)
			} // end while (!quit && !Database.rList.isEmpty());
			if (Database.aList.isEmpty()) {
				System.out.println("\nThere are no accounts.");
			} // end if
		} else {
			System.out.println("Invalid Authorization (how did you even get in here?)");
		}
	}// end manipulate accounts

	
	static final int CHECKING = 1;
	static final int SAVINGS = 2;
	static final int TRUST = 3;

	private void createNewAccount() {
		boolean quit = false;
		boolean cancel = false;
		String type = "";
		String accountName;
		do {
			System.out.println(CHECKING + ".\t Create a new checking account");
			System.out.println(SAVINGS + ".\t Create a new savings account");
			System.out.println(TRUST + ".\t Create a new trust account");
			System.out.println("Q.\t Cancel");
			String s = scan.nextLine();
			if (s.toUpperCase().equals("Q")) {
				quit = true;
				cancel = true;
			} else {
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
					System.out.println("Please enter a number or Q.");
				} // end catch
			} // end else

		} while (!quit);
		if (!cancel) {
			System.out.println("Please enter a Name for your new " + type + " account");
			accountName = scan.nextLine();

			ArrayList<String> owners = new ArrayList<String>();
			owners.add(username);

			Account.createAccount(type, accountName, 0, username);

			Database.updateUser(this);
		} // end if(!cancel)
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
				System.out.println("Full Name: " + fname+" "+lname);
				System.out.println("\nOptions:");
				System.out.println(CHANGE_PASSWORD + ".\t Change Password");
				System.out.println(CHANGE_NAME + ".\t Change Name");
				System.out.println("Q.\t Return to main menu");

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
		if (firstAccessAccts) {
			firstAccessAccts = false;
			accts = new ArrayList<Account>();
			Iterator<Account> itr = Database.aList.iterator();
			while (itr.hasNext()) {
				Account a = itr.next();
				if (a.isOwner(username)) {
					accts.add(a);
				} // end if
			} // end while
		} // end if
		boolean quit = false;
		String input;
		int index;
		while (!quit && !accts.isEmpty()) {
			System.out.println("\n Your accounts");
			Iterator<Account> it = accts.iterator();
			while (it.hasNext()) {
				Account acc = it.next();
				System.out.println(accts.indexOf(acc) + "\t" + acc.toString(true));
			} // end while (it.hasNext())
			System.out.println("Select account to log into, or enter Q to return to main menu");
			input = scan.nextLine();
			if (input.toUpperCase().equals("Q")) {
				quit = true;
			} else {
				try {
					index = Integer.parseInt(input);
					Account a = accts.get(index);
					a.login(this);
					if (a.isDeleted()) {
						accts.remove(a);
					}
				} catch (NumberFormatException e) {
					System.out.println("Please enter a number or Q");
				}
				
			} // end else(not q)
		} // end while(!quit&&!accts.isEmpty())
		if (accts.isEmpty()) {
			System.out.println("You have no accounts.");
		}
	}// end viewAccounts

	private void changeName() {
		System.out.println("Current Name: " + fname+" "+lname);
		System.out.println("New Name: ");
		String fname = scan.next();
		String lname= scan.nextLine();
		
		System.out.println("Please confirm your identity. Password:");
		String pass = scan.nextLine();
		if (this.checkPassword(pass)) {
			this.fname = fname;
			this.lname = lname;
			System.out.println("Name has been updated to " + fname+" "+lname);
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

	public int getUserID() {
		return this.userid;
	}
	
	public void viewInfo() {
		if (this.isAdmin==4321) {
			boolean quit = false;
			while (!quit) {
				Database.printUsers(true);
				System.out.println("Select User to update.");
				String input = scan.nextLine();
				int index;
				if (input.toUpperCase().equals("Q")) {
					quit = true;
				} else {
					try {
						index = Integer.parseInt(input);
						if (index > Database.pList.size() - 1 || index < 0) {
							System.out.println("That is not a valid index.");
						} else {
							System.out.println("Enter 1 to update Name\nEnter 2 to update Password");
							User u = Database.pList.get(index);
							System.out.println();
							String pass = scan.nextLine();
							quit = true;
							if (Integer.parseInt(pass)==1) {
								this.changeOtherName(u);
							}
							else if(Integer.parseInt(pass)==2) {
								this.changeOtherPassword(u);
							}
							else {
								System.out.println("Invalid input.");
							}
						} // end else
					} catch (NumberFormatException e) {
						System.out.println("Please use the index reference.");
					} // end catch
				} // end else not Q
			}
		} else {
			System.out.println("Invalid Authorization. \n(How did you even get in here? This is an admin-only space.)");
		}
	}
	private void changeOtherName(User a) {
		System.out.println("Current Name: " + a.getFirstName()+" "+a.getLastName());
		System.out.println("New Name: ");
		String fname = scan.next();
		String lname= scan.nextLine();
		if (this.getIsAdmin()==4321) {
			a.fname = fname;
			a.lname = lname;
			System.out.println("Name has been updated to " + fname+" "+lname);
			Database.updateUser(a);
		} else {
			System.out.println("You dont have the neccessary permisions");
		}

	}// end changeName

	private void changeOtherPassword(User a) {
		if (this.getIsAdmin()==4321) {
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
					a.password = newPass;
					System.out.println("Your password has been successfully updated.");
					Database.updateUser(a);
				} else {
					System.out.println("Incorrect.");
				} // end else
			} // end if
				// } // end while
		} // end if
	}// end changePassword

}// end User