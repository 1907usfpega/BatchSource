package com.revature.homework1;

import java.util.ArrayList;

public class Assignment19 {
	public static void main(String[] args) {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		Assignment9 obj9 = new Assignment9();

		for (int i = 0; i < 10; i++) {
			myList.add(i + 1);
		}

		System.out.println("My Array List " + myList);
		System.out.println("add evens " + addEvens(myList));
		System.out.println("add odds "+ addOdds(myList));
		//System.out.println("Prime Numbers Removed: " + removePrimes(myList));

		Assignment9.primeNumberCheck();

	}

	public static Integer addEvens(ArrayList<Integer> numbers) {
		Integer addedNums = 0;
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) % 2 == 0) {
				addedNums += numbers.get(i);

			}
		}

		return addedNums;
	}
	
	public static Integer addOdds(ArrayList<Integer> numbers) {
		Integer addedNums2 = 0;
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) % 2 != 0) {
				addedNums2 += numbers.get(i);

			}
		}

		return addedNums2;
	}

	/*
	 * public static ArrayList<Integer> removePrimes(ArrayList<Integer> allNumbers){
	 * 
	 * for(int i=0; i <allNumbers.size();i++) { for(int divisor = 2; divisor <=
	 * allNumbers.get(i)/2; divisor++) { if (allNumbers.get(i) % divisor == 0) {
	 * allNumbers.remove(i); }
	 * 
	 * } if(allNumber.get(i) ) } if(number ==1){ isPrime = false; } for(int divisor
	 * = 2; divisor <= number/2; divisor++ ){ if (number % divisor == 0){ isPrime =
	 * false; break; }
	 * 
	 * 
	 * 
	 * return allNumbers; }
	 */

}
