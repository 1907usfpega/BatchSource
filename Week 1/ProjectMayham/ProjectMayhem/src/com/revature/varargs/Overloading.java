package com.revature.varargs;

public class Overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 7;
		double b = 8.0;
		Integer c = 5;
		
		overload(a);
		overload(b);
		overload(c);
		overload(a,b,1,2,3,4,5,6,7,8,9);
		
		
	}
	
	static void overload(double d) {
		System.out.println("Value: " + d + "\n");
	}
	
	static void overload(int a, double d, int ... v) {
		int argNum = v.length + 2;
		System.out.print("Number of args is: " + argNum + "\nContents: ");
		// For each loop
		System.out.print(a + ", " + d + ", ");
		int i = 0;
		for (int x: v) {
			System.out.print(x);
			if (i != v.length-1) {
				System.out.print(", ");
			}
			i++;
		}
		System.out.println("\n");
	}
}
