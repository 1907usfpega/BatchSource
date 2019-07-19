package com.revature.questions;

import java.util.Arrays;

public class Question1 {
	static boolean swapMade = false;
	static int cache;
	
	public static int[] doTask(int[] ints) {
		
		swapMade = false;
		for (int i = 0; i < ints.length-1; i++) {
			if(ints[i]>ints[i+1]) {
				cache = ints[i];
				ints[i] = ints[i+1];
				ints[i+1] = cache;
				System.out.println(i + " swapped with " + (i+1));
				swapMade = true;
			}
		}
		System.out.println("current array is: " + Arrays.toString(ints));
		if(!swapMade) {
			System.out.println("finished");
			return ints;
		}else {
			return doTask(ints);
		}
	}
}
