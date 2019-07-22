package com.revature.questions;

/*Q5. Write a substring method that accepts a string str 
 * and an integer idx and returns the substring contained 
 * between 0 and idx-1 inclusive.  Do NOT use any of the 
 * existing substring methods in the String, StringBuilder, 
 * or StringBuffer APIs.
*/
public class Q5 {

	public static String substring(String str, int idx) {
		String temp = "";
		for (int i = 0; i <= idx - 1; i++) {
			temp = temp + str.charAt(i);
		}
		System.out.println(temp);
		return temp;
	}
}
