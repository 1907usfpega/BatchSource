package com.revature.driver;

public class Question12 {
	protected static int[] nums = new int[100];

	// fill in array from 1 -100
	private void init() {
		for (int i = 1; i < 101; i++) {
			nums[i - 1] = i;
		}
	}

	// returns all even ints from 1 - 100
	public String getEvens() {
		this.init();
		StringBuilder sb = new StringBuilder();
		for (int i : nums) {
			if (i % 2 == 0) {
				sb.append(i + " ");
			}
		}

		return sb.toString().trim();
	}

	protected void prompt() {
		System.out.println("Question 12: ");
		System.out.print("Solution: ");
	}

}
