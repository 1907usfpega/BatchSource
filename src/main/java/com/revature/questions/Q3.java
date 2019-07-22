package com.revature.questions;

/**
 * Q3. Reverse a string without using a temporary variable. Do NOT use reverse()
 * in the StringBuffer or the StringBuilder APIs.
 * 
 * @param args
 */

public class Q3 {

	public static String reverseString(String str) {
		//add point of cut 
		str = str + " ";
		
		// navigate the string backwards
		for (int i = str.length()-2; i >= 0; i--) {
			//append writting reverse
			str = str + str.charAt(i);
		}
		
		//cut at point of cut
		System.out.println("\n"+str.split(" ")[1]);
		return str.split(" ")[1];
	}

}
