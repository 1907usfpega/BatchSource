package com.revature.corejavaassignment;

public class Q13 {

	public Q13() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q13 **********\n");
		String correctString = "0 \n1 0 \n1 0 1 \n0 1 0 1 \n";
		String testStr = "";
		Integer k = 0;
		for(int row = 0; row < 4; row++) {
			for(int col = 0; col <= row; col++) {
				testStr = testStr.concat(k.toString() + " ");
				k = (k == 0) ? 1 : 0;
			}
			testStr = testStr.concat("\n");
		}
		Q13Test tester = new Q13Test(testStr, correctString);
		System.out.println(testStr);
		System.out.println("\n\n");
	}

}
