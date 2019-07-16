package com.revature.varargs;

public class FunWithVarArgs {

	/*
	 * Variable Length Arguments
	 * Method will take a variable number of arguments.
	 * Automates and hides the process of creating and saving
	 * the values in an array prior to invoking the method.
	 * Can be of any type
	 */
	
	public static void main(String[] args) {

		Integer huey = 12;
		double d = 4.8;
		
		vaTest(10);
		vaTest(huey);
		vaTest(huey,huey);
		vaTest(d);
		vaTest2("War Eagle", false, 1,2,3,4,5,6,7,8,9,34);
		

	}

	static void vaTest(int ... v) {
		System.out.print("Number of args is: " + v.length + "\nContents: ");
		// For each loop
		int i = 0;
		for (int x: v) {
			System.out.print(x);
			if (i != v.length-1) {
				System.out.print(", ");
			}
			i++;
		}
		System.out.println("\n");
	}
	
	/*
	 * Overloading - Same name, different parameters (number or type)
	 * Ex.) Constructors
	 * Overloading order of operations:
	 * 		1. Exact Match
	 * 		2. Conversion - casting! Reference to reference, primitive to primitive
	 * 		3. Boxing - autoboxing or autounboxing
	 * 		4. Varargs - arguments wrapped into arrays
	 */
	
	/*
	 * Overriding
	 * in inheritance relationship, creating methods with same name and parameters - different implementation.
	 * may have different object classes being returned, but both must be object classes.
	 * 
	 * There are no numeric conversions or boxing /unboxing for return types.
	 */
	
	static void vaTest(int a) {
		System.out.println("This takes only one int!\n");
	}
	
	static void vaTest(double d) {
		System.out.println("This takes only one double!\n");
	}
	
	// Only 1 vararg per method, must be the last parameter.
	static void vaTest2(String a, boolean b, int ... v) {
		System.out.println(a);
		System.out.println(!b);
		
		vaTest(v);
	}
}
