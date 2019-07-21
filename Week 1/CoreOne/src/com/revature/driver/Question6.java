package com.revature.driver;

public class Question6 {
	public void run(String even) {

		System.out.println("Solution: " + "Is " + even + " an even number? " + isIntEven(even));

	}

	// checks if int is even
	public static boolean isIntEven(String n) {
		if (validInput(n)) {
			return (int) Double.parseDouble(n) / 2 == Double.parseDouble(n) / 2 ? true : false;
		}
		return false;
	}

	protected void prompt() {
		System.out.println("Question 6: Please enter an integer to check if it is EVEN");
	}

	// check if string is a valid number
	protected static boolean validInput(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("Input is not valid");
		}
		return false;
	}
}
