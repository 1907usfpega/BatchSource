package com.revature.work;

import java.util.ArrayList;

public class Primes {

	public static ArrayList<Integer> printPrime() {
		//fills an array list
		ArrayList<Integer> a=new ArrayList<Integer>();
		for(int i=1;i<=100;i++) {
			a.add(i);
		}
		boolean prime=true;
		//checks which numbers are prime
		for (int i:a) {
			prime=true;
			for (int j=2;j<i;j++) {
				if(i%j==0) {
					prime=false;
					break;
				}
			}
			//prints the prime numbers
			if (prime) {
				System.out.print(i+" ");
			}
		}
		//returns the array
		return a;
	}

}
