package com.revature.corejavaassignment;

import java.util.ArrayList;

public class Q19 {

	public Q19() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q19 **********\n");
		ArrayList<Integer> firstTen = new ArrayList();
		System.out.println("Numbers 1 - 10:\n" + firstTen);

		int evenSum = 0;
		int oddSum = 0;
		for(int i = 0; i < 10; i++) {
			if(firstTen.get(i) % 2 == 0)
				evenSum += firstTen.get(i);
			else
				oddSum += firstTen.get(i);
		}
		System.out.println("The sum of the even numbers = " + evenSum);
		System.out.println("The sum of the odd numbers = " + oddSum);
		
		for(int i = 9; i >= 0; i--) {
			if(primeNums.get(i) > 100)
				primeNums.remove(i);
		}
	}

}
