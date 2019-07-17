package com.revature.driver;

public class Question1 {

	protected void run() {
		int[] arr = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int[] sorted = bubbleSort(arr);
		System.out.println("Question 1:");
		System.out.print("Solution: ");
		for (int i = 0; i < sorted.length - 1; i++) {
			System.out.print(sorted[i]);
		}
		System.out.println();
	}

	// QUESTION 1
	protected static int[] bubbleSort(int[] arr) {
		int arrayLength = arr.length - 1;
		for (int i = 0; i < arrayLength; i++) {
			for (int j = 0; j < arrayLength - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
		return arr;
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

}
