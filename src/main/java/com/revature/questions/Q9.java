package com.revature.questions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.utils.MyFunctions;

/*Create an ArrayList which stores numbers from 1 to 100 
 * and prints out all the prime numbers to the console
*/
public class Q9 {

	public static void printPrime() {
		List<Integer> myArray = new ArrayList<Integer>();

		for (int i = 0; i < 100; i++) {
			myArray.add(i + 1);
		}

		System.out.print("\nPrime Numbers: ");
		Iterator<Integer> itr = myArray.iterator();

		while (itr.hasNext()) {
			int element = itr.next();
			// CHECK PRIMES
			if (MyFunctions.isPrime(element)&& element != 1) {
				System.out.print(element + " ");
			}
		}

	}

}
