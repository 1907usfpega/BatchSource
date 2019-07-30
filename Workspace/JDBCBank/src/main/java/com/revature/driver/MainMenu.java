package com.revature.driver;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.UserDaoImpl;

public class MainMenu {

	public static boolean loginOrRegister() {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Welcome to the banking bash! If you want to register, type r and if you want to login, type l.");
		String input = "";
		while (!input.equals("stop")) {
			sc = new Scanner(System.in);
			input = sc.nextLine();
			if (input.length() > 1 && !input.equals("stop")) {
				System.out.println("invalid input! please try again.");
			} else {
				switch (input.charAt(0)) {
				case ('r'):
					registerView();
					return true;
				case ('l'):
					loginView();
					return true;
				default:System.out.println("Not an option. l or r!");
				}
			}
		}
		return false;
	}
	

	public static void loginView() {
		System.out.println(Driver.admin);
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Login view is what you chose! Please enter your username now, or enter stop to return to the main menu!");
		String input = "";
		sc = new Scanner(System.in);
		input = sc.nextLine();
		if (input.equals("stop"))
			return;
		if (input.length() < 3) {
			System.out.println("Please use more than 2 characters for your username.");
			return;
		} else {
			ArrayList<User> users = Driver.userList;
			if (Driver.admin.getName().equals(input)) {
				System.out.println(
						"Aha! Trying to log in as the admin, I see. Well, good luck with that... Maybe enter stop if are having second thoughts.");
				sc = new Scanner(System.in);
				input = sc.nextLine();
				if (input.length() < 3) {
					System.out.println("Please use more than 2 characters for your password.");
					return;
				}
				if (input.equals("stop"))
					return;
				if (Driver.admin.getPassword().equals(input)) {
					System.out.println("You logged in as the admin. Wow! You are an amazing person! =) ");
					Driver.setLoggedInUser(Driver.admin);
					LoggedInView.adminMainMenu();
					return;
				}

			} else
				for (User user : users) {
					if (user.getName().equals(input)/* TODO ADMIN */ ) {
						String username = input;
						System.out.println(username
								+ " exists! Please now enter your password, or enter stop to return to the main menu!");
						sc = new Scanner(System.in);
						input = sc.nextLine();
						if (input.length() < 3) {
							System.out.println("Please use more than 2 characters for your password.");
							return;
						}
						if (input.equals("stop"))
							return;
						if (user.getPassword().equals(input)) {
							System.out.println("You now are logged in. Welcome " + username);
							Driver.setLoggedInUser(user);
							LoggedInView.UserMainMenu();
							return;
						}
						System.out.println("not the right password, eh? :/");

					}
				}
			System.out.println(
					"Your username was not found in our database! Please login with your registered username or register a new account.");
			return;
		}
	}

	
	public static void registerView() {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Welcome to the register view! Please enter your desired username now, or enter stop to return to the main menu!");
		String input = "";
		sc = new Scanner(System.in);
		input = sc.nextLine();
		if (input.equals("stop"))
			return;
		if (input.length() < 3) {
			System.out.println("Please use more than 2 characters for your username.");
			return;
		} else {
			ArrayList<User> users = Driver.userList;
			if(input.equals(Driver.admin.getName())) {
				System.out.println("You better not take our admins name, boi!");
				return;
			}
			for (User user : users) {
				if (user.getName().equals(input)) {
					System.out.println("That name is already taken. Maybe try loggin in instead!");
					return;
				}
			}
		}
		String username = input;
		System.out.println(username + " is available! Please now choose a password, or enter stop to return to the main menu!");
		sc = new Scanner(System.in);
		input = sc.nextLine();
		if (input.length() < 3) {
			System.out.println("Please use more than 2 characters for your password.");
			return;
		}if (input.equals("stop"))
			return;
		String password = input;
		System.out.println("Your account " + username + " was created. Use " + password + " to login.");
		UserDaoImpl udi = new UserDaoImpl();
		udi.createUser(username, password);
		Driver.userList = Driver.getUsers();
		return;
	}
}
