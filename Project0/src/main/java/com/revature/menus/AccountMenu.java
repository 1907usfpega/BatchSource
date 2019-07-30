package com.revature.menus;

import java.util.ArrayList;

import com.revature.beans.Account;

public class AccountMenu {

	public static void createAccount(String u) {
		String t;
		int aId;
		do {
			MenuOptions.clearConsole();
			System.out.println("CREATE ACCOUNT");
			System.out.println("Please enter account type:");
			System.out.println("1: Checking");
			System.out.println("2: Savings");
			t = MenuOptions.in.nextLine().trim();
			switch (t) {
			case "1":
				t = "Customer";
				MenuOptions.adi.insertAccount("Checking");
				aId = MenuOptions.anu.currentAccountSEQ();
				MenuOptions.anu.linkUserAndAccount(MenuOptions.udi.getUserId(u), aId);
				System.out.println("Account is pending. Check later to see status.");
				break;
			case "2":
				t = "Employee";
				MenuOptions.adi.insertAccount("Saving");
				aId = MenuOptions.anu.currentAccountSEQ();
				MenuOptions.anu.linkUserAndAccount(MenuOptions.udi.getUserId(u), aId);
				System.out.println("Account is pending. Check later to see status.");
				break;

			default:
				System.out.println("Sorry that wasn't a valid option. Please try again.");
				break;
			}
		} while (!t.equals("Customer") && !t.equals("Employee") && !t.equals("Admin"));

	}

