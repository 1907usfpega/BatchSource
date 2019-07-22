package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.questions.Q6;

class TestQ6 {

	@Test
	void testIsEven() {
		assertEquals(false, Q6.isEven(25));		

		assertEquals(true, Q6.isEven(34));
	}

}
