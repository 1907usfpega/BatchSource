package com.revature.questions;

public class Question4 {

	public static int doTask(int n) { //5! = 5*4! = 5*4*3! ... once one is known, the stack can be resolved backwards. don't call with negativ numbers!
		if (n <= 1) {
			return n;
		}	
		return n*doTask(n-1);
	}
}
