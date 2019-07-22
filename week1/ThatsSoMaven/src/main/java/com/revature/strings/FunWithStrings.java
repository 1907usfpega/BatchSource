package com.revature.strings;

public class FunWithStrings {

	/*strings arent char or Character
	 * not really a char[] either
	 * fully qualified class name:java.lang.string
	 */
	
	/*string has utilitty methods
	 * string- has string pool, immutable, thread safe, fast
	 * (only one thread can access at a time)
	 * string builder- doesnt have SP, mutable, thread unsafe, fast
	 * string buffer- "", "", thread safe, slow
	 */
	public static void main(String[] args) {
		String a = "heck";
		System.out.println(a.hashCode());
		a="eat me";
		System.out.println(a.hashCode());
		System.out.println(a);
		String b = "heck";
		System.out.println(b.hashCode());
	}

}