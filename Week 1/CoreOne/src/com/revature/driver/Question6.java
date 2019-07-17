package com.revature.driver;

public class Question6 {
	protected void run(int even) {
				
		System.out.println("Solution: " + "Is " + even + " an even number? " + isIntEven(even));
		
	}
	private static boolean isIntEven(int n) {
		return n/2 == (double) n/2 ? true:false;
	}
	protected void prompt() {
		System.out.println("Question 6: Please enter an integer to check if it is EVEN");
	}
}
