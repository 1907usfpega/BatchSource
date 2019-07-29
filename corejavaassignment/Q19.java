package com.revature.corejavaassignment;

import java.util.ArrayList;

public class Q19 {

	public Q19() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q19 **********\n");
		ArrayList<Integer> firstTen = new ArrayList();
		for(int i = 1; i <=10; i++)
			firstTen.add(i);
		System.out.println("Numbers 1 - 10:\n" + firstTen);

		int evenSum = 0;
		int oddSum = 0;
		for(int i = 0; i < 10; i++) {
			if(firstTen.get(i) % 2 == 0)
				evenSum += firstTen.get(i);
			else
				oddSum += firstTen.get(i);
		}
		Q19Test tester1 = new Q19Test(evenSum, 30);
		System.out.println("The sum of the even numbers = " + evenSum);
		Q19Test tester2 = new Q19Test(oddSum, 25);
		System.out.println("The sum of the odd numbers = " + oddSum);
		for(int i = 2; i < 10; i++) {
			for(int j = (2 * i) - 1; j < 10; j += i) {
				firstTen.set(j, 101);
			}
		}
		for(int i = 9; i >= 0; i--) {
			if(firstTen.get(i) > 10)
				firstTen.remove(i);
		}
		System.out.println("Prime Numbers 1 - 10:\n" + firstTen);
		System.out.println("\n\n");
	}

}
