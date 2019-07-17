package com.revature.driver;

public class Question4 {

	protected void run(int n) {	
		System.out.println("Solution: " + n + "! = " + factorial(n));
	}
	
	private static int factorial(int n) {
		return n == 1 ? 1:n * factorial(n-1);
	}
	protected void prompt() {
		System.out.println("Question 4: Please enter a integer value.");
	}
}
