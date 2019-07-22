package com.revature.junithwone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jackson.homeworkone.Q16StringArgs;

class Q16Test {

	@Test
	void testNumChars() 
	{
		Q16StringArgs q16 = new Q16StringArgs();
		assertEquals(5, q16.numChars("Apple"));
	}

}
