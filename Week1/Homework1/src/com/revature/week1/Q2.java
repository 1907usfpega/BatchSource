package com.revature.week1;

//Write a program to display the first 25 Fibonacci numbers beginning at 0.

/* first 25 Fibonacci numbers beginning at 0
 * initialize the first two numbers starting at 0.
 * loop 25 times?
 * message to log i.
 * at some point, the 1st variable will equal to the 2nd variable, 2nd variable will be equal
 * to the third variable, and the third variable will be the sum of the 1st and 2nd variables.
 */
public class Q2 {
	static int a = 0;
	static int b = 1;
	static int c;

	
	public static int displayNum() {
		System.out.println(a);
		System.out.println(b);

		for (int i = 0; i < 23; i++) {
			c = a + b;
			System.out.println(c);
			a = b;
			b = c;
		}
		return c;

	}

}
