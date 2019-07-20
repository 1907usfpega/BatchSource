package com.revature.corejavaassignment;

public class Q6 {

	public Q6() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q6 **********\n");
		for(int testNum = 1; testNum <=10; testNum++) {
			Q6Test tester = new Q6Test((testNum % 2 ==0), isEven(testNum));
			System.out.println(testNum + " is " + (isEven(testNum) ? "even" : "odd"));
		}
		System.out.println("\n\n");
	}
	public static boolean isEven(int intIn) {
		if((intIn / 2) == ((intIn + 1) / 2))
			return true;
		return false;
	}

}
