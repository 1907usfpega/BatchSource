package com.revature.varargs2;

public class Polymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		multiplyNums(10, 10);
		multiplyNums(10.0, 10.0);
		multiplyNums("45", "56");
		multiplyNums(2, 3, 5);
		

	}
	
	public static void multiplyNums(int a, int b) {
		System.out.println("Hey this is : " + a * b);
	}
	
	public static void multiplyNums(double a, Double b) {
		System.out.println("Hey this is : " + a * b);
	}
	
	public static void multiplyNums(String a, String b) {
		int a1 = Integer.parseInt(a);
		int b1 = Integer.parseInt(b);
		multiplyNums(a1, b1);
	}
	
	public static void multiplyNums(int ...x) {
		int total = 1;
		for (int i:x) {
			total = total * i;
			
		}
		System.out.println("Hey this is the total " + total);
		
	}
	
	

}
