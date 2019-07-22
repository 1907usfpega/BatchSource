package com.revature.questions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question4Test {

	@Test
	void testDoTask() {
		int input = 5;
		int expected = 120;
		assertEquals(expected, Question4.doTask(input));
	}

}
