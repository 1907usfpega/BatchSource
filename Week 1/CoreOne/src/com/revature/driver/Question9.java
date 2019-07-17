package com.revature.driver;

import java.util.ArrayList;

public class Question9 {
	protected void run() {
		System.out.println("Question 9:");
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 1; i < 101; i++) {
			nums.add(i);
		}
		System.out.print("Solution: ");
		printPrimes(nums);
	}
	
	private static void printPrimes(ArrayList<Integer> in) {
		for(int i: in) {
			if(isPrime(i)) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
	
	private static boolean isPrime(Integer a) {
		if (a == 1) {
			return false;
		}
		for(int i = 2; i < a/2; i++ ) {
			if(a%i == 0) {
				return false;
			}
		}
		return true;
	}
}
