package com.revature.questions;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

public class Question19 {

	static ArrayList<Integer> ints = new ArrayList<Integer>();
	static ArrayList<Integer> evens = new ArrayList<Integer>();
	static ArrayList<Integer> odds = new ArrayList<Integer>();
	static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static void doTask() {

		for (int i = 0; i < 10; i++) {
			ints.add(i + 1);
		}
		System.out.println("The Array now includes: ");
		for (Integer integer : ints) {
			System.out.print(integer + ", ");
		}
		createEvensAndOdds();
		System.out.println("Even numbers are: " + evens + ". Added together, their sum is " + addEmUp(evens));
		System.out.println("Odd numbers are: " + odds + ". Added together, their sum is " + addEmUp(odds));
		System.out.println("Prime numbers are: " + primes);
		System.out.println("Original Array minus the primes is: " + differenceLists(ints, primes));
	}

	public static void createEvensAndOdds() {
		System.out.println("\n");
		boolean isPrime = true;
		for (Integer integer : ints) {
			if (integer % 2 == 0) { // create evens
				System.out.println(integer + " is even.");
				evens.add(integer);
			} else if (integer % 2 == 1) { // create odds
				System.out.println(integer + " is odd.");
				odds.add(integer);
			}

			if (integer == 1) { // create primes
				continue;
			} else if (integer == 2) {
				primes.add(integer);
				continue;
			}
			isPrime = true;
			for (Integer prime : primes) {
				if (integer % prime == 0) {
					System.out.println(integer + " is not a prime, as you can divide it by " + prime);
					isPrime = false;
				}
			}
			if (isPrime)
				primes.add(integer);
		}

	}

	public static ArrayList<Integer> differenceLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> tempList = (ArrayList<Integer>) list1.clone();
		for (Integer integer : list1) {
			if (list2.contains(integer))
				tempList.remove(integer);
		}
		return list1 = tempList;
	}

	public static Integer addEmUp(ArrayList<Integer> ints) {
		Integer sum = 0;
		for (Integer integer : ints) {
			sum += integer;
		}
		return sum;
	}

}
