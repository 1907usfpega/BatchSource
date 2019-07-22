package com.revature.hw1;

public class FactorialExample {

	public static void main(String[] args) {
		int i = 1;
		int fact = 1;
		int number = 5;// It is the number to calculate factorial    

		for (i = 1; i <= number; i++) {
			fact = fact * i;
		}
		System.out.println("Factorial of " + number + " is: " + fact);
		// TODO Auto-generated method stub

	}

}
