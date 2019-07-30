package com.revature.hw1;

public class IsEven {
	
	// Determines if a value is even by dividing
	// by two and then multiplying by two and seeing
	// if we get the same number.
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
