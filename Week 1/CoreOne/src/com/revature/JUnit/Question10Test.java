package com.revature.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.driver.Question10;

class Question10Test {

	@Test
	void testMin() {
		assertTrue(3 == Question10.getMin("3", "4" ));
		assertTrue(4 != Question10.getMin("3.4", "4"));
		assertTrue(-1 == Question10.getMin("a", "b"));
	}

}
