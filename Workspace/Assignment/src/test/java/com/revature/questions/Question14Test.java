package com.revature.questions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question14Test {

	@Test
	void testGetSqrt() {
		int input = 64;
		int expected = 8;
		assertEquals(expected, Question14.getSqrt(input));
	}

}
