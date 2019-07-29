package com.revature.corejavaassignment;

import java.util.ArrayList;
import java.util.Arrays;

public class Q9 {

	public Q9() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q9 **********\n");
		ArrayList allNums = new ArrayList<Integer>();
		ArrayList<Integer> primeNums = new ArrayList<Integer>();
		for(int i = 1; i <=100; i++) {
			allNums.add(i);
			primeNums.add(i);
		}
		ArrayList<Integer> correct = new ArrayList<Integer>();
		correct.addAll(Arrays.asList(new Integer[] 
			{1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 
			41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97}));
		
		System.out.println("All numbers 1 - 100:\n" + allNums);
		for(int i = 2; i < 100; i++) {
			for(int j = (2 * i) - 1; j < 100; j += i) {
				primeNums.set(j, 101);
			}
			
		}
		for(int i = 99; i >= 0; i--) {
			if(primeNums.get(i) > 100)
				primeNums.remove(i);
		}
		Q9Test tester = new Q9Test(primeNums, correct);
		System.out.println("Prime numbers 1 - 100:\n" + primeNums);
		System.out.println("\n\n");
	}

}
