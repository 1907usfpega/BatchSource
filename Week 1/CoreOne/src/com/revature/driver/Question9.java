package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

public class Question9 {

	protected void run() {
		System.out.println("Question 9:");
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i < 101; i++) {
			nums.add(i);
		}
		System.out.print("Solution: ");
		System.out.println(getPrimes(nums));
	}

	// returns primes from list of ints
	public static String getPrimes(List<Integer> ali) {
		StringBuilder sb = new StringBuilder();
		for (int i : ali) {
			if (isPrime(i)) {
				sb.append(i + " ");
			}
		}
		sb.append("\n");
		return sb.toString().trim();
	}

	// checks if integer is prime
	private static boolean isPrime(Integer a) {
		if (a == 1) {
			return false;
		}
		for (int i = 2; i < a / 2; i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}
}
