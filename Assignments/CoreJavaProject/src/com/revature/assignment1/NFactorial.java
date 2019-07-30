package com.revature.assignment1;

/**
 * Assignment #1 Question 4
 * Write a program to compute N factorial.
 * 
 * @author Kyle Kolstad
 *
 *
 */
public class NFactorial {

	private int factorial;
	/**
	 * Default Constructor.
	 */
	public NFactorial() {
		System.out.println("NFactorial Object Created!");
	}
	
	public int calculateNFactorial(int factorial) {
		this.factorial = 1;
		for(int i = factorial; i > 0; i--) {
				this.factorial = this.factorial * i;
		}
		return this.factorial;	
	}
}
