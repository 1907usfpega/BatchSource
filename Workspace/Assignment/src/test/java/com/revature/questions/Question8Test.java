package com.revature.questions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question8Test {

	@Test
	void testIsPali() {
		String input = "RolloR";
		boolean expected = true;
		assertTrue(Question8.isPali(input));
	}

}
