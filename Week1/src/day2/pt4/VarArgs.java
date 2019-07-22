package day2.pt4;

public class VarArgs {
		
		/*
		 * VarArgs: Variable Length Arguments
		 * 		Method that will take in a variable number of arguments
		 * 		Automates and hides the creation & saving of values into Arrray prior to invoking method
		 * 		Can be of any type
		 */
	
	public static void main(String[] args) {

		Integer huey = 12;
		vaTest(huey);
		
		vaTest(356);
		vaTest(1,2,3,4,5,6,7,8,9,12);
		
		System.out.println(); //<--Whitespace for easier viewing
		
		vaTest2("Hail to Pitt", true, 4,6,8,12);
		
		
	}//end main
	
	static void vaTest(int ... v) { //<-- VarArgs have datatype ... array name
		System.out.print("Number of args is: " + v.length + " Contents: ");
		
		//For each Loop
		for(int x : v) {
			System.out.print(x + ", ");
		}
		
		System.out.println();
	}
	
	static void vaTest2(String a, boolean b, int ... v) {
		//Only one VarArg per method, must be the last parameter
		
		System.out.println(a);
		System.out.println(!b); //<-- Not b. If b is true, it prints false
		vaTest(v);
	}
	
	
	/*
	 * Overloading: same name, different parameters
	 * Order of Operations:
	 * 		1.) Exact Match
	 * 		2.) Conversion: Primitive & Reference types
	 * 		3.) Boxing: Autoboxing & Autounboxing
	 * 		4.) VarArgs: Arguments wrapped into arrays
	 * 
	 * 
	 * Overriding: Inheritance relationship with same name & parameters, but different implementation
	 * Can have different object classes returned
	 * No numeric conversions or boxing/unboxing allowed with return types
	 * 
	 */
	

}//end VarArgs Class
