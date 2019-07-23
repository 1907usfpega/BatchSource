package com.revature.varargs;

public class FunwithVarArgs {
	/*Variable length Arguement
	 * method will take a variable number of args
	 * automates and hides the process of creating and
	 * saving the values in an array prior to invoking
	 * the method
	 * can be of any type  
	 */

	public static void main(String[] args) {
		Integer huey= 12;
		int d=4;
		vaTest(10);
		vaTest(d);
		vaTest("Roll Tide", false,1,2,3,4,5,6,7,8,9,34);
	}
		
	static void vaTest(int a) {
			System.out.println("this takes only one");
	}
	static void vaTest(int ... v) {
		System.out.println("Number of args is: "+
				v.length+" Contents:");
		//For each loop
		for(int x: v) {
				System.out.println(x+", ");
		}
		
	}
	// only 1 vararg per method, must be last parameter
	static void vaTest(String a, boolean b, int ...v) {
			System.out.println(a);
			System.out.println(!b);
			vaTest(v);
	}
	/*
	 * overloading- same name, diff parameters (number/type)
	 * ex. Constructors
	 * Overloading order or operations:
	 * 1.	Exact Match
	 * 2.	Conversion- casting! Reference to Reference, Primitive to primitive 
	 * 3.	Boxing- autoboxing or autounboxing 
	 * 4.	VarArgs- args wrapped into arrays
	 * 
	 * Overriding- inheritance relationship, creating methods with same name and 
	 * parameters- diff implementation
	 * may have diff object classes being returned, but both must be
	 * object classes
	 * there are no numeric conversions or boxing/unboxing for return types
	 * 
	 */
}