	/*
	 * Lists all accounts for the user. Printed as #. |Acc Type | Bal: X.X | Acc
	 * Status | [List of users active on account]
	 */
	public static void selectAccount(String u) {
		int userId = MenuOptions.udi.getUserId(u);
		ArrayList<Integer> a = MenuOptions.anu.allAccounts(userId);
		ArrayList<Account> acc = new ArrayList<Account>();
		int i = 1;
		MenuOptions.clearConsole();
		System.out.println("SELECT ACCOUNT");
		System.out.println("Please select account");
		for (Integer ai : a) {
			acc.add(MenuOptions.adi.getAccount(ai));
			System.out.println(i + ": " + acc.get(acc.size() - 1));
			i++;
		}
		String input;

		input = MenuOptions.in.nextLine();

		try {
			int option = Integer.parseInt(input);
			if (option > 0 && option <= a.size()) {
				// check if selected account is approved
				if (acc.get(option - 1).getStatus().equals("Approved")) {
					accountMenu(u, acc.get(option - 1));
				} else {
					System.out.println("Sorry that account has not been approved.");
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Try again!");
		}
	}

	public static void accountMenu(String user, Account act) {
		MenuOptions.clearConsole();
		System.out.println("MY ACCOUNT");
		System.out.println("Please choose an option");
		System.out.println("1: Withdraw");
		System.out.println("2: Deposit");
		System.out.println("3: Make this account a joint account with another user");
		System.out.println("4: Transfer From This Accounts");
		System.out.println("5: End Account");

		String s;
		do {
			s = MenuOptions.in.nextLine();
			switch (s) {
			case "1":
				withdraw(user, act.getUniqueID());
				return;
			case "2":
				deposit(user, act.getUniqueID());
				return;
			case "3":
				grantAccess(user, act.getUniqueID());
				return;
			case "4":
				transferMoney(user, act.getUniqueID());
				return;
			case "5":
				endAccount(user, act.getUniqueID());
				return;
			default:
				return;
			}
		} while (s != "1" && s != "2" && s != "3" && s != "4");
	}

	public static void endAccount(String user, String act) {
		if (MenuOptions.adi.getBalance(Integer.parseInt(act)) == 0) {
			MenuOptions.adi.changeAccountStatus(Integer.parseInt(act), "Denied");
			MenuOptions.anu.unlinkUserAndAccount(Integer.parseInt(user), Integer.parseInt(act));

			System.out.println("You no longer have access to that account");
		}else {
			System.out.println("Account must be empty before it can end.");
		}
	}

	public static void withdraw(String user, String act) {
		System.out.println("Please input an amount");
		String s;
		int a;
		s = MenuOptions.in.nextLine();

		try {
			a = Integer.parseInt(act);
			double amount = Double.parseDouble(s);
			if (amount <= MenuOptions.adi.getAccount(a).getBalance() && amount >= 0) {
				MenuOptions.adi.changeAccountBalance(a, -1 * amount);
			} else if (amount < 0) {
				System.out.println("Value must be positive.");
			} else {
				System.out.println("Your balance is insufficient.");

			}
		} catch (NumberFormatException ne) {
			System.out.println("Not a valid amount");

		}

	}

	public static void deposit(String user, String act) {
		System.out.println("Please input an amount");
		String s;
		int a;
		s = MenuOptions.in.nextLine();
		try {
			a = Integer.parseInt(act);
			double amount = Double.parseDouble(s);
			if (amount > 0)
				MenuOptions.adi.changeAccountBalance(a, amount);
			else {
				System.out.println("Value must be positive.");
				return;
			}
		} catch (NumberFormatException ne) {
			System.out.println("Not a valid amount.");
			return;
		}
	}

	public static void grantAccess(String myUserName, String id) {
		MenuOptions.clearConsole();

		System.out.println("You are now making this a Joint account!");
		String username;

		System.out.println("Please enter the user id of the account you want to join");
		username = MenuOptions.in.nextLine();
		int uId = MenuOptions.udi.getUserId(username);
		if (uId == -1) {
			System.out.println("User does not exist");
			return;
		}
		if (!MenuOptions.udi.getUserStatus(username).equals("Approved")) {
			System.out.println("Sorry, user has not been approved");
			return;
		}

		System.out.println("Please enter the password of " + username);
		String password = MenuOptions.in.nextLine();
		if (!password.equals(MenuOptions.udi.getUserPassword(username))) {
			System.out.println("Incorrect Password. User failed to join account.");
			return;
		}
		MenuOptions.anu.linkUserAndAccount(uId, Integer.parseInt(id));
	}

	public static void transferMoney(String username, String source_id) {
		int uID = MenuOptions.udi.getUserId(username);
		ArrayList<Integer> acc = MenuOptions.anu.allAccounts(uID);
		ArrayList<Account> a = new ArrayList<Account>();
		for (Integer inta : acc) {
			a.add(MenuOptions.adi.getAccount(inta));
		}
		if (a.size() < 2) {
			System.out.println("Only one account found.");
			return;
		}

		System.out.println("TRANSFER FROM YOUR ACCOUNTS");
		System.out.println("Please Choose a target account");

		int i = 1;
		for (Account temp : a) {
			System.out.println(i + ": " + temp.toString());
			i++;
		}
		String input;
		input = MenuOptions.in.nextLine();
		try {
			int option = Integer.parseInt(input);
			if (option > 0 && option <= a.size()) {
				if (!a.get(option - 1).getUniqueID().equals(source_id)) {
					System.out.println("Please enter transfer amount.");
					input = MenuOptions.in.nextLine();
					double tranAmt;
					try {
						tranAmt = Double.parseDouble(input);
						if (tranAmt < 0.0) {
							System.out.println("Sorry, value cannot be negative.");
							return;
						}
						if (tranAmt > MenuOptions.adi.getBalance(Integer.parseInt(source_id))) {
							System.out.println("Sorry, insufficient funds");
							return;
						}
						MenuOptions.adi.changeAccountBalance(Integer.parseInt(source_id), -1 * tranAmt);
						MenuOptions.adi.changeAccountBalance(Integer.parseInt(a.get(option - 1).getUniqueID()),
								tranAmt);
						System.out.println("Funds transfered successfully.");
					} catch (NumberFormatException ne) {
						System.out.println("Invalid input.");
					}
				} else {
					System.out.println("Sorry, cannot tranfer to source account");
				}
			} else {
				System.out.println("Sorry, not a valid option.");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input.");
		}

	}

}
