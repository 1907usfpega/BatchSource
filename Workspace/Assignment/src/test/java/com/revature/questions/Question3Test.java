package com.revature.questions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question3Test {

	@Test
	void testDoTask() {
		String input = "abcd";
		String expected = "dcba";
		assertEquals(expected, Question3.doTask(input));
	}

}
