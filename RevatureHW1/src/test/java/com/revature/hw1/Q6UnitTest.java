package com.revature.hw1;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Q6UnitTest {

	@Test
	@DisplayName("Even Check Test")
	void testEvenFlow() {
		int a = 88;
		int b = 75;
		if (Q6.evenFlow(a) == false)
		{
			fail("That number's even ya dingus. Git gud");
		}
		if (Q6.evenFlow(b) == true)
		{
			fail("That number ain't even. Whattaya doin'?!");
		}
		System.out.println("Q6: " + a + " is even = " + Q6.evenFlow(a));
		System.out.println("Q6: " + b + " is even = " + Q6.evenFlow(b));	}

}
