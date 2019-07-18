package com.revature.corejavaassignment;

public class Q13 {

	public Q13() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q13 **********\n");
		int k = 0;
		for(int row = 0; row < 4; row++) {
			for(int col = 0; col <= row; col++) {
				System.out.print(k + " ");
				k = (k == 0) ? 1 : 0;
			}
			System.out.println();
		}
		System.out.println("\n\n");
	}

}
