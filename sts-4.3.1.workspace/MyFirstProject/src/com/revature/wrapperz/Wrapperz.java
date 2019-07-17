package com.revature.wrapperz;
/* Wrappers: wrap around primitive value and allow it to be treated as an object
   - good for utility methods
 
 Character - char			Boolean - boolean
 Byte - byte				Short - short
 Long - long				Integer - int
 Float - float				Double - double
 
 Autoboxing - implicit conversion from a primitive to a wrapper class
 Autounboxing - wrapper to primitive
 both are expensive processes
 
 Why use wrapers? if an obj is required
 to use class-defined utility methods
 
 */
public class Wrapperz {

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

	private static int addEmUp(int a, Integer b) {
		return a+b;
	}

}
