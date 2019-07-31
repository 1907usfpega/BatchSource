package driver;

import java.sql.SQLException;
import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import db.daoImpl.*;

	public class Driver implements Serializable {
			/**
			 * 
			 */
			private static final long serialVersionUID = -7198392058698727403L;

			public static void main(String[] args) {
				String username, password, option, name,accountnum;
				int phoneNumber,balance,userid;
		
				//ArrayList<Customer> customers = new ArrayList<Customer>();
				AdmindaoImpl admin = new AdmindaoImpl(); // Administrator Object created to test Administrator interaction
				UserDaoImpl user = new UserDaoImpl(); // Employee Object created to test Employee interaction
				Scanner sc = new Scanner(System.in);
				
				// create a customer object
				// define that customers username, password and personal info
				// Mark the account as pending for approval or denial
				// store that object into an ArrayList that can be accessed or modified by an
				// Employee or Admin
				/**
				 * Customer Portal
				 */

				// System.out.println("What Action Would You Like To Perform?....\nEnter 1 to
				// Login.\nEnter 2 to Create An Account.");

				System.out.println(
						"What Action Would You Like To Perform?....\nEnter 1 to Login.\nEnter 2 to Create An Account");

				option = sc.nextLine();
				boolean keepGoing = true;
				while (keepGoing) {
					// Log In
					if (option.equals("1")) {
						while (keepGoing) {
							System.out.println(
									"What Action Would You Like To Perform?....\nEnter 1 for admin  Login.\nEnter 2 for user Login.");
							switch (sc.nextInt()) {
							case 1: { // User Admin
								while (keepGoing) {
									System.out.println(
											"What Action Would You Like To Perform?....\nEnter 1 to create Users .\nEnter 2 to delete users .\nEnter 3 to have list of Users \nEnter to Log Out.");
									switch (sc.nextInt()) {
									case 1: { // to create Users 
								
										System.out.println("Enter Username!");
										 String username1 = sc.nextLine(); // stores the username
										System.out.println("Enter Password!");
										  String password1 = sc.nextLine(); // Stores the password
										try {
											admin.CreateUser(username1, password1);
											} catch (SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											
										
										}
										break;
									}
									case 2: { // delete  Users 
										
										System.out.println("Enter userid!");
										username=sc.nextLine();
										try {
										admin.deleteUser(username);
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										break;
									}}
									case 3: { // Update Users 
										
										System.out.println("Enter userid!");
										
										//admin.updateUser(user);
										break;
									}
									case 4: { //list of Users
										try {
										admin.listviewUser();
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										break;
									}}
									case 5: { //Log Out
										System.out.println("Logging Out...Goodbye!");
										keepGoing = false;
										break;
									}
									}
								}
								break;
							}
							
							case 3: { // User login
								while (keepGoing) {
									System.out.println(
											"What Action Would You Like To Perform?....\nEnter 1 To Check out your  balance  .\nEnter 2 To update .\nEnter 3 To Log Out.");
									switch (sc.nextInt()) {
									case 1: { // Approve/Deny Application
										// insert code here to check for objects that are not yet
										// approved****************************************************
										while (keepGoing) {
											System.out.println(
													"What Action Would You Like To Perform?....\nEnter 1 To create account  .\nEnter 2 To view balance  .\nEnter 3 To delete .\\nEnter 4 To Logout.");
											switch (sc.nextInt()) {
											
											case 1: { // create account 
												System.out.println("Enter userid!");
												username=sc.nextLine();
												accountnum=sc.nextLine();
												balance =sc.nextInt();
												
												try {
												user.CreateUser(accountnum, balance, username);
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
											
												break;
											}
												}
											
											case 2: { // View balance 
												System.out.println("Enter userid!");
												username=sc.nextLine();
												try {
												user.Viewaccountbalance(username);
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
											
												break;
											}
												}
											case 3: { // delete account
												System.out.println("Enter userid!");
												username=sc.nextLine();
												try {
												user.deleteUser(username);
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
												break;
											}
											case 4: { // Log Out
												System.out.println("Logging Out...Goodbye!");
												keepGoing = false;
												break;
											}
											}
										}
										break;
									}
									
									case 3: {
										System.out.println("Logging Out...Goodbye!");
										keepGoing = false;
										break;
									}
									}
								}
								break;
							}
							}
						}
						// register  Account
					} else if (option.equals("2")) { // If 2 is input then the following code is ran to create a customer
														// account
						System.out.println("Enter Username!");
						 username = sc.nextLine(); // stores the username
						System.out.println("Enter Password!");
						  password = sc.nextLine(); // Stores the password
						try {
							user.registerUser(username, password);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
						break;
						// Invalid Input
					} else {
						System.out.println(
								"Invalid Input, Try Again! What Action Would You Like To Perform?....\nEnter 1 to Login.\nEnter 2 to Create An Account.");
						option = sc.nextLine();
					}
				}
			}

		}
