package com.revature.driver;


import java.sql.SQLException;
import java.util.Scanner;

import com.revature.admin.Admin;
import com.revature.user.User;



public class Driver {
	
	
	public static void main(String[] args) {		
		start();
	}
	
	
	
	public static void start() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println(
				"      # ######  ######   #####     ######                                                 #                      \r\n" + 
				"      # #     # #     # #     #    #     #   ##   #    # #    #     ####  ######          #   ##   #    #   ##   \r\n" + 
				"      # #     # #     # #          #     #  #  #  ##   # #   #     #    # #               #  #  #  #    #  #  #  \r\n" + 
				"      # #     # ######  #          ######  #    # # #  # ####      #    # #####           # #    # #    # #    # \r\n" + 
				"#     # #     # #     # #          #     # ###### #  # # #  #      #    # #         #     # ###### #    # ###### \r\n" + 
				"#     # #     # #     # #     #    #     # #    # #   ## #   #     #    # #         #     # #    #  #  #  #    # \r\n" + 
				" #####  ######  ######   #####     ######  #    # #    # #    #     ####  #          #####  #    #   ##   #    #");
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------");
		System.out.println("Your login choices: ");
		System.out.println(" ");
		System.out.println("1. I am a Bank Admin");
		System.out.println("--------------------");
		System.out.println("2. I am a New/Existing User");
		System.out.println("----------------------------");
		System.out.println("3. Exit");
		String response = keyboard.nextLine();
		
		try {
			if(response.equals("1")) {
				new Admin().start();
			} else if(response.equals("2")) {
				new User().start();
			}
			
			keyboard.close();
			stop();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	
	public static void stop() {
		System.out.println("--------------------------------------------------------------------------------------------------------------------");
		System.out.println("Thank you for your business and have a nice day.");
		System.out.println(" ");
		System.out.println(
				"      # ######  ######   #####     ######                                                 #                      \r\n" + 
				"      # #     # #     # #     #    #     #   ##   #    # #    #     ####  ######          #   ##   #    #   ##   \r\n" + 
				"      # #     # #     # #          #     #  #  #  ##   # #   #     #    # #               #  #  #  #    #  #  #  \r\n" + 
				"      # #     # ######  #          ######  #    # # #  # ####      #    # #####           # #    # #    # #    # \r\n" + 
				"#     # #     # #     # #          #     # ###### #  # # #  #      #    # #         #     # ###### #    # ###### \r\n" + 
				"#     # #     # #     # #     #    #     # #    # #   ## #   #     #    # #         #     # #    #  #  #  #    # \r\n" + 
				" #####  ######  ######   #####     ######  #    # #    # #    #     ####  #          #####  #    #   ##   #    #");
	}

}
