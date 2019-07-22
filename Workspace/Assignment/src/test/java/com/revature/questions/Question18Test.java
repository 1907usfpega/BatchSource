package com.revature.questions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question18Test {

	@Test
	void testContainsUppercase() {
		String input = "asdiahsgfdsabfIrtyhujaiop";
		Question18 q18 = new Question18();
		assertTrue(q18.containsUppercase(input));
	}

}
