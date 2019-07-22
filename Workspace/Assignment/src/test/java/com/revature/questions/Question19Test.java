package com.revature.questions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Question19Test {

	@Test
	void testAddEmUp() {
		ArrayList<Integer> input = new ArrayList<Integer>();
		int expected = 0;
		for (int i = 0; i < 20 ; i++) {
			input.add(i);
			expected += i;
		}
		assertEquals(expected, Question19.addEmUp(input));
	}

}
