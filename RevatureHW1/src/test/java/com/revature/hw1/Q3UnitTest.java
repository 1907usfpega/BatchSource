package com.revature.hw1;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Q3UnitTest {

	@Test
	@DisplayName("Inverter Test")
	void testStringInvert() {
		String before = "Saban";
		String after = Q3.stringInvert(before);
		System.out.println("Q3: Reverse of " + before + 
				" is " + after);
		if (after.equals("nabaS") == false)
		{
			fail("String did not reverse correctly. Git gud.");
		}
	}

}
