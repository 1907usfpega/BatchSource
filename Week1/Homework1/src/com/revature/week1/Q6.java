package com.revature.week1;

//Write a program to determine if an integer is even without using the modulus operator (%)
public class Q6 {
	public static boolean isItEven(int x) {

		boolean isItEven = true;

		for (int i = 1; i < x; i++) {
			isItEven = !isItEven;


		}
		return isItEven;

	}

}
