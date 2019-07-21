package com.revature.questions;

import java.util.Scanner;

/*Q17. Write a program that calculates the simple 
 * interest on the principal, rate of interest and number 
 * of years provided by the user. Enter principal, rate 
 * and time through the console using the Scanner class.
Interest = Principal* Rate* Time
*/

public class Q17 {

	// obj to receive user inputs
	private static Scanner sc = new Scanner(System.in);

	public static void calcInterest() {
		calcInterest(getRate(), getPrincipal(), getTime());
	}

	// implements the logic of calculation
	private static void calcInterest(double rate, double principal, double time) {
		double interest = principal * rate * time;
		System.out.println(interest);
	}

	// verify if user inputs a valid value
	private static double verifyInput(String s) {
		try {
			return Double.parseDouble(s);

		} catch (Exception e) {
			System.out.print("Input is not a number. " + "Please try again");
			return 0;
		}
	}

	private static double getRate() {
		double rate;
		do {
			System.out.print("Type the RATE: ");
			String s1 = sc.nextLine();
			rate = verifyInput(s1);
		} while (rate <= 0);
		return rate;
	}

	private static double getPrincipal() {
		double principal;
		do {
			System.out.print("Type the PRINCIPAL amount: ");
			String s1 = sc.nextLine();
			principal = verifyInput(s1);
		} while (principal <= 0);
		return principal;
	}

	private static double getTime() {
		double time;
		do {
			System.out.print("Type # of Years: ");
			String s1 = sc.nextLine();
			time = verifyInput(s1);
		} while (time <= 0);
		return time;
	}
}
