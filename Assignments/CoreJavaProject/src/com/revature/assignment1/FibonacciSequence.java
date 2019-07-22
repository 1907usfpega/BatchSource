package com.revature.assignment1;

import java.util.ArrayList;

/**
 * Assignment #1 Question 2
 * Write a program to display the first 25 Fibonacci numbers beginning at 0.
 * 
 * @author Kyle Kolstad
 *
 *
 */
public class FibonacciSequence {
	
	//Data Variables
	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	private int first = 0, second = 1;
	
	/**
	 * Default Constructor.
	 */
	public FibonacciSequence() {
		System.out.println("FibonacciSequence Object Created!");
	}
	
	/**
	 * Method used to calculate Fibonacci Sequence and to store the values in an ArrayList.
	 * @param number
	 */
	public void calculateSequence(int number) {
		int sum;
		for (int x = 0; x < number; x++) {
			arrayList.add(first);
			sum = first + second;
			first = second;
			second = sum;	
		}
	}
	
	/**
	 * Prints out the ArrayList to the console.
	 */
	public void printArrayList() {
		for (int i: arrayList) {
				System.out.print(i + " ");	
		}
	}
}