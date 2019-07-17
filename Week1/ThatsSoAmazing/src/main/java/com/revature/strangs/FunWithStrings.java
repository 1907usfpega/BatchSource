package com.revature.strangs;

public class FunWithStrings {
	/*Strings!
	 * not char or Character
	 * Fully Qualified class name:java.lang.String
	 * String pool- collection of unique String literals within heap
	 * If an existing String is specified, a reference is created.
	 * If not, it will create a new String literal
	 * StringBuilder and StringBuffer do not have String pool,
	 * also mutable
	 * StringBuilder-not thread safe
	 * StringBuffer- not thread safe
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
