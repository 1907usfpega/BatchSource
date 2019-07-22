package com.revature.assignment1;

/**
 * Assignment #1 Question 1
 * Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
 * 
 * @author Kyle Kolstad
 *
 *       Bubble Sort takes a set of a variable number of elements of an array
 *       and compares each element one by one. if the first element in the array
 *       is greater than the second then the elements will swap places. This
 *       continues to compare the remaining elements in the array. This process
 *       is repeated for (n-1) times where n is the number of elements in the
 *       array.
 */
public class BubbleSort {
	
	/**
	 * Default Constructor.
	 */
	public BubbleSort() {
		System.out.println("BubbleSort Object Created!");
	}

	/**
	 * Method used to sort the elements by comparing two elements at a time and
	 * swapping them if the first value is larger. Repeats until all elements are
	 * sorted.
	 */
	public int [] Sort(int [] array) {
		int temp;
		for (int x = 0; x < array.length; x++) {
			for (int y = 0; y < array.length - x - 1; y++) {
				if (array[y] > array[y + 1]) {
					temp = array[y];
					array[y] = array[y + 1];
					array[y + 1] = temp;
				}
			}
		}
		return array;
	}
	
	/**
	 * Method used to display the contents of an array.
	 */
	public void displayArray(int [] array) {
		System.out.println("***Contents of Array***");
		for (int x = 0; x < array.length; x++) {
			if (x == array.length - 1) {
				System.out.print(array[x]); //doesn't insert a comma after the last element in the array
			} else {
				System.out.print(array[x] + ", ");
			}
		}
	}
}