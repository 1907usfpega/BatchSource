package com.revature.strangs;

public class FunWithStrings {
	/*Strings!
	 * not char or Character
	 * Fully Qualified class name:java.lang.String
	 * String literal is 0+ characters ex "" or String a="Roll Tide";
	 * concatenate strings w + .concat()
	 * "gootbye" + "earth"
	 * Strings are immutable
	 * Sting pool- collection of unique String literals in heap memory 
	 * some Strings are common and used in mult places within app
	 * String s- "dog"; Compiler searches string pool for "dog"
	 * if it exists, it will create a refernce to it
	 * if it doesn not exist, it will create a new string literal in the string pool
	 * String a= "dog"; same as refernce as a
	 * a=a+"house";
	 * String API has ulitity methods!
	 * String - String pool, immutable,fast, thread safe(it wont affect each other, only one can access it at a time
	 * StringBuilder- No String pool, mutable, not thread safe,fast
	 * StringBuffer- No String pool, mutable , is safe from thread,slow
	 */
	public static void main(String[] args) {
		String a="blah";
		//a.length()
		System.out.println(a.hashCode());
		a="woo";
		System.out.println(a.hashCode());
		System.out.println(a);
		String b= "blah";
		System.out.println(b.hashCode());
		
	}

}
