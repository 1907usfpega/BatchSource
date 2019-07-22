package com.revature.driver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.UUID;

import com.revature.io.Database;

public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6504179454583671883L;
	private final String accountType;
	private final String accountName;
	private ArrayList<String> owner;
	private int balance;
	private String accountID;
	private boolean loggedIn;
	
	transient User currentUser;
	transient Scanner scan;
	private boolean deleted;

	private Account(String accountType, String accountName, String owner, String accountID) {
		this.accountType = accountType;
		this.accountName = accountName;
		this.owner = new ArrayList<String>();
		this.owner.add(owner);
		this.balance = 0;
		this.accountID = accountID;
		loggedIn = false;
	}

	public static Account createAccount(String accountType, String accountName, String owner, String accountID) {
		// TODO check to make sure it has a unique accountID
		Account a = new Account(accountType, accountName, owner, accountID);
		Database.addAccount(a);
		return a;
	}
	public static void requestAccount(String accountType, String accountName, String owner) {
		String uniqueID = UUID.randomUUID().toString();
		Account a=new Account(accountType, accountName, owner,uniqueID);
		Database.addRequest(a);
	}

	public ArrayList<String> getOwner() {
		return owner;
	}

	void setOwner(ArrayList<String> owner) {
		this.owner = owner;
	}

	public boolean isOwner(String username) {
		return this.owner.contains(username);
	}

	void addOwner(String... username) {
		for (String x : username) {
			this.owner.add(x);
		}
		Database.updateAccount(this);
	}

	void removeOwner(String... username) {
		for (String x : username) {
			this.owner.remove(x);
		}
		Database.updateAccount(this);
	}

	public String getAccountType() {
		return accountType;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getAccountID() {
		return accountID;
	}

	@Override
	public String toString() {
		return accountType + " acount: " + accountName.toUpperCase() + " Owner: " + owner;
	}
	public String toString(boolean includeBalance) {
		return (this.toString()+(includeBalance?(" Balance: "+balance):""));
	}

	public boolean equals(Account acc) {
		return this.accountID.equals(acc.accountID);
	}

	private void displayBalance() {
		System.out.println("Current Balance: $" + balance);
	}// end displayBalance

	private void withdraw(int amount) {
		if (amount < 0) {
			System.out.println("Invalid amount.");
		} else if (amount > balance) {
			System.out.println("Error: cannot withdraw more than the current balance");
		} else {
			balance -= amount;
			System.out.println("Withdrawn $" + amount);
			Database.updateAccount(this);
		} // end else
	}// end withdraw

	private void deposit(int amount) {
		if (amount < 0) {
			System.out.println("Invalid amount.");
		} else {
			balance += amount;
			System.out.println("Deposited $" + amount);
			Database.updateAccount(this);
		} // end else
	}// end deposit
	
	private void transfer(String a) {
		if(this.getAccountName().equals(a)) {
			System.out.println("You Cannot Transfer to the same account");
		}
		else{
			Iterator<Account> itr = Database.aList.iterator();
			while (itr.hasNext()) {
				Account b = itr.next();
				if (b.getAccountName().equals(a)) {
					int w= this.withdrawMoney();
					b.deposit(w);
					break;
				}
			}
		}
	}
	
	public void logout() {
		loggedIn = false;
		Database.updateAccount(this);
		System.out.println("You have been logged out of " + accountName + ".");
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void login(User u) {
		if (!deleted) {
			scan = new Scanner(System.in);
			System.out.println("Please enter your password to confirm.");
			String pass = scan.nextLine();
			if (u.checkPassword(pass)) {
				loggedIn = true;
				currentUser = u;
				run();
			} // end if passcheck
		} // end if(!deleted)
	}// end login

	static final int WITHDRAW = 1;
	static final int DEPOSIT = 2;
	static final int TRANSFER = 3;
	static final int BALANCE = 4;
	static final int DELETE_ACCOUNT = 5;

	private void run() {
		if (this.isLoggedIn() && !this.deleted) {
			System.out.println("Welcome to your " + accountType + " account, " + currentUser.getUserName());

			String choice;
			int ch;
			boolean quit = false;
			do {
				System.out.println("\nMenu:");
				System.out.println(WITHDRAW + ".\t Withdraw Money");
				System.out.println(DEPOSIT + ".\t Deposit Money");
				System.out.println(TRANSFER + ".\t Transfer Money");
				System.out.println(BALANCE + ".\t View Balance");
				System.out.println(DELETE_ACCOUNT + ".\t Delete account");
				System.out.println("Q.\t Log Out");
				//TODO view owners

				choice = scan.nextLine();
				if (choice.toUpperCase().equals("Q")) {
					quit = true;
				} else {
					try {
						ch = Integer.parseInt(choice);
						switch (ch) {
						case WITHDRAW:
							withdrawMoney();
							break;
						case DEPOSIT:
							depositMoney();
							break;
						case TRANSFER:
							transferMoney();
							break;
						case DELETE_ACCOUNT:
							deleteAccount();
							break;
						case BALANCE:
							viewBalance();
							break;
						default:
							System.out.println("That is not a valid choice.");
						}// end switch
					} catch (NumberFormatException e) {
						System.out.println("Please enter a number.");
					} // end catch
				} // end else
			} while (!quit && !this.deleted);
			System.out.println("Goodbye.");
			logout();
		} // end if
	}// end run

	private void viewBalance() {
		displayBalance();
	}

	private void deleteAccount() {
		if (this.balance > 0) {
			System.out.println("This account has a balance of $" + balance + ". "
					+ "\nIf you delete it right now, you're never seeing that money again.");
		} // end balance>0

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
			boolean quit = false;
			String pass;
			do {
				System.out.println(
						"To delete your account, enter your password. " + "\nTo back out at the last second, enter Q");
				pass = scan.nextLine();
				if (pass.toUpperCase().equals("Q")) {
					quit = true;
				} // end if q
				else {
					if (currentUser.checkPassword(pass)) {
						Database.removeAccount(this);
						this.deleted = true;
						System.out.println("Your account has been deleted.");
						quit = true;
					}
				} // end else

			} while (!quit);
		} // end if(delete)
	}// end deleteAccount

	private void depositMoney() {
		System.out.println("How much money do you want to deposit?");
		boolean quit = false;
		String input;
		do {
			input = scan.nextLine();
			if (input.toUpperCase().equals("Q")) {
				quit = true;
			} else {
				try {
					int amount = Integer.parseInt(input);
					deposit(amount);
					this.displayBalance();
					quit = true;
				} catch (NumberFormatException e) {
					System.out.println("Please enter an integer or enter Q to exit.");
				}
			} // end else
		} while (!quit);
	}// end depositMoney

	private int withdrawMoney() {
		String pass;
		int withdrawn=0;
		boolean quit = false;
		do {
			System.out.println("Enter your password to withdraw money, or enter Q to quit");
			pass = scan.nextLine();
			if (pass.toUpperCase().equals("Q")) {
				quit = true;
			} // end if q
			else {
				if (currentUser.checkPassword(pass)) {
					this.displayBalance();
					if (this.balance > 0) {
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
									withdraw(amount);
									withdrawn=amount;
									this.displayBalance();
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
				} // end if checkPassword
			} // end else

		} while (!quit);
		return withdrawn;
	}
	private void transferMoney() {
		System.out.println("Enter an account to transfer to:");
		String s=scan.nextLine();
		transfer(s);
	}
	
	public void withdrawFrom(Account a) {
		boolean quit;
		if (a.balance > 0) {
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
						withdraw(amount);
						this.displayBalance();
						quit = true;
					} catch (NumberFormatException e) {
						System.out.println("Please enter an integer or enter Q to exit.");
					}
				} // end else
			}while (!quit);
		}
	}
	public void depositTo(Account a) {
		boolean quit;
	
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
						deposit(amount);
						this.displayBalance();
						quit = true;
					} catch (NumberFormatException e) {
						System.out.println("Please enter an integer or enter Q to exit.");
					}
				} // end else
			}while (!quit);
	}
	public void transferBetween(Account a, String b) {
		a.transfer(b);
	}

	
}
