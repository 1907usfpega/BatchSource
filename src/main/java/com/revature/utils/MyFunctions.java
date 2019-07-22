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

	public static boolean isPrime(int num) {
		{
			for(int i = 2; i <= num/2; ++i)
			// condition for nonprime number
			if (num % i == 0) {
				return false;
			}
			return true;
		}
	}
}
