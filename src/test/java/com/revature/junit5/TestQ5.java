package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.questions.Q5;

class TestQ5 {

	@Test
	void testSubstring() {
		assertEquals("Frame",Q5.substring("Framework", 5));
	}

}
