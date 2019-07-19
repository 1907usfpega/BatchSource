package com.revature.questions;

import java.util.ArrayList;

public class Question9 {
	static ArrayList<Integer> something = new ArrayList<Integer>();

	public static ArrayList<Integer> doTask() {

		for (int i = 1; i <= 100; i++) {
			something.add(i);
		}
		for (Integer integer : something) {
			isPrime(integer);
		}
		return something;
	}

	public static boolean isPrime(Integer i) {
		for (int j = 2; j < i / 2; j++) {
			if (i % j == 0) {
				System.out.println("false" + i);
				return false;
			}
		}
		System.out.println("true" + i);
		return true;
		
	}

}
