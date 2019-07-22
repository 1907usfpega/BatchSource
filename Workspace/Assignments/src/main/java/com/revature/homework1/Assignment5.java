package com.revature.homework1;

public class Assignment5 {
	public static String substringMethod(String s, int iNumber){
		//char array
		if (iNumber > s.length()-1){
			return s;
		}
		char[] charSomething = s.toCharArray();
		s = "";
		for (int i = 0; i < iNumber ; i++) {
			s += charSomething[i];
		}
		return s;
	}

}
