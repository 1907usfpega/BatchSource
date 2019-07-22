package com.revature.questions;

/*Q1. Perform a bubble sort on the following integer array:
 *   1,0,5,6,3,2,3,7,9,8,4
 */
public class Q1 {

	static int[] array = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };

	public static String bubbleSort() {

		// Set # of iterations
		int numIterations = array.length / 2;
		while (numIterations > 0) {

			// navigate through array
			for (int i = 0; i < array.length - 1; i++) {
				// compare numbers
				if (array[i] > array[i + 1]) {
					// swap
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
			numIterations--;
		}
		return printArray();
	}

	private static String printArray() {
		String myArray = "";
		for (int i = 0; i < array.length; i++) {
			//format to display
			myArray += ("\n{[" + i + "] ->" + array[i] + "}");
		}
		System.out.println(myArray);
		return myArray;
	}

}
