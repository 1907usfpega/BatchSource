package com.revature.varargs;

public class FunWithVarArgs {
/*Varisble Length Argument
 * METHOD WILL TAKE A VARIABLE NUMBER OF ARGS
 * Automates and hides the process of creating and saving the values in an array prior to invoking the method
 * can be of any type
 */
	public static void main(String[] args) {
		vaTest(10);
		vaTest2("Roll Tide",false,1,2,3,4,5,6,7,8,9,34);

	}
	static void vaTest(int... v) {
		System.out.println("Numer of args is: " + v.length+"Contents:");
		//For each loop
		for(int x: v) {
			System.out.print(x+", ");
		}
		
		
	}
	// only 1 vararg per method, must be in last parameter 
	static void vaTest2(String a, boolean b, int ...v) {
		System.out.println(a);
		System.out.println(!b);
		vaTest(v);
		
	}
	/*Overlaoding- same name, diff parameters (number or type)
	 *Ex. Constructors 
	 *Overloadinf order of operation:
	 *1. Exact match
	 *2. Conversion- casting! Reference to reference, primitive to primitve
	 *3. Boxing- autoboxing or autounboxing
	 *Varargs- arguments wrapped into arrays 
	 *
	 *
	 *OVERRIDING-deals with heritence
	 *creating methods w/ same name & parameters- different implementation
	 *may have different object classes being returned, but both must me be object classes 
	 *There are no numeric conversaions or boxing.unboxing for return types 
	 *
	 */
}
