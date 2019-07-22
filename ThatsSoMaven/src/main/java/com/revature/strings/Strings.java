package com.revature.strings;

public class Strings {
	
	/*
	 * Strings are an object
	 * Fully Qualified Class Name: java.lang.String
	 * String literal is 0+ characters
	 * 		Ex: "" or String a = "Pitt"
	 * Concatenate Strings with .concat() or +
	 * Strings are immutable (can't change value after you made them)
	 * 
	 * String pool: collection of unique String literals in heap memory
	 * 		some Strings are common and used in multiple places within the app
	 * Compiler searches for String in the pool
	 * if it exists, it will create a reference to it
	 * if not, it will create a new String literal in the String pool
	 * 
	 * Strings API has utility methods (subString, ...?)
	 * 
	 * String: String pool, immutable, thread safe, fast
	 * StringBuilder: No String pool, mutable, not thread safe, fast
	 * StringBuffer: No String pool, mutable, thread safe, slow  
	 */
	
	
	public static void main(String[] args) {
		
		String a = "blah";
		System.out.println(a.hashCode());
		
		a = "woo";
		System.out.println(a.hashCode());
		System.out.println(a);
		
		String b = "blah";
		System.out.println(b.hashCode()); //<--Same hash value as "a" when it was "blah"
		
	}//end main
	
}//end Strings class
