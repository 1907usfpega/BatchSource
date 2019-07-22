package com.revature.questions;

/*Q2. Write a program to display the first 25 Fibonacci 
 * numbers beginning at 0.
 */
public class Q2 {

	public static String displayFibonacci() {
		// set initial values
		int prev = 0;
		int num = 0;
		int next = 1;

		int count = 0;

		String display = "";

		// using DO to execute one time printing 0
		do {
			display += num + " ";
			prev = num;
			num = next;
			// sum last two values to print next
			next = prev + num;

			count++;
		}
		// executes 25times
		while (count < 25);

		System.out.println("\n"+display);
		return display;

	}

}
