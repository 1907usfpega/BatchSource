package com.revature.hw1;

public class MathTest {
	public static void main(String [] args) {
		int a = 25;
		int b = 5;
		MathImplementation mi = new MathImplementation();
		System.out.println(mi.addition(a,b));
		System.out.println(mi.subtraction(a,b));
		System.out.println(mi.multiplication(a, b));
		System.out.println(mi.division(a, b));
	}
}
