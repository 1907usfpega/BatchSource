package com.revature.JUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.revature.driver.Question3;

class Question3Test {
	String s = "test";
	StringBuffer test = new StringBuffer("test");
	@Test
	void testReverse() {
		Question3 q3 = new Question3();
		assertTrue(test.reverse().toString().equals(q3.run(s)));
	}

}
