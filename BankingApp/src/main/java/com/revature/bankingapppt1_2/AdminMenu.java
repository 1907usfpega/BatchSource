package com.revature.bankingapppt1_2;

import java.util.ArrayList;
import java.util.List;

public class AdminMenu {

	public static void print() {
		MO.clearConsole();
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
			s = MO.in.nextLine().trim();
			switch (s) {
			case "1":
				editUsers();
				print();
				break;
			case "2":
				for(User s9 : MO.udi.getUserList())
					s9.printUser();
				print();
				break;
			case "3":
				for(Account s8 : MO.adi.getAcctList())
					s8.printAccount();
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
		u = MO.in.nextLine().trim();
		if (!MO.udi.doesUserExist(u)) {
			System.out.println("Username not found");
			return;
		}
		else {
			List<Account> acctList;
			acctList = MO.udi.getAccountList(u);
			int i = 1;
			System.out.println("View user profile and accounts below.");
			System.out.println("Choose an option to change balance.");
			MO.udi.getUser(u).printUser();
			System.out.println();
			for(Account s4 : acctList) {
				System.out.println(i + ": " + s4.toString());
				i++;
			}
			int pickInt;
			String accPick = new String();
				u = MO.in.nextLine();
				try {
					pickInt = Integer.parseInt(u);
					if(pickInt <=acctList.size() && pickInt > 0) {
						accPick = acctList.get(pickInt - 1).getUniqueID();
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
			MO.adi.getAccount(Integer.parseInt(accPick)).printAccount();
			//Dbs.accData.getAccount(accPick).printAccount();
			u = MO.in.nextLine();
			double valInt;
			try {
				valInt = Double.parseDouble(u);
				if(valInt >= 0) {
					MO.adi.setBalance(Integer.parseInt(accPick), valInt);
					//Dbs.accData.setBalance(accPick, valInt);
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
		List<User> pending =  MO.udi.getUserList();
		int count = 1;
		for(User s: pending) {
			System.out.println(count + " | Username : " + s.getUserName()
					+ " | Clearance: " + s.getClearanceLevel()/*Dbs.getUserData().getClearanceLevel(s)*/ + " | Status: "
					+ s.getStatus()/*Dbs.getUserData().getUser(s).getStatus()*/);
			count++;
		}
		String pick;
		int pickInt;
		String userPick;
		pick = MO.in.nextLine();
		try {
			pickInt = Integer.parseInt(pick);
			if(pickInt <=pending.size() && pickInt > 0) {
				userPick = pending.get(pickInt - 1).getUserName();
				approveDenyUsers(userPick);
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
		List<Account> pending = MO.adi.getAcctList();//Dbs.accData.getAll();
		int count = 1;
		for(Account s : pending) {
			System.out.println(count + " | AccountID: " + s.getUniqueID() + " | Account Type: " 
					+ s.getAccountType()/*Dbs.getAccData().getAccount(s).getAccountType()*/ + " | Status: "
					+ s.getStatus()/*Dbs.getAccData().getAccount(s).getStatus()*/);
			count++;
		}
		String pick;
		int pickInt;
		String accPick;
		pick = MO.in.nextLine();
		try {
			pickInt = Integer.parseInt(pick);
			if(pickInt <=pending.size() && pickInt > 0) {
				accPick = pending.get(pickInt - 1).getUniqueID();
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
		MO.clearConsole();
		System.out.println("Choose an option:");
		System.out.println("1: Approve");
		System.out.println("2: Deny/Cancel");
		String s3;
		s3 = MO.in.nextLine();
		switch(s3) {
			case "1":
				MO.adi.changeAStatus(Integer.parseInt(accName), "Approved");
				//Dbs.accData.approve(accName);
				System.out.println("Account Approved");
				return;
			case "2":
				MO.adi.changeAStatus(Integer.parseInt(accName), "Cancelled");
				//Dbs.accData.deny(accName);
				System.out.println("Account Cancelled");
				return;
			default:
				System.out.println("Not a valid option.");
			}
	}
	
	
	
	public static void approveDenyUsers(String userName) {
		MO.clearConsole();
		System.out.println("Choose an option:");
		System.out.println("1: Approve");
		System.out.println("2: Deny/Cancel");
		String s3;
		s3 = MO.in.nextLine();
		switch(s3) {
			case "1":
				MO.udi.changeUStatus(userName, "Approved");
				//Dbs.userData.approve(userName);
				System.out.println("User Approved");
				return;
			case "2":
				MO.udi.changeUStatus(userName, "Cancelled");
				//Dbs.userData.deny(userName);
				System.out.println("User Cancelled");
				return;
			default:
				System.out.println("Not a valid option");
		}
	}
}
