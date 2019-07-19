package com.revature.arrays;

import java.util.Arrays;

public class FunWithArrays {
	public static void main(String[] args) {
		int s = 7;
		int[] myArray = new int[s];
		// int myArray[] also works.
		int[] chaos = { 1, 2, 3, 9, 82, 79, 69, 420, 1337 };
		System.out.println(chaos[1]);
		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = i * 8;
			System.out.println(i + " is " + myArray[i]);
		}
		for(int in : chaos) {
			System.out.print(in + "  ");
		}
		System.out.println(Arrays.toString(chaos));
	}
}
