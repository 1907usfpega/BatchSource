package com.revature.arrays;

import java.util.Arrays;

public class FunWithArrays {

	public static void main(String[] args) {
		int s = 7;
		// int array with seven buckets
		int [] myArray = new int[s];
		// int myArray[] = new int[s]; <- still cool
		// int array with hard coded values
		int [] chaos = {3,5,3,2,34,4,5,69,3,827,3,54,53,6,57,67,4,4543,6,1253,23};
//		System.out.println(chaos[1]);
//		System.out.println(chaos);
		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = i*5;
//			System.out.println(i+ " element is " + myArray[i]);
		}
		
//		for (int i:chaos) {
//			System.out.println(i);
//		}
		
		System.out.println(Arrays.toString(chaos));
		Arrays.sort(chaos);
		System.out.println(Arrays.toString(chaos));
	}
	
}
