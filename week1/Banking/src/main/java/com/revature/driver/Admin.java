package com.revature.driver;

import java.util.Iterator;
import java.util.Scanner;

import com.revature.io.Database;

public class Admin extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7667163283759222278L;

	transient static User admin;
	transient Scanner scan;

	private Admin(String username, String password, String name) {
		super(username, password, name);
		Database.addUser(this);
	}

	public static Admin register(String username, String password, String name) {
		return new Admin(username.toUpperCase(), password, name);
	}// end register

	public String getUserName() {
		return admin.getUserName();
	}

	@Override
	public String toString() {
		return "User [username=" + admin.getUserName() + ", name=" + admin.getName() + "]";
	}

	public boolean equals(User u) {
		return admin.getUserName().equals(u.getUserName());
	}

	/*
	 * 
	 * 
	 * 
	 */

	private static final int CHNG_BLNCE = 1;
	private static final int CNCL_ACCTS = 2;
	//private static final int NEW_ACCOUNT = 3;

	public static void run(User a) {
		admin = a;
		String choice;
		int ch;
		boolean quit = false;
		do {
			System.out.println("\nAdmin Menu: ");
			System.out.println(CHNG_BLNCE + ".\t Change the Balance of an Account");
			System.out.println(CNCL_ACCTS + ".\t Cancel an Account");
			// System.out.println(NEW_ACCOUNT + ".\t Request a New Account");

			System.out.println("Q\t To go back");
			choice = a.scan.nextLine();
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
			case CHNG_BLNCE:
				changeBalance();
				break;
			case CNCL_ACCTS:
				deleteAccount();
				break;
			default:
				System.out.println("That is not a valid number.");
			}// end switch

		} while (!quit);

	}
	
	private static void deleteAccount() {
		boolean quit = false;
		String input;
		int index = 0;
		while (!quit && !Database.aList.isEmpty()) {
			Database.printAccounts(true);
			System.out.println("\nEnter the number of an account or enter Q to exit");
			input = admin.scan.nextLine();
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
					Account a = Database.aList.get(index);
					Database.removeAccount(a);
				}
			}
		}
		if (Database.aList.isEmpty()) {
			System.out.println("\nThere are no accounts.");
		}
	}
	
	private static final int WITHDRAW = 1;
	private static final int DEPOSIT = 2;
	private static final int TRANSFER = 3;

	private static void changeBalance() {
		if (!admin.isAdmin) {
			System.out.println("Invalid Authority");
		}
		boolean quit = false;
		String input;
		int index = -1;
		while (!quit && !Database.aList.isEmpty()) {
			Database.printAccounts(true);
			System.out.println("\nEnter the number of an account or enter Q to exit");
			input = admin.scan.nextLine();
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
					Account a = Database.aList.get(index);
					boolean goback = false;
					int choice = 0;
					while (!goback) {
						System.out.println(a + "\n");
						System.out.println(WITHDRAW + ".\t Approve");
						System.out.println(DEPOSIT + ".\t Deny");
						System.out.println("Q.\t Return to pending requests");
						input = admin.scan.nextLine().toUpperCase();
						if (input.equals("Q")) {
							goback = true;
						} else {
							try {
								choice = Integer.parseInt(input);
							} catch (NumberFormatException e) {
								System.out.println("Please enter a number or Q");
							} // end catch
							switch (choice) {
							case WITHDRAW:
								withdrawFromAnyAccount(a);
								break;
							case DEPOSIT:
								depositToAnyAccount(a);
								goback = true;
								break;
							case TRANSFER:
								transferBetweenTwoAccounts(a);
								break;
							default:
								System.out.println("Invalid option.");
							}// end switch
						} // end else input != Q
					} // end while(!goback)
				} // end else (valid index)
			} // end else
		} // end while (!quit && !Database.rList.isEmpty());
		if (Database.aList.isEmpty()) {
			System.out.println("\nThere are no accounts.");
		} // end if
	}// end viewRequests

	private static void withdrawFromAnyAccount(Account a) {
		a.withdrawFrom(a);
	}

	private static void depositToAnyAccount(Account a) {
		a.depositTo(a);
	}

	private static void transferBetweenTwoAccounts(Account a) {
		Iterator<Account> itr = Database.aList.iterator();
		while (itr.hasNext()) {
			Account b = itr.next();
			System.out.println(b.toString());
		}
		System.out.println("Enter an account to transfer to:");
		String s = admin.scan.nextLine();

		a.transferBetween(a, s);
	}

}
