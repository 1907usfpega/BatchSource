package com.revature.wrappers;

public class Wrapperz {
	/*Wrappers- wrap around a prmitive value and are allowed to be treated as an object
	 * -good for utility methods
	 * 
	 * Character-char
	 * Boolean-boolean
	 * Byte-byte
	 * Short-short
	 * Long-long
	 * Integer-int
	 * Float-float
	 * Double-double
	 * 
	 * 
	 * Strings is a refrence type so it is not included
	 * 
	 * 
	 * Autoboxing-implicti conversuoin from a primitive type to 
	 * Autounboxing-wrapper to primitive
	 * both are expensive processes
	 * 
	 * Why use wrappers?So if an objects is required to use class to define utility methods
	 */

	public static void main(String[] args) {
		int myInt=3;
		Integer myInteger=5;
		Double myDouble=73.97;
		Boolean myBoo= true;
		a= addEmUp(myInt,myInteger);
		System.out.println(a);
		int b= addEmUp(myInteger,myDouble.intValue());
		System.out.println(b);

	}

	public static int addEmUp(int a,int b) {
		return a+b;
	}

}
