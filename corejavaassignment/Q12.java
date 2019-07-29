package com.revature.corejavaassignment;

public class Q12 {

	public Q12() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q12 **********\n");
		int correctArr[] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 
							22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 
							42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 
							62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 
							82, 84, 86, 88, 90, 92, 94, 96, 98, 100};
		int arr[] = new int[100];
		for(int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		int j = 0;
		for(int i:arr) {
			if(i % 2 == 0) {
				Q12Test tester = new Q12Test(i, correctArr[j]);
				System.out.print(i + " ");
				j++;
			}

		}
		System.out.println("\n\n");
		
	}

}
