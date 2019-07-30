package com.revature.assignment1;

import java.util.ArrayList;

/**
 * Assignment #1 Question 19
 *Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all the
 *even numbers up and display the result. Add all the odd numbers up and display the result.
 *Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
 * 
 * @author Kyle Kolstad
 *
 * 
 */
public class IntegerArrayList {
	
	//Data Variables
	private boolean isPrime;
	private int evenNumbers, oddNumbers;
	
	/**
	 * Default Constructor
	 */
	public IntegerArrayList() {
		System.out.println("IntegerArrayList Object Created!");
	}
	
	/**
	 * 
	 * @param arrayList
	 */
	public void displayArrayList(ArrayList<Integer> arrayList) {
		for(int element : arrayList) {
			System.out.print(element + " ");
		}
		System.out.print("\n");
	}
	
	/**
	 * 
	 * @param arrayList
	 */
	public void addEvenNumbers(ArrayList<Integer> arrayList) {
		for(int element: arrayList) {
			if (element % 2 == 0) {
				System.out.print(element + " ");
				evenNumbers = evenNumbers + element;
			} 
		}
		System.out.println("\nEven Number Sum: " + evenNumbers);
	}
	
	/**
	 * 
	 * @param arrayList
	 */
	public void addOddNumbers(ArrayList<Integer> arrayList) {
		for(int element: arrayList) {
			if (!(element % 2 == 0)) {
				System.out.print(element + " ");
				oddNumbers = oddNumbers + element;
			} 
		}
		System.out.println("\nOdd Number Sum: " + oddNumbers);
	}
	
	/**
	 * 
	 * @param arrayList
	 * @return
	 */
	public ArrayList<Integer> removePrimeNumbers(ArrayList<Integer> arrayList){
		int size = arrayList.size();
		for(int i = 0; i < size; i++) {
			if (arrayList.get(i) <= 1) { //prime numbers are positive so they cannot be negative numbers. Also 0 or 1 can't be prime numbers because their only factors are themselves 
				isPrime = false;
			} else if (arrayList.get(i) == 2){ //2 is the only even number that has itself and 1 as its factors making it a prime number
				isPrime = true;
			} else {
				for(int j = 2; j < arrayList.get(i); j++) { 
					if(arrayList.get(i) % j == 0) { //Modulus Operator checks to see if a number has a remainder.  If there is no remainder the number is not prime.
						isPrime = false;
						break;//breaks loop if there is a remainder of 0 which indicates the number is not prime. 
					} else {
						isPrime = true;
					}
				}
			}
			if(isPrime == true) {
				arrayList.remove(i);
				size--;
				i--;
			}
		}	
		return arrayList;	
	}
}
