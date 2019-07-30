package com.revature.driver;
import java.io.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import com.revature.beans.Customer;
import com.revature.daoimpl.CustomerDaoImpl;

public class Driver {
	public static String choice;
	public static String usrname;
	public static String pssword;
public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		CustomerDaoImpl cust = new CustomerDaoImpl();
		try {
			System.out.println();
			System.out.println("                  W e l c o m e    t o    Iberian   B a n k i n g   ");
			System.out.println("              -------------------------------------------------------");
			System.out.println("              -------------------------------------------------------");
			System.out.println();
			boolean open = true;
			while(open) {
				System.out.println("                  BANKING                        ACCOUNT(new)  ");
				System.out.println();
				System.out.println();
				System.out.println("  Please choose from the above:  ");
				choice = scan.nextLine();
				switch(choice.toUpperCase()) {
					case "BANKING":
						Scanner scanner3 = new Scanner(System.in);
						System.out.print("  Please enter username: ");
						String usname = scanner3.nextLine();
						System.out.println("  Enter password:");
						String psword = scanner3.nextLine();
						List<Customer> c=cust.getCustomer(usname);
							break;
					case "ACCOUNT":
						System.out.println("  Please complete an application.");
						System.out.println("  Enter your last name: ");
						String lastName = scan.nextLine();
						System.out.println("  Enter your first name: ");
						String FirstName = scan.nextLine();
						System.out.println("  Thank you "+ FirstName +" "+ lastName +", the minimum deposit is $300.00.\n  Please enter the amount of your initial deposit.");
					    int initialDep = scan.nextInt();
					    System.out.println(FirstName+" your initial deposit is: "+initialDep);
					    System.out.println("  please enter a username: ");
					    Scanner sc = new Scanner(System.in);
					    String g = sc.nextLine();
					    System.out.println("  please enter a password:  ");
					    Scanner p = new Scanner(System.in);
					    String pssword = p.nextLine();
					    Random rnd = new Random();
					    int accNumber = rnd.nextInt(50);
					    accNumber  = rnd.nextInt(999999);
					    cust.createCustomer(accNumber, FirstName, initialDep,lastName,g,pssword);
					    System.out.println("  THANK YOU! for opening a account with us "+lastName);
					    cust.getCustomer(g);
					    System.out.println("");
					    System.out.println("    ============================================== \n ");
						break;
						  
						}
						scan=new Scanner(System.in);
						}	
				
		} catch (SQLException e) {}
}}