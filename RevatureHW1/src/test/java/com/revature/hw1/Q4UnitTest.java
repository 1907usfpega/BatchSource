package com.revature.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q4UnitTest {

	@Test
	void testNFactorial() {
		int n = 7;
		int ans = Q4.nFactorial(n);
		System.out.println("Q4: n factorial of " + n + " is "
				+ Q4.nFactorial(n));
		if (ans != 5040)
		{
			fail("n factorial didn't do right. Git gud.");
		}
	}

}
