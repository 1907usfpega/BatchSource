package com.revature.work;

public class SubString {
	
	public static char[] shortString(String s, int i) {
		char[] newString=new char[i];
		for (int j=0;j<i;j++) {
			newString[j]=s.charAt(j);
		}
		return newString;
	}

}
