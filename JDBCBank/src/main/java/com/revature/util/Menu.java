package com.revature.util;

import java.util.Scanner;

public class Menu {
	/*
	 * Should be point of entry for customers & Employees/Admins. Superclass to handle those elements.
	 */
	
	public static void home()
	{
		System.out.println("Welcome to the JDBC Bank. What can we do for you today?");
		System.out.println();
		System.out.println("1. Login \n2. Register \n3. Admin login. \n4. Log off");

		Scanner in = new Scanner(System.in);
		int sel = in.nextInt();

		switch (sel)
		{
			case 1: 
			{
				//Go to customer menu.
				CustomerMenu.logon();
				break;
			}
			case 2:
			{
				//Go to account creation.
				NewCustomerMenu.getUserParams();
				break;
			}
			case 3:
			{
				//Go to admin menu.
				break;
			}
			case 4:
			{
				in.close();
				System.out.println("Thank you for your patronage. Have a great day!");
				System.exit(0);
			}
			default:
				System.out.println("Invalid selection. Please try again.");
				home();
		}
		

	}

	public static void main(String[] args) {
		
		home();

	}

}
