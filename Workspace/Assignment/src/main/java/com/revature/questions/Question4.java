package com.revature.questions;

public class Question4 {

	public static int doTask(int n) {
		if (n == 1) {
			return n;
		}	
		return n*doTask(n-1);
	}
}
