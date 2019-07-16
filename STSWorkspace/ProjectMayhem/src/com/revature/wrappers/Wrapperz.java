package com.revature.wrappers;

public class Wrapperz 
{
	/*
	 * Wrappers: they wrap around a primitive value 
	 * and allow it to be trated as an object
	 * Also good for utility methods
	 * 
	 * -Character - char
	 * -Boolean - boolean
	 * -Byte - byte
	 * -Short - short
	 * -Long - long
	 * -Integer - int
	 * -Float - float
	 * -Double - double
	 * 
	 * Autoboxing: implicit converstion from a primitive type to a wrapper class
	 * Autounboxing: implicit conversion from a rwrapper class to a primitive type
	 * both are extensive processes
	 * Why use wrapper classes?
	 * 	If an object is required
	 * 	To use class defined utility methods
	 * 
	 */
	public static void main(String[] args) 
	{
		int myInt = 3;
		Integer myInteger = 5;
		Double myDouble = 73.97;
		Boolean myBoo = true;
		int a = addEmUp(myInt, myInteger);
		System.out.println(a);
		int b = addEmUp(myInteger, myDouble.intValue());
		System.out.println(b);
	}
	
	public static int addEmUp(int a, int b)
	{
		return a+b;
	}

}
