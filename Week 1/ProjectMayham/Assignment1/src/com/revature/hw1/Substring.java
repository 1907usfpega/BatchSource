package com.revature.hw1;

public class Substring {

	public static String substr(String str, int idx) {
		
		String substring = "";
		
		if(idx > str.length()) {
			System.out.println("ERROR! INDEX IS LARGER THAN THE LENGTH OF THE STRING! RETURNING NULL!");
			return null;
		}
		
		for (int i = 0; i < idx; i++) {
			substring = substring + str.charAt(i);
		}
		
		return substring;
	}
	
}