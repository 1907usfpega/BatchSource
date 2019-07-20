package com.revature.corejavaassignment;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.revature.corejavaassignment.Q1Test;
import org.junit.jupiter.api.Test;

public class Q1 {

	public Q1() {
		// TODO Auto-generated constructor stub
		//////////Question 1//////////
		System.out.println("********** Q1 **********\n");
		int []example1 = {1,0,5,6,3,2,3,7,9,8,4};
		int[] sortedArr = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("Unsorted Array: ");
		for(int n = 0; n < 11; n++) {
			System.out.print(example1[n]+" ");
		}
		System.out.println();
		bubbleSort(example1);
		Q1Test tester = new Q1Test(example1, sortedArr);
		
		System.out.println("Sorted Array: ");
		
		for(int n = 0; n < 11; n++) {
			System.out.print(example1[n]+" ");
		}
		
		System.out.println("\n\n");
	}
	public static void bubbleSort(int[] arr) {
		int len = arr.length - 1;
		for(int pass = len; pass >= 0; pass--) {
			for(int place = 0; place < pass; place++) {
				if(arr[place] > arr[place+1]) {
					arr[place] ^= arr[place+1];
					arr[place+1] ^= arr[place];
					arr[place] ^= arr[place+1];
				}
			}
		}
	}
	
	

}

