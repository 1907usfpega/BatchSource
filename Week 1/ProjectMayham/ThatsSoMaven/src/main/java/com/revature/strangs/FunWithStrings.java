package com.revature.strangs;

public class FunWithStrings {

	public static void main(String [] args) {
		
		/*
		 * Strings!
		 * not char or Character
		 * Fully Qualified class name: java.lang.String
		 * String literal is 0+ characters ex "" or String a = "War Eagle";
		 * concatenate strings w/ + or .concat()
		 * ex.) "goodbye" + "earth"
		 * 
		 * Strings are immutable
		 * String pool - collection of unique String literals in heap memory
		 * some strings are common and used in multiple places within app
		 * 
		 * String s = "dog"; compiler searches string pool for "dog"
		 * if it exists, it will create a reference to it,
		 * if it does not exist, it will create a new string literal in the string pool.
		 * 
		 * String a = "dog"; same reference as s
		 * 
		 * a = a+"house";
		 * String API has utility methods!
		 * String - String pool, immutable, thread safe, fast, 
		 * StringBuilder - No String pool, mutable, not thread safe, fast 
		 * StringBuffer - No String pool, mutable, thread safe, slow
		 */
	
		String a = "blah";
		System.out.println(a.hashCode());
		a = "woo";
		System.out.println(a.hashCode());
		System.out.println(a);
		String b = "blah";
		System.out.println(b.hashCode());		
	}
	
}
