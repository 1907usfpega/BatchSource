/**
 * 
 */
package com.revature.core;

import java.util.Arrays;

/**
 * @author MajorKey
 *Question 1
 */
public class BubbleSort {

	
	public int [] sort(int arr []) {
		int len = arr.length;
		boolean swap;
		int temp;
		
		for(int i = 0; i < len - 1; i++) {
			swap = false;
			System.out.println("This is iteration number " + i + 1);
			printArray(arr);
			
			for(int j = 0; j < len - i - 1; j++) {
				//checks if first 
				if(arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					
					System.out.println("\t A swap occurred.");
					System.out.print("\t");
					printArray(arr);
					
					swap = true;
				}
			}
			
			if(!swap)
				break;
		}
		return arr;
		
	}
	
	public void printArray( int arr[]) {
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String [] args) {
		BubbleSort a = new BubbleSort();
		int [] arr = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		arr = a.sort(arr);
		System.out.println("Final Product: ");
		a.printArray(arr);
	}
}
