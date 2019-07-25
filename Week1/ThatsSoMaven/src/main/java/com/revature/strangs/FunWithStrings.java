package com.revature.strangs;

public class FunWithStrings {
<<<<<<< HEAD
	/*
	 * Strings!
	 * not char or Character
	 * Fully Qualified class name:java.lang.String
	 * String literal is 0+ characters ex " " or String a="Roll Tide";
	 * concatenate strings w/ + .concat()
	 * "goodbye" + "earth"
	 * Strings are immutable 
	 * String pool- collection of unique String literals in heap memory
	 * some strings are common and used in mult places within app
	 *  * String s= "dog"; Compiler searches string pool for "dog"
	 *  if it exists, it will create a reference to it, 
	 *  if it does not exist, it will create a new string literal
	 *  in the string pool
	 *  String a= "dog"; same reference as s
	 *  a=a+"house";
	 *  String API has utility methods!
	 *  String- String pool immutable, thread safe, fast
	 *  StringBuilder- No string pool, mutable, not thread safe, fast
	 *  StringBuffer- No string pool, mutable, thread safe, slow
	 */
=======
	/*Strings!
	 * not char or Character
	 * Fully Qualified class name:java.lang.String
	 * String literal is 0+ characters ex "" or String a="Roll Tide";
	 * concatenate strings w/ + .concat()
	 * "goodbye" + " earth"
	 * Strings are immutable
	 * String pool- collection of unique String literals
	 *  in heap memory
	 * some strings are common and used in mult places
	 *  within app
	 *  * String s= "dog"; Compiler searches string 
	 *  pool for "dog"
	 * if it exists, it will create a reference to it, 
	 * if it does not exist, it will create a new string literal
	 *  in the string pool
	 * String a= "dog"; same reference as s
	 * a=a+"house";
	 * String API has utility methods!
	 * String - String pool, immutable, thread safe,fast
	 * StringBuilder- No String pool, mutable, not thread safe, fast
	 * StringBuffer- No String pool, mutable,thread safe,slow 
	 */ 
>>>>>>> 0a9b7f690da935daefecdbf30dfc932c8ec1af91
	public static void main(String[] args) {
		String a="blah";
		System.out.println(a.hashCode());
		a="woo";
		System.out.println(a.hashCode());
		System.out.println(a);
		String b= "blah";
		System.out.println(b.hashCode());
<<<<<<< HEAD

=======
>>>>>>> 0a9b7f690da935daefecdbf30dfc932c8ec1af91
	}

}
