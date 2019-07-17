package com.revature.flows;

public class LoopyLoops {

	public static void main(String[] args) {
		/*
		 * If statement For decision making provides mulitiple paths of execution
		 * 
		 * if(condition) { what to do if true }else if(second conditional) { what to do
		 * if 2nd conditional is true }else { what to do if false }
		 * 
		 * Switch cases provides multiple paths of execution based on some value the
		 * "switch" is based on an integer numeric, a string a char, a boolean, or enum
		 * 
		 * For loops for(a;b;c) {do something} a is variable declaration (counter) b is
		 * the condition that controls how far the loop the loop will go c is the
		 * incrementor / decrementor
		 * 
		 */

		// whatColor("green");
		// forLoopFunness(30);
		// forEachFun(myArray);
		// whielyWhile(1);
		doWhielyWhile(2);
	}

	/*
	 * Conditional
	 * < > <= >= != ==
	 * a|b- bitwise
	 * a&&b cheaks both and evalueats iff both are true
	 * AND
	 * a&b - bitwise
	 * EQUALS 
	 * ==
	 * compares values of primitves
	 * compare the refereance for objecs, not contens
	 * != is goof for checking nulls
	 * .equals
	 * method inherited 
	 */
	/*
	 * While loop do{} while(condition);
	 */
	public static void whielyWhile(int i) {
		while (i++ < 10) {
			System.out.println("man this so cray... -_-" + i);
			// i++;
		}
	}

	public static void doWhielyWhile(int i) {
		do {
			System.out.println("doing the Due " + i);
			i++;
		} while (i < 10);
	}

	/*
	 * Enhanced for loop aka "for each" good for mogin through a collection, arrays,
	 * and other iterables more CPU efficient no isues wi/ index out of bounds not
	 * size dependent good for access elements in one collection bad for adding and
	 * removing
	 * 
	 */
	static int[] myArray = { 1, 2, 3, 4, 55, 6, 7, 98 };

	public static void forEachFun(int[] a) {
		for (int i : a) {
			System.out.println(i);
		}
	}

	public static void forLoopFunness(int p) {
		for (int i = p; i > 0; i--) {
			if (i == 10) {
				// break and continue
				// break;
				continue;
			}
			System.out.println(i);
		}
	}

	static String color;

	public static void whatColor(String color) {
		switch (color) {
		case "green":
			System.out.println("yo, the color is green my homie! Cuz matt can be hip with it too");
			break;
		case "orangered":
			System.out.println("what is life?");
			break;
		case "purple":
			System.out.println("purple is pretty kewl");
			break;
		case "puce":
			System.out.println("what is this?");
			break;
		default:
			System.out.println("you is very bad bad");
		}

	}

}
