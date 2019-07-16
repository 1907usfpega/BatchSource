package com.revature.varargs;

public class FunWithVarArgs
{
	/*
	 * VarArgs: Variable Length Argument
	 * Method will take a variable number of arguments
	 * Automates and hides the process of creating and
	 * saving the values in an array prior to invoking the method
	 * Can be of any type
	 * 
	 */
	
	public static void main(String[] args)
	{
		Integer huey = 12;
		double d = 4.5;
		vaTest(huey);
		vaTest(10);
		vaTest(d);
		//vaTest(1,2,3,4,5,6,7,8,9,34);
		vaTest2("Roll Tide!", false, 1,2,3,4,5,6,7,8,9,34);
	}
	
	static void vaTest(int ... v)
	{
		System.out.print("Number of args is: "+v.length + "\nContents: ");
		for(int i : v)
		{
			System.out.print(i+", ");
		}
		System.out.print("\n\n");
	}
	
	static void vaTest(int a)
	{
		System.out.println("this is the only int value: "+a);
	}
	
	static void vaTest(double a)
	{
		System.out.println("this is the only double value: "+a);
	}
	
	//we can only have 1 var arg per method and it must be the final parameter
	static void vaTest2(String a, boolean b, int ... v)
	{
		System.out.println(a);
		System.out.println(!b);
		vaTest(v);
		//System.out.print("Number of args is: "+v.length);
	}
	
	/*
	 * Overloading order of operations:
	 * 1. Exact match
	 * 2. Conversion (casting, Reference to Reference, primitive to primitive)
	 * 3. Autoboxing & Autounboxing
	 * 4. VarArgs: wrapping arguments into an array
	 * 
	 * Overriding: can only exist withi an inheritance relatiopnship
	 * by creating methods with the same name & parameters, while
	 * having different implementation
	 * many have different Object classes being returned, but
	 * both must be objects
	 * There are no numeric conversions or boxing/unboxing for return types
	 * 
	 */
}
