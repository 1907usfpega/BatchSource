package com.revature.strangs;

public class FunWithStrings {
	// TODO Auto-generated method stub
			/*
			 * Strings!
			 * not char or character
			 * Fully Qualified class name is java.lang.String
			 * 
			 * String literal is 0 to many character ex. "" or 
			 * String a = "Roll Tide";
			 * 
			 * concatenate strings w/ + .concat()
			 * "goodbye" + "earth" becomes "goodbyeearth"
			 * 
			 * String pool - a collection of unique String literals in heap memory
			 * some Strings are common and used in multiple places within an app
			 * String s = "dog"; compiler searches string pool for "dog" 
			 * if it exists, it will create a reference to it
			 * if not it will create a new string literal in the string pool
			 * a = a+"house";
			 * 
			 * String API has utility methods
			 * 
			 * String - has string pool, immutable, thread safe, FAST
			 * String Builder - no string pool, mutable, not thread safe, FAST
			 * String Buffer -no string pool, mutable, thread safe, SLOW
			 */

	public static void main(String[] args) {
		String a= "blah";
		System.out.println(a.hashCode());
		a= "woo";
		System.out.println(a.hashCode());
		System.out.println(a);
		String b = "blah";
		System.out.println(b.hashCode());	
	}

}
