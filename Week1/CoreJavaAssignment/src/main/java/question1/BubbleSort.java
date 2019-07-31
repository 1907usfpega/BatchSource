/**
 * 
 */
package question1;

import java.util.Arrays;

/**
 * @author Deonta Kilpatrick
 *
 */
public class BubbleSort {

	public int [] sort(int arr []) {
		int len = arr.length;
		boolean swap;
		int temp;
		
		//outer for loop controls looping through the entire array
		for(int i = 0; i < len - 1; i++) {
			swap = false;
			System.out.println("This is iteration number " + i + 1);
			printArray(arr);
			
			//nested loop controls how far into the array we keep checking for possible swaps
			for(int j = 0; j < len - i - 1; j++) {
				//checks if we need to swap the bigger number to a lower position in the array
				if(arr[j] > arr[j + 1]) {
					//temp variable facilitates swap
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					
					System.out.println("\t A swap occurred.");
					System.out.print("\t");
					printArray(arr);
					
					swap = true;
				}
			}
			
			//if we go through the array and nothing else is swapped it means we are done sorting 
			if(!swap)
				break;
		}
		return arr;
		
	}
	
	//given an array prints the array to console
	public void printArray( int arr[]) {
		System.out.println(Arrays.toString(arr));
	}
}
