package com.revature.varargs;
/* Variable Length Argument
 Method will take a variable # of args
 Automates and hides the process of creating and saving the 
 values in an array prior to invoking the method
 can be any type 
 
 */

public class FunWithArgs {

	public static void main(String[] args) { 

		vaTest2("A",false, 12,124,46,86,23,1,5);
	}
	//					VAR ARG
	static void vaTest(int ... v) {
		System.out.println("\n # of args is: "+ v.length +"Contents: ");
		
		for(int x: v) {
			System.out.print(x+ ", ");
		}
	}
	static void vaTest2(String a, boolean b, int ... v) {
		System.out.println(a);
		System.out.println(!b);
		vaTest(v);
	}
/* OVERLOADING - same name diff parameters
 * order of operations:
 * 1. exact match
 * 2. Conversion - casting! Reference to Reference, Primitive to primitive
 * 3. Boxing - autoboxing or autounboxing
 * 4. Varargs - args wrapped into arrays

 
OVERRIDING: in inheritance relationship, creating methods w/ same name &
parameters - diff implemantation.

may have diff obj classes being return, but both must be Obj classes
 
 */
}
