package com.revature.utils;

public class MyFunctions {
	public static float float1;
	public static float float2;
	
	// return if it's even
	public static boolean isEven(int num) {
		if (num % 2 == 0) {
			return true;
		}
		return false;
	}

	// return if it's odd
	public static boolean isOdd(int num) {
		if (num % 2 != 0) {
			return true;
		}
		return false;
	}
}
