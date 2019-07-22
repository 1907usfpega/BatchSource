package com.revature.overloading;

public class Overloading {

	public static void main(String[] args) {
		
		int i = 10;
		double d = 20;
		Integer integer = 30;
		
		method(d);
		method(i);
		method(integer);
		
		method(i,integer);	
	}
	
	/*
	 * If all three of these methods exist, only exact matches will be used.
	 * If method(double d) is deleted, the double will not be parsed.
	 * If method(int i) is deleted, the int will be parsed via method(
	 */
	public static void method(double d) {
		System.out.println("This method expects a double: "+d);	
	}
	public static void method(int i) {
		System.out.println("This method expects an int: "+i);
	}
	public static void method(Integer i) {
		System.out.println("This method expects an Integer: "+i);
	}
	
	public static void method(int ... v) {
		System.out.println("This method expects a variable number of ints, and got "+v.length+" ints:");
		for(int x:v) {
			System.out.print(x+" ");
		}
		System.out.println();
	}
	
	
	
}
