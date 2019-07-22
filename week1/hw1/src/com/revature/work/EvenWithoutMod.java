package com.revature.work;

public class EvenWithoutMod {

	//says weather a number is even or not and returns a bool
	public static boolean ewm(int x) {
		int q=x/2;
		if (q*2==x) {
			System.out.println("Even");
			return true;
		}
		else
			System.out.println("Odd");
		return false;
	}

}
