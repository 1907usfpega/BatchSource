package com.revature.driver;

public class Question2 {
	protected void run() {
		System.out.println("Question 2: ");
		System.out.print("Solution: ");
		int a = 0;
		int b = 1;
		int c;
		System.out.print(a + " " + b + " ");
		for(int i = 0; i < 23; i++) {
			c = a + b;
			System.out.print(c + " ");
			a = b;
			b = c;
		}
		System.out.println();
	}
}
