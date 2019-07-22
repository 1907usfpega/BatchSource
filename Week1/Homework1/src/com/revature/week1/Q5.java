package com.revature.week1;

/*
 * substring is part of a string
 * 
 */

public class Q5 {

	public static String smallString(String str, int idx) {
		String newStr = new String();

		idx = (idx < str.length()) ? idx : str.length();

		for (int i = 0; i < idx; i++) {
			newStr = newStr + str.charAt(i);
		}
		// Roller
		System.out.println(newStr);
		return newStr;
	}

}
