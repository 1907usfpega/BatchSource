package com.revature.week1;

import java.util.ArrayList;

//Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.

public class Q9 {

	static ArrayList<Integer> numbers = new ArrayList<Integer>();
	static ArrayList <Integer> numberPrime = new ArrayList <Integer>();
	
	public static int isPrime() {
		//TODO
	}
	
	public static ArrayList <Integer> test() {
		for(int i=1;i <=100; i++) {
			numbers.add(i);
		}
		for (Integer integer: numbers) {
			if(isPrime(integer)) {
				numberPrime.add(integer);
			}
		}
	}
	
	
	
}
