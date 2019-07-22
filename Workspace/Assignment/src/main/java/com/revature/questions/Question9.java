package com.revature.questions;

import java.util.ArrayList;

public class Question9 {
	static ArrayList<Integer> numberArray = new ArrayList<Integer>();
	static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static ArrayList<Integer> doTask() {

		for (int i = 1; i <= 100; i++) {
			numberArray.add(i);
		}
		for (Integer integer : numberArray) {
			if(isPrime(integer)) {								//primes get added to the primes-ArrayList
				primes.add(integer);
			}
		}
		System.out.println("primes are: " + primes);
		return primes;
	}

	public static boolean isPrime(Integer i) {					// it the number is dividable by any other number below it, without a rest, it is not a prime 
		for (int j = 2; j < i / 2; j++) {
			if (i % j == 0) {
				System.out.println("no prime: " + i);
				return false;
			}
		}
		System.out.println("prime: " + i);
		return true;
		
	}

}
