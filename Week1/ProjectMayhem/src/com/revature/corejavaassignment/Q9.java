package com.revature.corejavaassignment;

import java.util.ArrayList;

public class Q9 {

	public Q9() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q9 **********\n");
		ArrayList allNums = new ArrayList();
		ArrayList<Integer> primeNums = new ArrayList();
		for(int i = 1; i <=100; i++) {
			allNums.add(i);
			primeNums.add(i);
		}
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
		System.out.println("Prime numbers 1 - 100:\n" + primeNums);
		System.out.println("\n\n");
	}

}
