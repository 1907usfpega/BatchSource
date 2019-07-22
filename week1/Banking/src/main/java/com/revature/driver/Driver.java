package com.revature.driver;

import java.util.Iterator;
import java.util.Scanner;

import com.revature.io.Database;

public class Driver {
	static Scanner sc;

	public static void main(String[] args) {
		Database.readUsers();
		Database.readAccounts();
		Database.readRequests();
		
		Iterator<User> itr = Database.pList.iterator();
		while (itr.hasNext()) {
			User b = itr.next();
			System.out.println(b.toString());
		}

		boolean q = false;

		while (!q) {
			System.out.println("To Login Press 1");
			System.out.println("To Register a New Account Press 2");
			System.out.println("To Quit the Application Press Q");
			sc = new Scanner(System.in);
			String input = sc.next();
			switch (input) {
			case "1":
				login();
				break;
			case "2":
				register();
				break;
			case "q":
			case "Q":
				q = true;
				break;
			default:
				System.out.println("Invalid Input");
			}
		}
		
		System.out.println("Thank You");
		sc.close();
		return;

	}

	public static boolean confirm(String s) {
		boolean found = false;
		Iterator<User> itr = Database.pList.iterator();
		while (itr.hasNext()) {
			User b = itr.next();
			if (s.equalsIgnoreCase(b.getUserName())) {
				found = true;
				break;
			}
		}
		return found;
	}

	public static void login() {
		boolean found = false;
		System.out.println("Please Enter Your UserName:");
		String input = sc.next();
		Iterator<User> itr = Database.pList.iterator();
		while (itr.hasNext()) {
			User b = itr.next();
			if (input.equalsIgnoreCase(b.getUserName())) {
				b.login();
				found = true;
				break;
			}
		}
		if (!found)
			System.out.println("Username not Found");
	}

	public static void register() {
		boolean found = false;
		String use = null;
		while (!found) {
			System.out.println("Enter new username");
			use = sc.next();
			Iterator<User> itr = Database.pList.iterator();
			while (itr.hasNext()) {
				User b = itr.next();
				if (use.equalsIgnoreCase(b.getUserName())) {
					found = true;
					break;
				}
			}
			if (found) {
				System.out.println("That UserName is taken, please use a new one");
			}
			else
				break;
			found=false;
		}

		System.out.println("pass");
		String pass = sc.next();
		System.out.println("fullname");
		sc.nextLine();
		String name = sc.nextLine();
		User.register(use, pass, name);
	}
}
