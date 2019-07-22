package com.revature.questions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question12Test {

	@Test
	void testDoTask() {
		int[] expected = new int[50];
		for (int i = 1; i <= 50; i++) {
			expected[i-1] = i*2;
		}
		assertArrayEquals(expected, Question12.doTask());
	}

}
