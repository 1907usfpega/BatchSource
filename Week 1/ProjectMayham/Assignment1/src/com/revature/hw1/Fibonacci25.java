package com.revature.hw1;

public class Fibonacci25 {

	public static String fib() {
		int fib1 = 0;
		int fib2 = 1;
		int fib3;
		String output = "Fibonacci Sequence: " + fib1 + "," + fib2 + ",";
		for(int i = 2; i < 25; i++) {
			fib3 = fib1 + fib2;			
			if (i == 24) {
				output = output + fib3;
				break;
			}
			output = output + fib3 + ",";
			fib1 = fib2;
			fib2 = fib3;
		}

		return output;
	}

}
