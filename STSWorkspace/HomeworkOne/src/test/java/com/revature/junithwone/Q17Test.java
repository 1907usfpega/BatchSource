package com.revature.junithwone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jackson.homeworkone.Q17Interest;

class Q17Test {

	@Test
	void testSimpleInterest() 
	{
		Q17Interest q17 = new Q17Interest();
		assertEquals(11937.5, q17.simpleInterest(10000, 3.875, 5));
	}

}
