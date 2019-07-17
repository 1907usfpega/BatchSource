package com.revature.corejavaassignment;

public class Q2 {

	public Q2() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q2 **********\n");
		System.out.println("First 25 Finonacci Numbers: ");
		fibonacci(25);
		System.out.println("\n\n");
	}
	public static void fibonacci(int n) {
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
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}
}
