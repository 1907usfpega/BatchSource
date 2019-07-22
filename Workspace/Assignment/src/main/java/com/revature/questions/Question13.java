package com.revature.questions;

public class Question13 {

	public static boolean lastNumber = true;
	//continuous switching of 01010101010101, until the next line is not smaller than 5. Prints new lines as long as the length is smaller than 5
	public static void doTask() {
		int stringLength = 1;

		while (stringLength < 5) {
			for (int i = 1; i <= stringLength; i++) {
				System.out.print(nextInt());
			}
			System.out.println();
			stringLength++;
		}
		/*
		 * 0 0 0 10 1 2 101 4 4 0101 10 4
		 */
	}

	public static int nextInt() {
		lastNumber = !lastNumber;
		return (lastNumber) ? 1 : 0;
	}
}
