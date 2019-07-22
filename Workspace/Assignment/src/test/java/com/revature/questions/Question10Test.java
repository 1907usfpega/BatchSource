package com.revature.questions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question10Test {

	@Test
	void testDoTask() {
		int input1 = 1234;
		int expected = 123;
		assertEquals(expected, Question10.doTask(input1, expected));
	}

}
