package com.revature.bankingapppt1_2;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMenu {
	
	public static void print() {
		MO.clearConsole();
		System.out.println("Employee Options");
		System.out.println("1: ViewUser Accounts");
		System.out.println("2: Logout");
	}
	public static void run() {
		String s;
		do {
			s = MO.in.nextLine().trim();
			switch (s) {
			case "1":
				viewUsers();
				print();
				break;
			case "2":
				return;
			default:
				System.out.println("Sorry that wasn't a valid option. Please try again.");
				print();
				break;
			}
		} while (!s.equals("2"));
	}
	
	public static void viewUsers() {
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
			MO.udi.getUser(u).printUser();
			System.out.println();
			for(Account s5 : acctList) {
				System.out.println(i + ": " + s5.toString());
				i++;
			}
			System.out.println("\n\n\n");
		}	
	}	
}