package com.revature.questions;

/*Q6. Write a program to determine if an integer is even 
 * without using the modulus operator (%)*/
public class Q6 {

	public static boolean isEven(int x) {
		int y = x / 2;

		if (x == y * 2) {
			System.out.println(x + " is even.");
			return true;
		}
		System.out.println(x + " is odd.");
		return false;
	}
}