package com.revature.wrappers;

public class Wrapperz {
	/* wrappers- wrap around a primitive and let it be
	 * treated as an object
	 * -neccessary to use methods on primitive values
	 * -good for utility methods
	 * 
	 * 
	 * wrapper-Character Boolean Byte Short Long Integer Float Double
	 * primitive-char boolean byte short long int float double
	 * 
	 * autoboxing: implicit conversion from primitive to wrapper
	 * autounboxing: same but in reverse
	 * expensive processes
	 * 
	 * why use wrapper classes?
	 *   if an object is required
	 *   to use class defined util methods
	 */
	public static void main (String[] args) {
		int myInt=3;
		Integer theInt=5;
		Double myDoub=3.14159;
	
		int a = addEmUp(myInt,theInt);
		System.out.println(a);
		int b = addEmUp(theInt,myDoub.intValue());
		System.out.println(b);
		
	}
	
	public static int addEmUp(int a, int b) {
		return a+b;
	}
}
