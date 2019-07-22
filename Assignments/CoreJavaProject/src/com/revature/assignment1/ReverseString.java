package com.revature.assignment1;

/**
 * Assignment #1 Question 3
 * Reverse a string without using a temporary variable. Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
 * 
 * @author Kyle Kolstad
 *
 * 
 */
public class ReverseString {
	
	private String reverse = "This Is A String!";
	
	/**
	 * Default Constructor.
	 */
	public ReverseString() {
		System.out.println("ReverseString Object Created!");
	}
	
	/**
	 * 
	 */
	public void reverse() {
		for(int i = reverse.length() - 1; i >= 0; i--) {
			System.out.print(reverse.charAt(i));
		}
	}
}
