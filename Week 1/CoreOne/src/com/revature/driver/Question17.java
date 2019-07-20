package com.revature.driver;

import java.util.Scanner;

public class Question17 {

	public static void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Question17: type your principal");
		String s = sc.nextLine();
		try {
			double p =Double.parseDouble(s);
			System.out.println("type interest rate in decimal format:");
			s= sc.nextLine();
			double i = Double.parseDouble(s);
			System.out.println("type number of years");
			s = sc.nextLine();
			double y = Double.parseDouble(s);
			System.out.println("your simple interest is: " + sInterest(p, i, y));
		} catch(NumberFormatException e) {
			System.out.println("Incorrect Value Typed! You get nothing! good day sir!");
		}
		
		sc.close();
	}

	public static double sInterest(double principal, double interest, double years) {
		return principal * interest * years;
	}
}
