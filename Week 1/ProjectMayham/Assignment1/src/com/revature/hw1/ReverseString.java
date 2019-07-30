package com.revature.hw1;

public class ReverseString {
	
	// Reads through a string backwards and stores each character in another string
	// Then returns that other string.
	public static String rev(String str) {
		String revStr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			revStr = revStr + str.charAt(i);
		}
		return revStr;
	}

}
