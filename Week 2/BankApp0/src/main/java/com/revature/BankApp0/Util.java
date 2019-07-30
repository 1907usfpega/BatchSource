package com.revature.BankApp0;

public class Util {
	
	public static String substr(String s, int idx, int idy) {
		String output = "";
		for(int i = idx;i<idy;i++) {
			output = output + s.charAt(i);
		}
		return output;
	}
	
	public static boolean isValidDouble(String s) {
		int decimalLoc = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '.') {
				decimalLoc = i;
				break;
			}
		}
		if (decimalLoc == 0) return isInteger(s);
		String preDecimal = substr(s,0,decimalLoc);
		String postDecimal = substr(s,decimalLoc+1,s.length());
		if (postDecimal.length() > 2) return false;
		if (isInteger(preDecimal)) {
			if(isInteger(postDecimal)) return true;
		}
		return false;
	}

	public static boolean isInteger(String s) {
		return isInteger(s, 10);
	}
	
	public static boolean isInteger(String s, int radix) {
		if(s.isEmpty()) return false;
		for(int i = 0; i < s.length(); i++) {
			if (i == 0 && s.charAt(i) == '-') {
				if (s.length() == 1) return false;
				else continue;
			}
			if(Character.digit(s.charAt(i), radix) < 0) return false;
		}
		return true;
	}
	
}
