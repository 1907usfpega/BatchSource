package com.revature.assignment1;

/**
 * Assignment #1 Question 12
 *Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers
 *from the array. Use the enhanced FOR loop for printing out the numbers.
 * 
 * @author Kyle Kolstad
 *
 * 
 */
public class EnhancedForLoop {
	
	//Data Variables
	private int [] array;
	
	/**
	 * Default Constructor
	 */
	public EnhancedForLoop() {	
		System.out.println("EnhancedForLoop Object Created!");
	}

	/**
	 * 
	 * @param numberStart
	 * @param numberEnd
	 */
	public void createArray(int numberStart, int numberEnd) { 
		array = new int[(numberEnd - numberStart) + 1]; //array size is set to the number of elements between the specified last number and first number plus one
		for(int i = 0; i < array.length; i++) {
			array[i] = numberStart; 
			numberStart++;
		}	
	}
	
	/**
	 * 
	 */
	public void printEvenNumbers() {
		for (int number : array) {
			if(number % 2 == 0 && number != 0) { //if divisible by 2 and the number is not 0 then the number is even and will be printed to the console
				System.out.println(number);
			}
		}
	}
}
