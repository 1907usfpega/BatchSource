package com.revature.assignment1;

/**
 * Assignment #1 Question 16
 *Write a program to display the number of characters for a string input. The string should be
 *entered as a command line argument using (String [ ] args).
 * 
 * @author Kyle Kolstad
 *
 * 
 */
public class StringInput {

	public StringInput() {
		
	}
	
	public void displayNumberOfChar(String args) {
		System.out.println("Number of Characters in " + args + " is: " + args.length());
	}
}
