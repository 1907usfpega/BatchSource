package com.revature.junithwone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jackson.homeworkone.Q14SwitchCase;

class Q14Test 
{

	@Test
	void testSquareRoot() 
	{
		Q14SwitchCase q14 = new Q14SwitchCase();
		assertEquals(2, Q14SwitchCase.squareRoot(4));
	}
}
