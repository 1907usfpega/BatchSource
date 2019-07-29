package com.revature.corejavaassignment;

public class Q2 {

	public Q2() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q2 **********\n");
		System.out.println("First 25 Fibonacci Numbers: ");
		fibonacci(25);
		System.out.println("\n\n");
	}
	public static void fibonacci(int n) {
		int fib[] = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 
				144, 233, 377, 610, 987, 1597, 2584, 4181,
				6765, 10946, 17711, 28657, 46368, 75025};
		int a = 0;
		int b = 1;
		switch(n) {
		case 0:
			break;
		case 1:
			System.out.print("a");
			break;
		default:
			System.out.print(a + " " + b + " ");
			for(int i = 1; i < n; i++) {
				b += a;
				a = (b - a);
				Q2Test tester = new Q2Test(b, fib[i + 1]);
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}
}
