package com.revature.varargs;

public class FunWithVarArgs {

	
	public FunWithVarArgs() {
		/*Variable length arguments
		 * Automates/hides process 
		 * of creating and saving value 
		 * in array prior to invoking
		 */
	}
	
	public static void main(String []args) {
		Integer huey = 12;
		vaTest(10);
		vaTest(huey);
		vaTest(huey, huey);
		vaTest("Roll Tide", false, 1,2,3,4,5,6,7,8,9,34);
	}
	static void vaTest(int ... v) {
		System.out.print("Number of arguments is: "
				+ v.length + "\nContents: ");
		for(int x:v) {
			System.out.print(x + ", ");
		}
		System.out.println();
	}
	static void vaTest(int v) {
		System.out.println("This takes only one int!");
	}
	//1 vararg per method, last parameter
	static void vaTest(String a, boolean b, int ... v) {
		System.out.println(a);
		System.out.println(!b);
		vaTest(v);
	}
	/*Overloading order of operations:
	 * 1. Exact match
	 * 2. Conversion- casting! Reference to Reference,
	 * Primitive to Primitive
	 * 3. Boxing & Unboxing
	 * 4. Varargs- args wrapped into arrays
	 * 
	 */
}
