package com.revature.wrappers;

public class Wrapperz {
	/* Wrap around primitve value and allow it to be treated like an object
	 * good for utility methods
	 * 
	 * Character char
	 * Boolean boolean
	 * Byte byte
	 * Short short
	 * Long long
	 * Integer int
	 * Float float
	 * Double double
	 * 
	 * Autoboxing - implicit conversion from a parametertype to wrapper class
	 * Autounboxing - wrapper to primitive
	 * both are expensive processes
	 * 
	 * Why use wrappers? if a wrapper is required
	 */
	public static void main(String[] args) {
		int myInt = 3;
		Integer myInteger = 5;
		Double myDouble = 73.97;
		Boolean myBool = true;
		int a = addEmUp(myInt, myInteger);
		System.out.println(a);
		int b = addEmUp(myInteger, myDouble.intValue());
		System.out.println(b);
	}

	public static int addEmUp(int a , int b) {
		return a+b;
	}
}
