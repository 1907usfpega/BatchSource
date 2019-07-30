package com.revature.account;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.database.Database;
import com.revature.user.User;

public class Account {

	private final String accountType;
	private final String accountName;
	private ArrayList<String> owner;
	private int balance;
	private int accountID;
	private boolean loggedIn;
	private boolean deleted;

	User currentUser;
	Scanner scan;
	
	public Account(String accountType, String accountName, int accountID, int bal, String... owner) {
		this.accountType = accountType;
		this.accountName = accountName;
		this.owner = new ArrayList<String>();
		for (String o : owner) {
			this.owner.add(o.toUpperCase());
		}
		this.balance = bal;
		this.accountID = accountID;
		loggedIn = false;
	}

	public Account(String accountType, String accountName, int accountID, String... owner) {
		this.accountType = accountType;
		this.accountName = accountName;
		this.owner = new ArrayList<String>();
		for (String o : owner) {
			this.owner.add(o.toUpperCase());
		}
		this.balance = 0;
		this.accountID = accountID;
		loggedIn = false;
	}

	public static Account createAccount(String accountType, String accountName, int accountID, String... owner) {
		// TODO check to make sure it has a unique accountID
		Account a = new Account(accountType, accountName, accountID, owner);
		Database.addAccount(a);
		return a;
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

	public boolean isOwner(User u) {
		return this.owner.contains(u.getUserName());
	}

	public boolean isDeleted() {
		return deleted;
	}

	void addOwner(String... username) {
		for (String x : username) {
			this.owner.add(x.toUpperCase());
		}
		// TODO add validation
		Database.updateAccount(this);
	}

	public void removeOwner(String... username) {
		for (String x : username) {
			this.owner.remove(x);
		}
		Database.updateAccount(this);
		if(owner.isEmpty()) {
			this.delete();
		}
	}

	public String getAccountType() {
		return accountType;
	}

	public String getAccountName() {
		return accountName;
	}

	public int getAccountID() {
		return accountID;
	}

	public int getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "[" + accountType + " account \"" + accountName.toUpperCase() + "\" belonging to " + owner + "]";
	}

	public String toString(boolean includeBalance) {
		return (this.toString() + (includeBalance ? (" Balance: $" + balance) : ""));
	}

	public boolean equals(Account acc) {
		return this.accountName.equals(acc.accountName);
			
			
	}

	private void displayBalance() {
		System.out.println("Current Balance of " + accountName + ": $" + balance);
	}// end displayBalance

	private void withdraw(int amount) {
		if (amount < 0) {
			System.out.println("Invalid amount.");
		} else if (amount > balance) {
			System.out.println("Error: cannot withdraw more than the current balance");
		} else {
			balance -= amount;
			System.out.println("Withdrawn $" + amount + " from " + accountName);
			Database.updateAccount(this);
		} // end else
	}// end withdraw

	private void deposit(int amount) {
		if (amount < 0) {
			System.out.println("Invalid amount.");
		} else {
			balance += amount;
			System.out.println("Deposited $" + amount + " to " + accountName);
			Database.updateAccount(this);
		} // end else
	}// end deposit

	public void delete() {
		deleted = true;
		Database.removeAccount(this);
	}

	void logout() {
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
		else {
			System.out.println("This account has been deleted.");
			Database.removeAccount(this);
		}
	}// end login

	static final int WITHDRAW = 1;
	static final int DEPOSIT = 2;
	static final int TRANSFER = 3;
	static final int BALANCE = 4;
	static final int DELETE_ACCOUNT = 5;

	private void run() {
		if (this.isLoggedIn() && !this.deleted) {
			System.out.println("Welcome to your " + accountType + " account, " + currentUser.getFirstName());

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
				System.out.println("Q.\t Log Out");
				// TODO view owners

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
					+ "\nPlease withdraw that ammount before trying again");
			return;
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
						"To delete your account, enter your password.\nTo back out at the last second, enter Q");
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

	private void transferMoney() {
		boolean quit = false;
		String input;
		int index = -1;
		while (!quit) {
			Database.printAccounts(true);
			System.out.println("Select an account to transfer to, or enter Q to quit");
			input = scan.nextLine();
			if (input.toUpperCase().equals("Q")) {
				quit = true;
			} else {
				try {
					index = Integer.parseInt(input);
				} catch (NumberFormatException e) {
				} // end catch
				if (index > Database.aList.size() - 1 || index < 0) {
					System.out.println("That is not a valid index.");
				} else {
					transfer(Database.aList.get(index));
					quit = true;
				} // end else
			} // end else(not Q)
		} // end while(!quit)
	}// end transferMoney

	private void transfer(Account a) {
		int w = this.withdrawMoney();
		a.deposit(w);
	}// end transfer

	void depositMoney() {
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
		boolean quit = false;
		int withdrawn = 0;
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
									withdrawn = amount;
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

	public int withdrawAsAdmin(User u) {
		scan = new Scanner(System.in);
		int withdrawn = 0;
		if (u.getIsAdmin()==4321) {
			System.out.println("Please enter your password to confirm withdrawl from " + this);
			String pass = scan.nextLine();
			if (u.checkPassword(pass)) {

				if (this.balance > 0) {
					System.out.println("How much money do you want to withdraw?");
					boolean quit = false;
					String input;
					do {
						input = scan.nextLine();
						if (input.toUpperCase().equals("Q")) {
							quit = true;
						} else {
							try {
								int amount = Integer.parseInt(input);
								withdraw(amount);
								withdrawn = amount;
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
				} // end else balance<=0

			} else {
				System.out.println("Incorrect Password.");
			} // end else incorrect password
		} else {
			System.out.println("Invalid Authorization. \n(How did you even get in here? This is an admin-only area.)");
		} // end else not an admin
		return withdrawn;
	}// end withdraw as admin

	public void depositAsAdmin(User u) {
		scan = new Scanner(System.in);
		if (u.getIsAdmin()==4321) {
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
					} // end catch
				} // end else
			} while (!quit);
		} else {
			System.out.println("Invalid Authorization. \n(How did you even get in here? This is an admin-only area.)");
		} // end else not an admin

	}// end depositAsAdmin

	public void transferAsAdmin(User u) {
		scan = new Scanner(System.in);
		if (u.getIsAdmin()==4321) {
			// TODO Auto-generated method stub
			boolean quit = false;
			String input;
			int index = -1;
			while (!quit) {
				Database.printAccounts(true);
				System.out.println("Select an account to transfer to, or enter Q to quit");
				input = scan.nextLine();
				if (input.toUpperCase().equals("Q")) {
					quit = true;
				} else {
					try {
						index = Integer.parseInt(input);
					} catch (NumberFormatException e) {
					} // end catch
					if (index > Database.aList.size() - 1 || index < 0) {
						System.out.println("That is not a valid index.");
					} else {
						int w = this.withdrawAsAdmin(u);
						Database.aList.get(index).deposit(w);
						quit = true;
					} // end else
				} // end else(not Q)
			} // end while(!quit)
		} else {
			System.out.println("Invalid Authorization. \n(How did you even get in here? This is an admin-only area.)");
		} // end else not an admin

	}// end transferAsAdmin

}// end Account