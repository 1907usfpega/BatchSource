package com.revature.varargs;

public class FunWithVarArgs {

	/*
	 * Varibale Length arguments
	 * Method will take a variable number of args
	 * Automates and hides the process of creating
	 * and saving the values in an array prior to invoking the method
	 * can be of any type
	 */
	public static void main(String[] args) {
		vaTest(10);
		Integer x = 5;
		vaTest("Benis", true, 1, 2, 3, 4, 5, 19);
	}
	static void vaTest(int ... v) {
		System.out.println("Number of arguments is: " + v.length + " Contents: " );
		
		for(int x: v) {
			System.out.print(x + ", ");
		}
	}
	static void vaTest(double ... v) {
		System.out.println("Number of arguments is: " + v.length + " Contents: " );
		
		for(double x: v) {
			System.out.print(x + ",234234 ");
		}
	}
	//only one vararg per method and must be in the last position!!
	static void vaTest(String a, boolean b, int ... v) {
		System.out.println(a);
		System.out.println(!b);
		vaTest(v);
		/*
		 * Overloading
		 * 2 Methods, same name, different parameters
		 * overloading order of operations:
		 *  Exact match
		 *  Conversion - casting! Reference to reference; primitive to primitive
		 *  Boxing - autoboxing or autounboxing
		 *  Varargs - arguments wrapped into arrays
		 *  
		 *  Overwriting
		 *  in inheritance relationships, creating methods with same masks, 
		 *  overwrites the parents method.
		 *  May have different object classes being returned
		 *  There are no numeric conversions or boxing/unboxing for returntypes
		 *  
		 */
	}
}
