package com.revature.MoneyFolder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MoneyFolder {

	static Scanner sc = new Scanner(System.in);
	static String username = "";
	static String password = "";
	
	public static boolean login() {
	
		System.out.println("Enter your Username: ");
		username = sc.nextLine();
		// Find username in passwords file
		FileReader fr;
		BufferedReader br;
		String line;
		String un = "";
		String pw = "";
		try {
			fr = new FileReader("passwords.txt");
			br = new BufferedReader(fr);
			int j=0;
			while((line = br.readLine()) != null) {
				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == '|') {
						j = i;
						
						for (int k = 0; k < j; k++) {
							un = un + line.charAt(k);
						}						
						break;
					}
					
				}
				
				if (un.equals(username)) {
					for (int k = j + 1; k < line.length(); k++) {
						password = password + line.charAt(k);
					}
					break;
				}
				
				un = "";
				
			}
			
			if (!un.equals(username)) {
				br.close();
				System.out.println("Username not found.");
				return false;
			}
			
			br.close();
			
//			System.out.println("Username: " + un + "\nPassword: " + password);
			
			System.out.println("Enter your Password: ");
			int i = 0;
			while (i < 3) {
				pw = sc.nextLine();
				if(!pw.equals(password)) {
					System.out.println("Incorrect password.\n\nEnter your Password: ");
				} else {
					break;
				}
				i++;
				
				if (i == 3) {
					System.out.println("Login Failed");
					return false;
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Login Successful");
		return true;
		
	}
	
	public static boolean newUser() {
		
		String userName;
		String password;
		String newCustomer;
		String verifyPassword;
		

		System.out.print("Welcome to the Money Folder Electronic Banking System!\n\nAre you a new customer? (y/n): ");
		
		// Determining if a customer is new
				do {
					newCustomer = sc.nextLine();
					newCustomer = newCustomer.toLowerCase();
					// New Customer
					if (newCustomer.equals("y")) {
						System.out.print("Please enter a username: ");
						userName = sc.nextLine();
						System.out.print("Please enter a password: ");
						password = sc.nextLine();
						System.out.print("Please re-enter your password: ");
						verifyPassword = sc.nextLine();
						while (!password.equals(verifyPassword)) {
							System.out.print("Passwords did not match.\n\nPlease enter a password: ");
							password = sc.nextLine();
							System.out.print("Please re-enter your password: ");
							verifyPassword = sc.nextLine();
						}
						try {
							FileReader reader = new FileReader("passwords.txt");
							BufferedReader br = new BufferedReader(reader);
							String contents = "";
							String str;
							
							while((str = br.readLine()) != null) {
								contents = str + "\n";
							}
							
							br.close();
							
							FileWriter passwords = new FileWriter("passwords.txt");
							PrintWriter pw = new PrintWriter(passwords);
							pw.println(contents + userName + "|" + password);
							pw.close();
						} catch (IOException e) {
							System.out.println("ERROR!");
						}
						System.out.println("Account has been successfully created, you will now be automatically logged in.");
						username = userName;
						return true;
					// Checking for valid input
					} else if (!newCustomer.equals("n")) {
						System.out.println("Invalid input, please enter y or n");
					}
				} while (!newCustomer.equals("y") && !newCustomer.equals("n")); // Start over if invalid input, if customer is not new they
																			  // can proceed to the log in stage.
		System.out.println("Redirecting you to the log in screen.\n");
		return false;
	}
	
	public static void main(String[] args) {
		boolean loginSuccessful = false;
		
		boolean newUser = newUser();
		if(!newUser) {
			loginSuccessful = login();
			if (!loginSuccessful) {
				return;
			}
		}
		
		sc.close();
	}

}
