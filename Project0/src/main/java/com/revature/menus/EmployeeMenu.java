package com.revature.menus;

import java.util.ArrayList;

import com.revature.beans.Account;

public class EmployeeMenu {
	
	public static void print() {
		MenuOptions.clearConsole();
		System.out.println("Employee Options");
		System.out.println("1: ViewUser Accounts");
		System.out.println("2: Logout");
	}
	public static void run() {
		String s;
		do {
			s = MenuOptions.in.nextLine().trim();
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
		u = MenuOptions.in.nextLine().trim();
		if (MenuOptions.udi.getUserId(u) == -1) {
			System.out.println("Username not found");
			return;
		}
		else {
			ArrayList<Account> accList = MenuOptions.adi.getAll();
			int i = 1;
			System.out.println("View user profile and accounts below.");
			MenuOptions.udi.getUser(u).printUser();
			System.out.println();
			for(Account s4 : accList) {
				if(MenuOptions.anu.allUsers(Integer.parseInt(s4.getUniqueID())).contains(MenuOptions.udi.getUserId(u))) {
				System.out.println(i + ": " + s4.toString());
				i++;
				}
			}
			System.out.println("\n\n\n");
		}	
	}	
}