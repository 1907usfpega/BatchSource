package com.revature.questions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question2Test {

	@Test
	void testDoTask() {
		int expectedOutcome = 46368;
		assertEquals(expectedOutcome, Question2.doTask());
	}

}
