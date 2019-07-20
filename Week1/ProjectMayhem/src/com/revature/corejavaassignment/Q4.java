package com.revature.corejavaassignment;

public class Q4 {

	public Q4() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q4 **********\n");
		long correctAnswer[] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};
		long temp = 0;
		System.out.println("Factorials of 0 through 10: ");
		for(int exampleInt = 0; exampleInt <= 10; exampleInt++) {
			temp = factorial(exampleInt);
			Q4Test tester = new Q4Test(correctAnswer[exampleInt], temp);
			System.out.println(exampleInt + "! = " + temp);
		}
		System.out.println("\n\n");
	}
	public static long factorial(int intIn) {
		if(intIn < 0) {
			System.out.println("Error, must not be negative");
			return 0;
		}
		return intIn == 0 ? 1 : intIn * factorial(intIn - 1);
	}

}
