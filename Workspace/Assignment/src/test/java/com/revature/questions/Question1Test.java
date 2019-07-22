package com.revature.questions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question1Test {

	@Test
	void testDoTask() {
		int[] input = new int[] { 1, 3, 2 };
		int[] expected = new int[] { 1, 2, 3 };
		assertArrayEquals(expected, Question1.doTask(input));
	}

}
