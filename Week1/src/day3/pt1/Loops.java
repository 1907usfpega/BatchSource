package day3.pt1;

import day2.pt1.Person;

public class Loops {
	
	/*
	 * If Statement
	 * For decision making by providing multiple paths of execution
	 * 
	 * if(conditional){
	 * 		do if true
	 * }else if(second conditional){
	 * 		do if second true
	 * }else{
	 * 		do if false (all else fails)
	 * }
	 * 
	 * 
	 * Switch Cases
	 * Provides multiple paths based on some value
	 * Based on: integer, string, char, boolean, or enum
	 * Should include a default case at end
	 * INCLUDE YOUR BREAK STATEMENTS or it will run that, plus all below
	 * last one doesn't need a break (usually default)
	 * 		Order doesn't matter in switched, can even put default first
	 */
	
	public static void main(String[] args) {
		
		whatColor("green");
		System.out.println();
		
		forLoop(10);
		System.out.println();
		
		forEach(myArray);
		System.out.println();
		
		whileLoop(1);
		System.out.println();
		
		doLoop(1);
		System.out.println();
		
		comparison(2,3);
		comparison(3,3);
		System.out.println();
		
		Person guy = new Person("Tyler", 33, 157);
		Person man = new Person("Tyler", 33, 157);
		Person lady = new Person("Jane", 24, 123);
		comparison(guy,man);
		System.out.println();
		
	}//end main
	
//------------------------------------Switch-----------------------------------------
	static String color;//<--did static need to be here?
	public static void whatColor(String color) { //<-- multiple public??
		
		switch(color) {
		case "green":
			System.out.println("Green is a combination of blue and yellow.");
			break;
		case "orange":
			System.out.println("Orange is a combination of red and yellow.");
			break;
		case "purple":
			System.out.println("Purple is a combination of red and blue.");
			break;
		case "brown":
			System.out.println("Brown is the result of mixing all colors.");
			break;
		default:
			System.out.println("You did not input a color that I recognize.");
		}//end switch
		
	}//end whatColor method
	
	
//------------------------------------For-----------------------------------------
	/*
	 * For Loops
	 * for(a;b;c){do something}
	 * a is variable declaration (counter)
	 * b is the condition that controls how far the loop will go
	 * c is the incrementor/decrementor
	 * 
	 * Continue: Just skips that one when condition is true. Continues on
	 * 
	 * Break: Immediately stops the loop when condition is true
	 */
	
	public static void forLoop(int p) {
		
		for(int i = p; i > 0; i--) {
			if(i == 3) {
				//break;
				continue;
			}
			System.out.println("For " + i);
		}
	}//end forLoop method
	

//------------------------------------For Each-----------------------------------------
	/*
	 * Enhanced for loop "for each"
	 * for(x:array/collection){do something}
	 * good for moving through collection, but bad for adding or removing elements
	 * more cpu efficient
	 * no issues with index out of bounds (not size dependent)
	 */
	
	static int[] myArray = {1,2,3,4,5,6,7,8,9,10};
	public static void forEach(int[] a) {
		
		for(int i:a) {
			System.out.println("Foreach " + i);
		}
	}//end forEach method

	
//------------------------------------Do & While-----------------------------------------
	/*
	 * While loop
	 * while(condition){do something}
	 * 
	 * Do While loop
	 * do{do something} while(condition);
	 */
	
	public static void whileLoop(int i) {
		
		while(i<10) { //<-- could also do i++, but will increment before running (i.e. start with 2, not 1)
			System.out.println("While " + i);
			i++;
		}
	}//end whileLoop method
	
	public static void doLoop(int i) {
		
		do {System.out.println("Do " + i);
		i++;
		}while(i<10);
		
	}//end doLoop method

	
//------------------------------------Conditionals-----------------------------------------
	/*
	 * Conditionals
	 * < > <= >=
	 * a|b (bit wise)
	 * a||b
	 * a&b (bit wise)
	 * a&&b 
	 * == (compares primitves & reference of objects (memory address))
	 * != (good for checking nulls)
	 * .equals() (compares contents of objects)
	 */

	public static void comparison(int a, int b) {
		
		if(a == b) {
			System.out.println("These are the same.");
		}else {
			System.out.println("These are not the same.");
		}
				
	}//end comparison method
	
	public static void comparison(Person a, Person b) { //<--Overloaded methods!! (same name, different parameters)
														//<--Import person
		System.out.println(a);
		System.out.println(b);
		
		if(a == b) { //<--Only check memory location, not values
			System.out.println("== These are the same people.");
		}else {
			System.out.println("== These are not the same people.");
		}
		
		if(a.toString().equals(b.toString())) { //<--Checks if everything in objects are the same
			System.out.println(".equals These are the same people.");
		}else {
			System.out.println(".equals These are not the same people.");
		}
				
	}//end comparison method



}//end Loops class
