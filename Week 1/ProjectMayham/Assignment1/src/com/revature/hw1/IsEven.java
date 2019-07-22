package com.revature.hw1;

public class IsEven {
	
	public static boolean isEven(int i) {
		int half = i / 2;
		int whole = half * 2;
		if (whole == i) {
			return true;
		} else {
			return false;
		}
	}
	
}
