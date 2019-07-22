package com.revature.hw1;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Q5UnitTest {

	@Test
	@DisplayName("Substring Test")
	void testIndexSubstring() {
		String q5 = "Countries";
		String q5A = Q5.indexSubstring(q5, 5);
		System.out.println("Q5: " + q5 + "'s substring is " + q5A);
		if (q5A.equals("Count") == false)
		{
			fail("Didn't cut the string right. Git gud.");
		}
	}

}
