package com.revature.questions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question9Test {

	@Test
	void testIsPrime() {
		int input = 89;
		assertTrue(Question9.isPrime(input));
	}

}
