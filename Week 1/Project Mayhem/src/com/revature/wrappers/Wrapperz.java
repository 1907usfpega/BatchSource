package com.revature.wrappers;

public class Wrapperz {
	/*Wrappers - wrap around primitive value and allow 
	 * it to be treated as an object
	 * -good for utility methods
	 * 
	 * Wrapper Classes for primitive data types
	 * -Character: 	char
	 * -Boolean: 	boolean
	 * -Byte: 		byte
	 * -Short: 		short
	 * -Long: 		long
	 * -Integer: 	int
	 * -Float: 		float
	 * -Double: 	double
	 * 
	 * 
	 * Autboxing - implicit conversion form a primitive type to a wrapper class.
	 * Autounboxing - wrapper to primitive
	 * BOTH ARE EXPENSIVE PROCESSES
	 * 
	 * Why you should use Wrapper classes?
	 * -if an object is required
	 * -to use class defined utility methods
	 */
	
	public static void main(String[] args) {
		int myInt = 3;
		Integer myInteger = 5; 
		Double myDub = 73.97;
		Boolean myBoo = true;
		
		int a = addEmUp(myInt, myInteger);
		System.out.println(a);
		int b = addEmUp(myInteger, myDub.intValue());
		System.out.println(b);
		
	}
	public static int addEmUp(int a, int b) {
		return a + b; 
	}
}
