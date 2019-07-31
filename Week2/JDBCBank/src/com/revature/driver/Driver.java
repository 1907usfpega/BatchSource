package com.revature.driver;

import java.sql.SQLException;
import java.util.Scanner;

import methods.Admin;
import methods.User;


public class Driver {
	
	public static void main(String[] args) {		
		
		new Driver().start();
	}
	
	public void start() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to the New Bank of Java!");
		System.out.println("Choices: ");
		System.out.println("1. Bank Admin");
		System.out.println("2. User");
		String response = keyboard.nextLine();
		
		try {
			if(response.equals("1")) {
				new Admin().start();
			} else if(response.equals("2")) {
				new User().start();
			
			}
			
			keyboard.close();
			new Driver().stop();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	
	public void stop() {
		System.out.println("Thank you for your business. Have a nice day.");
	}

}