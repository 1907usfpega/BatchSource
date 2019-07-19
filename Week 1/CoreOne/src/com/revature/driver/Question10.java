package com.revature.driver;

public class Question10 {

	protected double getMin(String one, String two) {
		if (validInput(one) && validInput(two)) {
			return Double.parseDouble(one) < Double.parseDouble(two) ? Double.parseDouble(one) : Double.parseDouble(two);
		}
		return -1;
	}

	protected void prompt() {
		System.out.println("Question 10: type 1st number");

	}
	protected void prompt2() {
		System.out.println("Question 10: type 2nd number");	
	}

	protected static boolean validInput(String s) {
		try {
			Double.parseDouble(s);
			return true;
			
		} catch (NumberFormatException e) {
			System.out.println("Input is not valid. Returning -1");
		}
		return false;
	}

}
