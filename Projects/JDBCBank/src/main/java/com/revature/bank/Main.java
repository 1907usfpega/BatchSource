package com.revature.bank;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String username, password, firstName, lastName, address, city, state, phoneNumber;
		User user = new User();
		Administrator admin = new Administrator();
		UserDAO userDAO = new UserDAO();
		AccountDAO accountDAO = new AccountDAO();
		AdministratorDAO adminDAO = new AdministratorDAO();
		Scanner sc = new Scanner(System.in);
		List<User> users = new ArrayList<User>();

		boolean keepGoing = true;
		int option;
		while (keepGoing) {
			// Log In
			System.out.println(
					"What Action Would You Like To Perform?....\nEnter 1 to Login.\nEnter 2 to Create An Account.");
			option = sc.nextInt();
			if (option == 1) {
				while (keepGoing) {
					System.out.println(
							"What Action Would You Like To Perform?....\nEnter 1 for User Login.\nEnter 2 for Administrator Login.");
					switch (sc.nextInt()) {
					case 1: { // User Login
						System.out.println("Enter Username!");
						username = sc.next(); // stores the username
						System.out.println("Enter Password!");
						password = sc.next(); // Stores the password
						try {
							user = userDAO.athenticate(username, password);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						while (user != null) {
							System.out.println(
									"What Action Would You Like To Perform?....\nEnter 1 to withdraw.\nEnter 2 to deposit.\nEnter 3 to transfer\nEnter 4 to Log Out.");
							switch (sc.nextInt()) {
							case 1: { // Withdraw Funds
								System.out.println("How Much Would You Like To Withdraw?");
								try {
									accountDAO.withdraw(user.getAccountNumber(), sc.nextDouble());
								} catch (SQLException e) {
									e.printStackTrace();
								}
								break;
							}
							case 2: { // Deposit Funds
								System.out.println("How Much Would You Like To Deposit?");
								try {
									accountDAO.deposit(user.getAccountNumber(), sc.nextDouble());
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							}
							case 3: { // Transfer Funds - change to account from the array
								double deposit;
								System.out.println("How Much Would You Like To Transfer?");
								deposit = sc.nextDouble();
								System.out.println("What Account Would You Like To Transfer To?");
								try {
									accountDAO.transfer(user.getAccountNumber(), deposit, sc.nextInt());
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							}
							case 4: { // Log Out
								System.out.println("Logging Out...Goodbye!");
								keepGoing = false;
								System.exit(0);
								break;
							}
							}
						}
						break;
					}
					case 2: { // Administrator Login
						System.out.println("Enter Username!");
						username = sc.next(); // stores the username
						System.out.println("Enter Password!");
						password = sc.next(); // Stores the password
						try {
							admin = adminDAO.athenticate(username, password);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						while (admin != null) {
							while (keepGoing) {
								System.out.println(
										"What Action Would You Like To Perform?....\nEnter 1 To View Accounts.\nEnter 2 To Create A User Account.\nEnter 3 To Delete A User Account.\nEnter 4 To Update A User.\nEnter 5 To Log Out.");
								switch (sc.nextInt()) {
								case 1: { // View Accounts
									try {
										users = userDAO.getAll();
										for (int i = 0; i < users.size(); i++) {
											System.out.println(users.get(i));
										}
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
								}
								case 2: { // Create User Account
									while (keepGoing) {
										System.out.println("Choose A Username.");
										username = sc.next();
										try {
											if (userDAO.usernameAvailable(username) == true) {
												System.out.println("Choose A Password.");
												password = sc.next();
												System.out.println("First Name:");
												firstName = sc.next();
												System.out.println("Last Name:");
												lastName = sc.next();
												System.out.println("Address:");
												address = sc.next();
												address = address + " " + sc.next();
												address = address + " " + sc.next();
												System.out.println("City:");
												city = sc.next();
												System.out.println("State:");
												state = sc.next();
												System.out.println("Phone Number:");
												phoneNumber = sc.next();
												userDAO.createUser(username, password, firstName, lastName, address,
														city, state, phoneNumber);
												break;
											}
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									break;
								}
								case 3: { // Delete A User
									System.out.println("Enter The Account Number Of The Account You Wish To Delete.");
									try {
										userDAO.delete(sc.nextInt());
									} catch (SQLException e) {
										e.printStackTrace();
									}
									break;
								}
								case 4: { // Update A User
									System.out.println("Coming soon!");
									break;
								}
								case 5: { // Log Out
									System.out.println("Logging Out...Goodbye!");
									keepGoing = false;
									break;
								}
								}
							}
							break;
						}
						break;
					}
					}
				}
				// Create Account
			} else if (option == 2) { // If 2 is input then the following code is ran to create a user
				while (keepGoing) {
					System.out.println("Choose A Username.");
					username = sc.next();
					try {
						if (userDAO.usernameAvailable(username) == true) {
							System.out.println("Choose A Password.");
							password = sc.next();
							System.out.println("First Name:");
							firstName = sc.next();
							System.out.println("Last Name:");
							lastName = sc.next();
							System.out.println("Address:");
							address = sc.next();
							address = address + " " + sc.next();
							address = address + " " + sc.next();
							System.out.println("City:");
							city = sc.next();
							System.out.println("State:");
							state = sc.next();
							System.out.println("Phone Number:");
							phoneNumber = sc.next();
							userDAO.createUser(username, password, firstName, lastName, address, city, state,
									phoneNumber);
							break;
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				// Invalid Input
			} else {
				System.out.println("Invalid Input, Try Again!");
			}
		}
	}
}
