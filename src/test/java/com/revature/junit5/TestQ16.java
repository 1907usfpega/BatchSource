package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.questions.Q16;

class TestQ16 {

	@Test
	void testCountInput() {
		String[] args = {"x","y","z"};
		assertEquals(3,Q16.countInput(args));
	}

}
