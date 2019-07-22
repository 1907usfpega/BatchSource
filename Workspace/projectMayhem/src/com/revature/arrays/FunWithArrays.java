package com.revature.arrays;

import java.util.Arrays;

//download notes here
public class FunWithArrays {

	public static void main(String[] args) {
		int s = 7;
		
		int [] myArray = new int [s];
		//int myArray[] = new int [s]; <--still ok
		//int array w/ hard coded values
		
		int [] chaos = {3, 5,6,4,5,6,77,333};
		System.out.println(chaos[1]);
		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = i * 5;
			//System.out.println(i + " element is " + myArray[i]);	
		}
		
		//for each
		for (int i:chaos) {
			System.out.println(i);
		}
		
		//Arrays class
		
		System.out.println(Arrays.toString(chaos));
		Arrays.sort(chaos);
		System.out.println(Arrays.toString(chaos));

	}

}
