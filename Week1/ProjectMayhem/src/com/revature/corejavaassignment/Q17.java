package com.revature.corejavaassignment;
import java.util.Scanner;

public class Q17 {

	public Q17() {
		System.out.println("********** Q17 **********\n");
		Scanner userIn = new Scanner(System.in);
		System.out.println("Please enter principal amount.");
	    String principal = userIn.nextLine();
		//userIn = (System.in);
	    System.out.println("Please enter interest rate.");
		String rate = userIn.nextLine();
		//userIn = new Scanner(System.in);
		System.out.println("Please enter time frame.");
		String time = userIn.nextLine();
		double total = (Double.parseDouble(principal) * 
						(1 + (Double.parseDouble(rate) * 
						Double.parseDouble(time))));
		System.out.println("Total balance including "
				+ "principal amount + interest = " + total);
	}

}
