package com.revature.questions;

public class Question15 implements Mathy15{

	public int multiplication(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	public int substraction(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	public int addition(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	public int division(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}
		
	public void doTask() {
		int x = 4;
		int y = 19;
		System.out.println("Addition of " + x + " & " + y + " = " + addition(x, y));
		System.out.println("Multiplication of " + x+  " & " + y + " = " + multiplication(x, y));
	}
}
