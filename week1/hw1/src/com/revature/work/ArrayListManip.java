package com.revature.work;

import java.util.ArrayList;
import java.util.Iterator;

//manipulates an array list
public class ArrayListManip {
	public static ArrayList<Integer> ALManip() {
		ArrayList<Integer> a=new ArrayList<Integer>();
		for(int i=1;i<=10;i++) {
			a.add(i);
		}
		
		int b=0;
		boolean prime=true;
		
		//prints full list
		System.out.println("Full List: ");
		for(int i:a) {
			System.out.print(i+" ");
		}
		//adds up all evens
		for(int i:a) {
			if (i%2==0) {
				b+=i;
			}
		}
		System.out.println("\nSum of Evens: "+b);
		//adds up all odds
		b=0;
		for(int i:a) {
			if (i%2==1) {
				b+=i;
			}
		}
		System.out.println("Sum of Odds: "+b);
		//this for loop actually removes all the primes from a
		//even though it says its printing
		System.out.println("List Minus Primes: ");
		b=0;
		for (Iterator<Integer> itr = a.iterator(); itr.hasNext();) {
			Integer i = itr.next();
			prime=true;
			for (int j=2;j<i;j++) {
				if(i%j==0) {
					prime=false;
					break;
				}
			}
			if (prime) {
				itr.remove();
			}
		}
		//prints array list without prime numbers
		for(int i:a) {
			System.out.print(i+" ");
		}
		return a;
		
	}
}
