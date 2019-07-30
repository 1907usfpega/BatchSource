package com.revature.assignment1;

/**
 * Assignment #1 Question 10 Find the minimum of two numbers using ternary
 * operators.
 * 
 * @author Kyle Kolstad
 *
 *         The ternary operator is an operator that takes three arguments. The
 *         first argument is a comparison argument, the second is the result
 *         upon a true comparison, and the third is the result upon a false
 *         comparison.
 */
public class TernaryOperators {

	/**
	 * Default Constructor
	 */
	public TernaryOperators() {
		System.out.println("TernaryOperators Object Created!");
	}

	/**
	 * Method that checks for the minimum value of 2 integers.
	 * 
	 * @param value1
	 * @param value2
	 */
	public void findMinimum(int value1, int value2) {
		int minimum;
		minimum = value1 < value2 ? value1 : value2; // checks which number is smaller. If the statement (value1 <
														// value2) is true (?) then value1 is assigned, if it is false
														// (:) then value2 is assigned.
		System.out.println("Minimum of " + value1 + " and " + value2 + " = " + minimum);
	}

	/**
	 * Method that checks for the minimum value of 2 doubles.
	 * 
	 * @param value1
	 * @param value2
	 */
	public void findMinimum(double value1, double value2) {
		double minimum;
		minimum = value1 < value2 ? value1 : value2;
		System.out.println("Minimum of " + value1 + " and " + value2 + " = " + minimum);
	}
}
