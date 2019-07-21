package com.revature.driver;

public class Question16 {

	public static void main(String[] args) {
		int c = 0;
		for (String a : args) {
			c += a.length();
		}
		System.out.println("Question 16: \nSolution:");
		System.out.println(c);
	}

	// returns the addes legths for all the strings in
	// a string[]
	public int length(String[] test) {
		int c = 0;
		for (String a : test) {
			c += a.length();
		}
		return c;
	}

}
