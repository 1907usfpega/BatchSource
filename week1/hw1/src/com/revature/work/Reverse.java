package com.revature.work;

public class Reverse {

	public static void turnAround(String s) {
		for(int i=s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
	}
	
}
