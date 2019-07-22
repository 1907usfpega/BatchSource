package com.revature.strangs;

public class FunWithStrings {

	/* Strings!
	 * not char or Character
	 * Fully Qualified class name: java.lang.String
	 * 
	 * String Literal is 0+ characters ex "" or String a = "Roll Tide"
	 * concatenate strings with + or .concat()
	 * ex. "goodbye" + "earth"
	 * Strings are immutable because of String pool: Collection of unique String literals in heap memory
	 * some Strings are common and used in multiple places within app
	 * 
	 * for more notes look at notes 7/17
	 * 
	 */
	public static void main(String[] args) {
		
		String a = "blah";
		System.out.println(a.hashCode());
		a = "woo";
		System.out.println(a.hashCode());
		System.out.println(a);
		String b = "blah";
		System.out.println(b.hashCode());
	}

}
