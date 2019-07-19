package com.revature.varargs;

public class FunWithVarArgs {
	/*Variable Length Argument
	 * Method will take a variable number of args
	 * Automates and hides the process of creating and 
	 * saving the values in an array prior to invoking
	 * the method
	 * can be of any type
	 */
	public static void main(String[] args) {
		Integer huey= 12;
		double d=4.8;
		vaTest(10);
		vaTest(d);
		vaTest(huey);
		//vaTest("Roll Tide",false,1,2,3,4,5,6,7,8,9,34);

	}
	static void vaTest(int a) {
		System.out.println("This takes only one int!" +a);
		
	}
	static void vaTest(double a) {
		System.out.println("This takes only one double!" +a);
		
	}
	static void vaTest(int ... v) {
		System.out.println("Number of args is: "+
				v.length+" Contents:");
		//For each loop
		for(int x: v) {
			System.out.print(x+", ");
		}
	 	
	}
	// only 1 vararg per method, must be last parameter 
	static void vaTest(String a, boolean b, int ...v) {
		System.out.println(a);
		System.out.println(!b);
		vaTest(v);
		
	}
	/*Overloading- same name, diff parameters (number or type)
	 * Ex. Constructors
	 * Overloading order of operations:
	 * 1. Exact Match
	 * 2. Conversion- casting! Reference to Reference, Primitive to primitive
	 * 3. Boxing- autoboxing or autounboxing
	 * 4. Varargs- args wrapped into arrays
	 */
}
