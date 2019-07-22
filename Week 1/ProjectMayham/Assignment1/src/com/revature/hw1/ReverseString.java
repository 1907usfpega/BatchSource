package com.revature.hw1;

public class ReverseString {
	
	public static String rev(String str) {
		String revStr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			revStr = revStr + str.charAt(i);
		}
		return revStr;
	}

}
