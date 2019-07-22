package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.questions.Q17;

class TestQ17 {

	@Test
	void testCalcInterest() {
		//Interest = Rate*Principal*Time
		assertEquals("8.0", Q17.calcInterest(0.04, 100, 2));
	}

}
