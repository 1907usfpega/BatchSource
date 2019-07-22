package com.revature.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q18UnitTest {
	Q18 bleh = new Q18();
	String a = "Bravo";
	String b = "charlie";
	String c = "999";

	@Test
	void testCapsChecker() {
		if (bleh.capsChecker(a) == false || bleh.capsChecker(b) == true)
		{
			fail("Yep, your big letters ain't doing anything.");
		}
	}

	@Test
	void testCapsConvert() {
		String allCaps = bleh.capsConvert(b);
		if (allCaps.equals("CHARLIE") == false)
		{
			fail("ALL CAPS. FOR EMPHASIS.");
		}
	}

	//Currently, this method has no return value. Should I rewrite, or are we good?
	@Test
	void testIntParsePlus10() {
		/*
		 * if (bleh.intParsePlus10(c) != 1009) { fail("Do your math right, dummy."); }
		 */
	}

}
