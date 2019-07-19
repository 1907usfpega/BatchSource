package com.revature.driver;

public class Question6 {
	protected void run(String even) {
				
		System.out.println("Solution: " + "Is " + even + " an even number? " + isIntEven(even));
		
	}
	private static boolean isIntEven(String n) {
		if(validInput(n)) {
		return (int) Double.parseDouble(n)/2 == Double.parseDouble(n)/2 ? true:false;
		}
		return false;
	}
	protected void prompt() {
		System.out.println("Question 6: Please enter an integer to check if it is EVEN");
	}
	protected static boolean validInput(String s) {
		try {
			double a = Double.parseDouble(s);
			if (a > -1) {
				return true;
			} else {
				System.out.println("Input is not valid");
			}
		} catch (NumberFormatException e) {
			System.out.println("Input is not valid");
		}
		return false;
	}
}
