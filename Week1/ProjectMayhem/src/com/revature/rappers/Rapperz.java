package com.revature.rappers;

public class Rapperz {
	/*Wrappers- wrap around a primitive value and 
	 * allow it to be treated as an object
	 * good for utility methods
	 * eg. Character, Boolean, Byte, Short, 
	 * Long, Integer, Float, Double
	 * 
	 * Autoboxing- implicit conversion from a 
	 * primitive type to a wrapper class
	 * Autounboxing
	 * Both are expensive processes
	 * 
	 * Why use?
	 * 		If object is required, to use
	 * 		class-defined tuning methods
	 */
	public static void main(String []args) {
		int myInt = 3;
		Integer myInteger = 5;
		Double myDouble = 73.97;
		Boolean myBoo = true;
		int a = addEmUp(myInt, myInteger);
		System.out.println(a);
		int b = addEmUp(myInteger, myDouble.intValue());
		System.out.println(b);
	}
	public static int addEmUp(int a, int b) {
		return a + b;
	}
	
}
