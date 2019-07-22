package com.revature.work;

import java.util.ArrayList;

public class Primes {

	public static ArrayList<Integer> printPrime() {
		ArrayList<Integer> a=new ArrayList<Integer>();
		for(int i=1;i<=100;i++) {
			a.add(i);
		}
		boolean prime=true;
		for (int i:a) {
			prime=true;
			for (int j=2;j<i;j++) {
				if(i%j==0) {
					prime=false;
					break;
				}
			}
			if (prime) {
				System.out.print(i+" ");
			}
		}
		return a;
	}

}
