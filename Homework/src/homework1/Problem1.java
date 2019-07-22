//Code Resource used: https://www.w3resource.com/java-exercises/sorting/java-sorting-algorithm-exercise-2.php

package homework1;

public class Problem1 {
	
	public static int[] bubbleSort(int[] sortThis) {
		
		//Cycles through array and compares each value against the others
		for(int i = 0; i < sortThis.length - 1; i++) {
			for(int j = 0; j < sortThis.length - i - 1; j++)
				
				//If a number is larger than the one next to it, it swaps their positions to get an ascending order
				if(sortThis[j] > sortThis[j + 1]) {
					int swap = sortThis[j]; 
					sortThis[j] = sortThis[j+1]; 
					sortThis[j+1] = swap; 
				}
		}
		
		//Prints the beginning of the output statement
		System.out.print("Q1.) Here is the sorted list: ");
		
		//Uses an enhanced for loop to print the sorted array
		for(int x: sortThis) {
			System.out.print(x + " ");
		}
		
		
		return sortThis;
		
	}//end bubbleSort()
	
}//end Problem1 class
