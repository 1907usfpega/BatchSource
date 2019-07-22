package com.revature.hw1;

import java.util.ArrayList;
import java.util.Iterator;

public class Primes {

	public static String primesOneToOneHundred() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		String output = "";
		for (int i = 1; i < 101; i++) {
			al.add(i);
		}
		
		int number;
		int check;
		boolean isPrime = true;
		Iterator<Integer> itr = al.iterator();
		while (itr.hasNext()) {
			number = itr.next();
			for(int i = 2; i < number; i++) {
				check = number / i;
				if(number == check * i) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				output = output + number + ",";
			}
			isPrime = true;
		}
		output = Substring.substr(output, output.length()-1);
		return output;
	}

	
}
