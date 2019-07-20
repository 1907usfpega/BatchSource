package com.revature.driver;

public class Question13 {
	public static String printTriangle() {
		int k = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				sb.append(k + " ");
				k = (k == 1) ? 0 : 1;
			}
			sb.append("\n");
		}
		return sb.toString().trim();
	}
	protected void prompt() {
		System.out.println("Question 13: ");
		System.out.println("Solution: ");
	}
}
