package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.questions.Q4;

class TestQ4 {

	@Test
	void testCalcFactorial() {
		assertEquals(362880,Q4.calcFactorial(9));
	}

}
