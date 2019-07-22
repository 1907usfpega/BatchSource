package com.revature.questions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question5Test {

	@Test
	void testDoTask() {
		String str = "rollercoaster";
		int idx = 5;
		String expected = "rolle";
		assertEquals(expected, Question5.doTask(str, idx));
	}

}
