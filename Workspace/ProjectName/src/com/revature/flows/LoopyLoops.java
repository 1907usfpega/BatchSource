package com.revature.flows;

import com.revature.beans.Person;

public class LoopyLoops {

	public static void main(String[] args) {
		/*
		 * If statement For decision making provides multiple paths of execution
		 * 
		 * if(<conditional>){ <what to do if true> } else if(<second conditional){ <what
		 * to do if 2nd conditional is true> else{ <what to do if false> }
		 * 
		 * Switch Cases provides multiple paths of execution based on some value the
		 * "switch" is based on an integer numeric, a string a char, a boolean, or enum.
		 */
		//whatColor("vfdbjhvfk");
		//forLoopFunness(30);
		//forEachFun(myArray);
		//wileyWhile(-34);
		//doWileyWhile(20);
		//checkStuff(3,3);
		//checkStuff(4,2);
		Person a =new Person("Matt",33,270);
		Person b =new Person("Matt",33,270);
		checkStuff(a,b);
		}

	static String color;

	public static void whatColor(String color) {
		switch (color) {
		default:
			System.out.println("you suck!");
			break;
		case "green":
			System.out.println("yo, the color is green, dog");
			break;
		case "orangered":
			System.out.println("what just happened");
			break;
		case "purple":
			System.out.println("purple is pretty kewl");
			break;
		case "puce":
			System.out.println("Dont take any more suggestions from Jackson");
			// break;

		}

	}

	/*
	 * For Loops for(a;b;c){do something} a is variable declaration (counter) b is
	 * the condition that controls how far the loop will go c is the
	 * incrementor/decrementor
	 */
	public static void forLoopFunness(int p) {
		for (int i = p; i > 0; i--) {
			if(i==10) {
				//break and continue
				//break;
				continue;
			}
			System.out.println(i);
		}
	}
	/*Enhanced for loop aka "for each"
	 * for (x:<Array or Collection>){do thing}
	 * good for moving through collections, arrays and other iterables
	 * more CPU efficient
	 * no issues w/ index out of bounds- not size dependent
	 * good for access elements in one collection
	 * bad for adding and removing*/
	static int [] myArray= {11,33,22,55,333,55,222,562,64,63};
	public static void forEachFun(int [] a) {
		for(int i:a) {
			System.out.println(i);
		}
	}
	/*While loops
	 * while(<condition>){<do something>}
	 * 
	 * do while
	 * do {<do thing>} while (<condition>);
	 * */
	public static void wileyWhile(int i) {
		while(i++<10) {
			System.out.println("man this is so exciting....not");
			//i++;
		}
	}
	public static void doWileyWhile(int i) {
		do {System.out.println("still boring "+i);
		i++;
		}
		while(i<10);
	}
	/*Conditionals
	 * Logical Operators
	 * < > <= >= != ==
	 *  OR 
	 *  a|b - bit wise
	 *  a||b- short circuit OR If a is true, return true w/o b
	 *  AND
	 *  a&b -bit wise
	 *  a&&b checks boths and evaluates true iff both are true
	 *  EQUALS
	 *  ==
	 *  compare values of primitives
	 *  compare the reference for objects. NOT THE CONTENTS
	 *  != is good for checking nulls
	 *  .equals()
	 *  method inherited Object
	 *  All reference types have it
	 *  looking at content
	 *  
	 *  
	 */
	public static void checkStuff(int a,int b) {
		if (a==b) {
			System.out.println("same");
		}else {
			System.out.println("not same");
		}
	}
	public static void checkStuff(Person s, Person t) {
		System.out.println(s);
		System.out.println(t);
		if (s.equals(t)) {
			System.out.println("same");
		}else {
			System.out.println("not same");	
		}
	}
}
