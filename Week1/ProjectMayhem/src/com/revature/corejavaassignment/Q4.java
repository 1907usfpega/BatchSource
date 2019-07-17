package com.revature.corejavaassignment;

public class Q4 {

	public Q4() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q4 **********\n");
		System.out.println("Factorials of 0 through 20: ");
		for(int exampleInt = 0; exampleInt <= 20; exampleInt++) {
			System.out.println(exampleInt + "! = " + factorial(exampleInt));
		}
		System.out.println("\n\n");
	}
	public static long factorial(int intIn) {
		return intIn == 0 ? 1 : intIn * factorial(intIn - 1);
	}

}
