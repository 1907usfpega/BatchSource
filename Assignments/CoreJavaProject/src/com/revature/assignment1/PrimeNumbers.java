package com.revature.assignment1;

/**
 * Assignment #1 Question 9
 *Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime
 *numbers to the console.
 * 
 * @author Kyle Kolstad
 *
 * A prime number is a whole number greater than 1 whose only factors are 1 and itself.
 */
public class PrimeNumbers {
	
	// Data Variables
	private boolean isPrime;
	
	/**
	 * Default Constructor.
	 */
	public PrimeNumbers() {
		System.out.println("PrimeNumbers Object Created!");
	}
	
	/**
	 * Method that takes in a number as a parameter then checks to see if it is a prime number.
	 * 
	 * @param number
	 */
	public void checkForPrime(int number) {
		if (number <= 1) { //prime numbers are positive so they cannot be negative numbers. Also 0 or 1 can't be prime numbers because their only factors are themselves 
			isPrime = false;
		} else if (number == 2){ //2 is the only even number that that has itself and 1 as its factors
			isPrime = true;
		} else {
			for(int i = 2; i < number; i++) { 
				if(number % i == 0) { //Modulus Operator checks to see if a number has a remainder.  If there is no remainder the number is not prime.
					isPrime = false;
					break; //breaks loop if there is a remainder of 0 which indicates the number is not prime. 
				} else {
					isPrime = true; 
				}
			}
		}
		if(isPrime == true) {
			System.out.println(number + " is a prime number!");
		}
	}
}
