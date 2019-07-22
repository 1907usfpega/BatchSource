package com.revature.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q10UnitTest {
	
	Q10 bleh = new Q10();

	@Test
	void testTernaryOp() {
		int a = 45;
		int b = 56;
		int c = 67;
		int ans1 = bleh.ternaryOp(a, b);
		int ans2 = bleh.ternaryOp(c, b);
		
		if (ans1 != a || ans2 != b)
		{
			fail("That's wrong you dingus. Might want to check that.");
		}	
	}

}
