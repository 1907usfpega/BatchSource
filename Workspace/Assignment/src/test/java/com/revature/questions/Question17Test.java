package com.revature.questions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question17Test {

	@Test
	void testToInt() {
		String input = "1234";
		int expected = 1234;
		assertEquals(expected, Question17.toInt(input));
	}

}
