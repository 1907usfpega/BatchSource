/**
 * 
 */
package com.revature.wrappers;

/**
 * @author MajorKey
 *
 */
public class Wrapperz {
	
	/*
	 * Wrappers- wrap around primative value and allow
	 * it to be treated as an object
	 * good for utility methods
	 * 
	 * Charachter- char
	 * Boolean - boolean
	 * Byte - byte
	 * Short - short
	 * Long - long
	 * Integer - int
	 * Float - float
	 * Double - double
	 * 
	 * Autoboxing- 
	 * Autounboxing - 
	 * both are expensive processes
	 * 
	 * Why use wrappers?
	 * if an object is required
	 * to use class defined  utility methods
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
		return a + b ;
	}

}