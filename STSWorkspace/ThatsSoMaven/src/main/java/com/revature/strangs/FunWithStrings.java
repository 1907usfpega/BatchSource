package com.revature.strangs;

public class FunWithStrings
{
	/*
	 * Strings
	 * 	not char or Character
	 * Fully qualified class name: javalang.String
	 * string literal is 0+ characters EX: ""
	 * concatenate strings w/ +.concat()
	 * "hello" + "world"
	 * Strings are immutable
	 * String pool: collection of unique string literals in heap memory
	 * 	something made for java to run faster
	 * 	some strings are common and useded in multiple places in the app
	 * String s = "dog"; compiler searches pool for dog
	 * 	if it exists, it will create a reference for it
	 * 	if it does not exist, it will create a new string literal in the pool
	 * 	String a = "dog"; same reference as s
	 * 	a = a +"house";
	 * 
	 * String: has String pool, immutable, thread safe (only one thread can access it at a time), fast
	 * StringBuilder: no String pool, mutable, not thread safe, fast (because it aint safe)
	 * StringBuffer: no String pool, mutable, thread safe, slow (because it's safe)
	 */
	public static void main(String[] args) 
	{
		String a = "blah";
		System.out.println(a.hashCode());
		a = "woo";
		System.out.println(a.hashCode());
		System.out.println(a);
		String b = "blah";
		System.out.println(b.hashCode());
		//int[] arr = {1, 2, 3, 4, 5};
		//accessArray(arr);
	}
	
	/*public static void accessArray(int[] arr)
	{
		System.out.println(arr[5]);
		
		try
		{
			System.out.println(arr[5]);
		}
		catch(ArrayIndexOutOfBoundsException a)
		{
			System.out.println("Can't access that index!");
		}
		System.out.println("Now I'm here!");
	}*/
}
