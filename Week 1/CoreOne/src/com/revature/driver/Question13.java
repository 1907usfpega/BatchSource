package com.revature.driver;

public class Question13 {
	protected void printTriangle() {
		int k = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(k + " ");
				k = (k == 1) ? 0 : 1;
			}
			System.out.println();
		}
	}
	protected void prompt() {
		System.out.println("Question 13: ");
		System.out.println("Solution: ");
	}
}
