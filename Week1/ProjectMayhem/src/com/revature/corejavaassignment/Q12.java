package com.revature.corejavaassignment;

public class Q12 {

	public Q12() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q12 **********\n");
		int arr[] = new int[100];
		for(int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		for(int i:arr) {
			if(i % 2 == 0)
				System.out.print(i + " ");
		}
		System.out.println("\n\n");
		
	}

}
