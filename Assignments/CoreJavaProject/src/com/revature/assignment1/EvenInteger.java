package com.revature.assignment1;

/**
 * Assignment #1 Question 6
 * Write a program to determine if an integer is even
 * without using the modulus operator (%)
 * 
 * @author Kyle Kolstad
 *
 * 
 */
public class EvenInteger {

	public EvenInteger() {

		System.out.println("EvenInteger Object Created!");
	}

	public void isEven(int number) {
		if (number != 0) {
			if (number % 2 == 0) {
				System.out.println("Number Is Even");
			} else {
				System.out.println("Number Is Odd!");
			}
		} else {
			System.out.println("You Entered 0, Please Input A Different Number!");
		}

	}

}
