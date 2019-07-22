package com.revature.questions;

public class Question6 {
	public static boolean doTask(int n) {		//int 5/2 will be 2. Times 2 will be 4 and not equal to the input.
		if(n == (n/2)*2) {
			return true;
		}
		return false;
	}
}
