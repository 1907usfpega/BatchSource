package com.revature.questions;
//Q4. Write a program to compute N factorial.

public class Q4 {

	public static void main(String[] args) {
		//define factorial #
		int factorial = 9;		
		int next = factorial-1;
		
		//multiply decrementing -1 each iteraction
		while(next>0) {
			factorial = factorial * next;
			next --;
		}
		
		//should print 362880
		System.out.println(factorial);

	}

}
