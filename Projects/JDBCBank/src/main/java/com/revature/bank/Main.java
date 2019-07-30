package com.revature.bank;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String username, password;
		UserDAO userDAO = new UserDAO();
		Scanner sc = new Scanner(System.in);
		List<User> users = new ArrayList<User>(); //ArrayList to work with user objects
		//System.out.println(
				//"What Action Would You Like To Perform?....\nEnter 1 to Login.\nEnter 2 to Create An Account.");
		//switch (sc.nextInt()) {

		//case 1: {
			//break;
		//}
		//case 2: {
			//System.out.println("Enter Username!");
			//username = sc.nextLine(); // stores the username
			//System.out.println("Enter Password!");
			//password = sc.nextLine(); // Stores the password
			try {
				userDAO.createUser("Tester", "tester", "FNTest", "LNTest", "100 Address Test", "City Test", "State Test","Phone Test");
				System.out.println("\"test\"");
				users = userDAO.getAll();
				System.out.println(userDAO.getAll());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
			//break;
		//}
	}
}
