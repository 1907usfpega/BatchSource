package com.revature.questions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question6Test {

	@Test
	void testDoTask() {
		int input = 11;
		boolean expected = false;
		assertFalse(Question6.doTask(input));
	}

}
