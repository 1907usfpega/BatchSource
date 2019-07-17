package com.revature.strangs;

public class FunWithStrings {

	/*Strings are neither chars not Characters, but 
	 * Fully Qualified class name:java.lang.String
	 * String literal is 0+ chatacters ex "" or String a="Roll Tide"
	 * concatenate strings w? + .concat()
	 * "goodbye" + "earth" also concatenation
	 * Strings are immutable
	 * String pool - collection of unique String literals in heap memory
	 * Common Strings that are used in multiple places within app
	 * String s = "dog";  Compiler will search for dog in the Spring pool
	 * Either creates a reference to it, or creates stringspace in the pool
	 * s=s+"house"
	 * String API has utlity methods!
	 * String - Stringpool, immutable, threadsafe, fast
	 * StringBuilder - no pool, mutable, not threadsafe, fast
	 * StringBuffer - no pool, mutable, thread safe, slow
	 */
	public static void main(String[] args) {
		String a = "blah";
		System.out.println(a);
		a.length();
		a = "blah" + "blah";
		System.out.println(a.hashCode());
		String b = "blah";
		System.out.println(b==a);
		System.out.println(b);
	}

}
