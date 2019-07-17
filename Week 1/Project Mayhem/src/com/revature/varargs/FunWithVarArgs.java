package com.revature.varargs;

public class FunWithVarArgs {
/* Variable with Argument
 * Method will take a variable number of args
 * Automates and hides the process of creating and 
 * saving the values into an array prior to invoking
 * the method
 * Can be of any type
 */
	public static void main(String[] args) {
		Integer johnnyBoi = 12;
		//double d = 4.18;
		//vaTest(d);
		System.out.println();
		vaTest(johnnyBoi);
		vaTest("Roll Tide",false ,1, 2, 3, 4, 5, 6, 7, 8, 9, 50);

	}
	static void vaTest(int ... v) {
		System.out.println("Number or args is : " + v.length + " Contents: ");
		//For each Loop
		for(int x: v) {
			System.out.print(x+ ", ");
		}
	}
	static void vaTest(double a) {
		System.out.println("This takes only one int! " + a);
	}
	// only 1 varArg per method and MUST BE LAST PARM
	static void vaTest(String a, boolean b, int ... v) {
		System.out.println(a);
		System.out.println(!b);
		vaTest(v);
	}
	/* Overloading- same name, diff param (number or type)
	 * Ex. Constructors 
	 * Overloading order of operations: 
	 * 1. Exact Match
	 * 2. Conversion- casting(prims or obj casing to other types/ ref-> ref OR prim -> prim)
	 * 3. Boxing 	- autoboxing or autounboxing
	 * 4. Varargs 	- args wrapped into arrays
	 * 
	 * 
	 * Overriding
	 * in inheritance relationship, creating methods w/ same names &
	 * parameters - differ implementation
	 * may have different Object classes being returned, BUT both MUST be
	 * Object classes
	 * There are no numeric conversions or boxing/unboxing for return typesS
	 */
}
