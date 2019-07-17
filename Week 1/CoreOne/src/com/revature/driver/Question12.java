package com.revature.driver;

public class Question12 {
	protected static int[] nums = new int[100];

	protected void init() {
		for (int i = 1; i < 101; i++) {
			nums[i - 1] = i;
		}
	}

	protected void printEvens() {
		for (int i : nums) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	protected void prompt() {
		System.out.println("Question 12: ");
		System.out.print("Solution: ");
	}

}
