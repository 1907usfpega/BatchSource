package com.revature.menus;

import java.util.ArrayList;

import com.revature.beans.Account;
import com.revature.beans.User;


public class AdminMenu {

	public static void print() {
		MenuOptions.clearConsole();
		System.out.println("ADMIN OPTIONS");
		System.out.println("1: View Account/Edit Balance");
		System.out.println("2: View All Users");
		System.out.println("3: View All Accounts");
		System.out.println("4: Approve/Deny/Cancel Users");
		System.out.println("5: Approve/Deny/Cancel Accounts");
		System.out.println("6: Logout");
	}

	public static void run() {
		String s;

		do {
			s = MenuOptions.in.nextLine().trim();
			switch (s) {
			case "1":
				editUsers();
				print();
				break;
			case "2":
				MenuOptions.udi.printAll();
				print();
				break;
			case "3":
				MenuOptions.adi.printAll();
				print();
				break;
			case "4":
				appOrDenyUsers();
				print();
				break;
			case "5":
				appOrDenyAccounts();
				print();
				break;
			case "6":
				return;
			default:
				System.out.println("Sorry that wasn't a valid option. Please try again.");
				print();
				break;
			}
		} while (!s.equals("6"));
	}
	public static void editUsers() {
		String u;
		System.out.println("Please type a user name.");
		u = MenuOptions.in.nextLine().trim();
		if (MenuOptions.udi.getUserId(u) == -1) {
			System.out.println("Username not found");
			return;
		}
		else {
			ArrayList<Integer> accountIdlist = null;
			accountIdlist = MenuOptions.anu.allAccounts(MenuOptions.udi.getUserId(u));
			ArrayList<String> acctList = new ArrayList<String>();
			for(Integer id: accountIdlist) {
				acctList.add(MenuOptions.adi.getAccount(id).getUniqueID());
			}
			
			int i = 1;
			System.out.println("View user profile and accounts below.");
			System.out.println("Choose an option to change balance.");
			MenuOptions.udi.getUser(u).printUser();
			System.out.println();
			for(String s4 : acctList) {
				System.out.println(i + ": " + MenuOptions.adi.getAccount(Integer.parseInt(s4)));
				i++;
			}
			int pickInt;
			String accPick = new String();
				u = MenuOptions.in.nextLine();
				try {
					pickInt = Integer.parseInt(u);
					if(pickInt <=acctList.size() && pickInt > 0) {
						accPick = acctList.get(pickInt - 1);
					}
					else {
						System.out.println("Not a valid option");
						return;
					}
				}catch(NumberFormatException ne) {
					System.out.println("Not a valid option");
					return;
				}
			System.out.println("Please input a new balance for the following account.");
			MenuOptions.adi.getAccount(Integer.parseInt(accPick)).printAccount();
			u = MenuOptions.in.nextLine();
			double valInt;
			try {
				valInt = Double.parseDouble(u);
				if(valInt >= 0) {
					MenuOptions.adi.setAccountBalance(Integer.parseInt(accPick), valInt);
				}
				else {
					System.out.println("Invalid amount.");
				}
			}catch(NumberFormatException ne) {
				System.out.println("Not a valid input");
			}
			
		}
		
	}
	public static void appOrDenyUsers() {
		System.out.println("Approv/Deny/Cancel Users");
		System.out.println("Choose an user from the list below.");
		ArrayList<User> list =  MenuOptions.udi.getAll();
		int count = 1;
		for(User s: list) {
			System.out.println(count + " " + s.toString());
			count++;
		}
		String pick;
		int pickInt;
		User userPick;
		pick = MenuOptions.in.nextLine();
		try {
			pickInt = Integer.parseInt(pick);
			if(pickInt <=list.size() && pickInt > 0) {
				userPick = list.get(pickInt - 1);
				approveDenyUsers(userPick.getUserName());
			}
			else {
				System.out.println("Not a valid option");
				return;
			}
		}catch(NumberFormatException ne) {
			System.out.println("Not a valid option");
			return;
		}
	}
	public static void appOrDenyAccounts() {
		System.out.println("Approve/Deny/Cancel Accounts");
		System.out.println("Choose an account from the list below.");
		ArrayList<Account> allA = MenuOptions.adi.getAll();
		
		int count = 1;
		for(Account s: allA) {
			System.out.println(count + ": AccountID: " + s.getUniqueID() + "  :Account Type:" 
					+ s.getAccountType() + " | "
					+ s.getStatus());
			count++;
		}
		String pick;
		int pickInt;
		String accPick;
		pick = MenuOptions.in.nextLine();
		try {
			pickInt = Integer.parseInt(pick);
			if(pickInt <=allA.size() && pickInt > 0) {
				accPick = allA.get(pickInt - 1).getUniqueID();
				approveDenyAcc(accPick);
			}
			else {
				System.out.println("Not a valid option");
				return;
			}
		}catch(NumberFormatException ne) {
			System.out.println("Not a valid option");
			return;
		}
	}
	
	public static void approveDenyAcc(String accName) {
		MenuOptions.clearConsole();
		System.out.println("Choose an option:");
		System.out.println("1: Approve");
		System.out.println("2: Deny/Cancel");
		String s3;
		s3 = MenuOptions.in.nextLine();
		switch(s3) {
			case "1":
				//Dbs.accData.approve(accName);
				MenuOptions.adi.changeAccountStatus(Integer.parseInt(accName), "Approved");
				System.out.println("Account Approved");
				return;
			case "2":
				//Dbs.accData.deny(accName);
				MenuOptions.adi.changeAccountStatus(Integer.parseInt(accName), "Denied");
				System.out.println("Account Cancelled");
				return;
			default:
				System.out.println("Not a valid option.");
			}
	}
	
	
	
	public static void approveDenyUsers(String userName) {
		MenuOptions.clearConsole();
		System.out.println("Choose an option:");
		System.out.println("1: Approve");
		System.out.println("2: Deny/Cancel");
		String s3;
		s3 = MenuOptions.in.nextLine();
		switch(s3) {
			case "1":
				MenuOptions.udi.changeUserStatus(userName, "Approved");
				System.out.println("User Approved");
				return;
			case "2":
				MenuOptions.udi.changeUserStatus(userName, "Denied");
				System.out.println("User Cancelled");
				return;
			default:
				System.out.println("Not a valid option");
		}
	}
}
