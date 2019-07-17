package com.revature.corejavaassignment;

public class Q1 {

	public Q1() {
		// TODO Auto-generated constructor stub
		//////////Question 1//////////
		System.out.println("********** Q1 **********\n");
		/*int []i = {2, 4};
		System.out.println(i[0]+" "+i[1]);
		i[0] ^= i[1];
		i[1] ^= i[0];
		i[0] ^= i[1];
		System.out.println(i[0]+" "+i[1]);*/
		int []example1 = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println("Unsorted Array: ");
		for(int n = 0; n < 11; n++) {
			System.out.print(example1[n]+" ");
		}
		System.out.println();
		System.out.println("Sorted Array: ");
		bubbleSort(example1);
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
