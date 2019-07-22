package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.questions.Q3;

class TestQ3 {

	@Test
	void testReverseString() {
		assertEquals("anayad", Q3.reverseString("dayana"));
	}

}
