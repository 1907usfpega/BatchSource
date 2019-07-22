package com.revature.wrappers;

public class Wrapperz {
	/* Wrappers: 
	 * 	wrap around primitive value and allow it to be treated as an object
	 * 	good for utility methods
	 * 	
	 * 	Character -- char
	 * 	Boolean -- boolean
	 * 	Byte -- byte
	 * 	Short -- short
	 * 	Long -- long
	 * 	Integer -- int
	 * 	Float -- float
	 * 	Double -- double
	 * 
	 * autoboxing
	 * 	Implicit conversion from a primitive type to a wrapper class
	 * autounboxing
	 * 	Implicit conversion from wrapper to primative
	 * both are expensive processes
	 * 
	 * Why use wrappers?
	 * 	If an object is required
	 * 	to use class-defined utility methods
	 */
	public static void main(String[] args) {
		
		int myInt = 3;
		Integer myInteger = 5;
		Double myDouble = 73.97;
		Boolean myBoo = true;
		
		int a = addEmUp(myInt,myInteger);
		System.out.println(a);
		int b = addEmUp(myInteger, myDouble.intValue());
		System.out.println(b);
		
		
	}
	
	public static int addEmUp(int a, int b){
		return a+b;
	}

}
