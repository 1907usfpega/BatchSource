package com.revature.hw1;

public class Substring {

	public static String substr(String str, int idx) {
		
		String substring = "";
		
		// Checks if the index given is larger than the length of the string given.
		if(idx > str.length()) {
			System.out.println("ERROR! INDEX IS LARGER THAN THE LENGTH OF THE STRING! RETURNING NULL!");
			return null;
		}
		
		// adds each character in the string up to the stop index to the substring
		// then returns the substring.
		for (int i = 0; i < idx; i++) {
			substring = substring + str.charAt(i);
		}
		
		return substring;
	}
	
}