package com.revature.driver;

public class Question4 {
	
	//Prints out factorial 
	public void run(String n) {
		if (validInput(n)) {
			System.out.println("Solution: " + n + "! = " + factorial((int) Double.parseDouble(n)));
		}
	}
	//Computes factorial
	public int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n == 1 ? 1 : n * factorial(n - 1);
	}
	//prompt
	protected void prompt() {
		System.out.println("Question 4: Please enter a integer value.");
	}
	//Checks if string is a positive integer
	protected boolean validInput(String s) {
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
