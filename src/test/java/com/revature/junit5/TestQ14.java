package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.questions.Q14;

class TestQ14 {

	@Test
	void testDoSwitch() {
		String s = Q14.doSwitch(3);
		assertEquals("8.0",Q14.doSwitch(1));//64 SquareRoot
		assertEquals("07/22/2019",Q14.doSwitch(2));//today's date
		assertEquals("23",Q14.doSwitch(3)); //array size
	}

}
