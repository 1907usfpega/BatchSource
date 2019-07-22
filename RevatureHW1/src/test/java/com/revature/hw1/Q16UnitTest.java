package com.revature.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q16UnitTest {
	

	@Test
	void testCharCounter() {
		if (Q16.charCounter("Gamera") != 6)
		{
			fail("Gamera is not pleased. He's a friend to all children. You pissed off the kids.");
		}
	}

}
