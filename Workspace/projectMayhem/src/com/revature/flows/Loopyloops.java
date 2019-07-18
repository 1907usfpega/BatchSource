package com.revature.flows;

public class Loopyloops {

	public static void main(String[] args) {
		
		/*if statement
		 * for decision making purposes
		 * provides multiple paths of execution
		 * 
		 * switch cases
		 * provides multiple paths of execution based on some value
		 * the "switch" is based on an integer numeric, 
		 * a string, a char, a boolean, or enum
		 */
		whatColor("green");
		forLoopFunness(30);
		forEachFun(myArray);
		wileyWhile(-34);
		doWileyWhile(10);
		
	}
	static String color;
	public static void whatColor(String color) {
		switch(color) {
		
		case "green": 
			System.out.println("Yo, the color is green, dog");
			break;
			
		case "orange red":
			System.out.println("What just happened?");
			break;
			
		case "purple":
			System.out.println("purple is pretty kewl");
			break;
			
		case "puce":	
			System.out.println("puce sucks");
			break;
			
		default:
			System.out.println("You suck!");
			
			//does the order matter? no
			//can you put the default anywhere? 
			//yes but you still need the break
			
			/*For loops
			 * for (a;b;c){
				do something
				}
				a is variable declaration
				b is conditonal
				c is incrementor/decrementor
			 * 
			 * 
			 */
			
		}
	}	
		public static void forLoopFunness(int p) {
			for(int i=p; i >0; i--) {
				if (i ==10) {
					//break and continue
					//break; //stops at 11
					continue; //skips 10 and continues with 9
				}
				System.out.println(i);
			}
		}
		/*Enhanced for loop aka for each loop
		 * for (x: <Array or Collection>) { do something}
		 * good for moving thru collections, arrays and other iterables
		 * 
		 */
		static int [] myArray = { 1,22,33,44,555,66,777,88,99};
		public static void forEachFun(int  [] a) {
			for(int i: a) {
				System.out.println(i);
				
			}
		}
		
		/*While loops
		 * while condition is true
		 * do something
		 * 
		 * do while
		 * do something
		 * check if true
		 */
		
		public static void wileyWhile(int i) {
			while (i<10) {
				System.out.println("This is exciting");
				i++;
			}
		}
		
		public static void doWileyWhile(int i) {
			do {
				System.out.println("still boring" + i);
				i++;
			}
				while(i < 0);
			}
		
		}

		/*conditionals
		 * s.equals(t) to check objects, ref variables
		 * == to check if primitives equal
		 * 
		 * 
		 * 
		 */


	


