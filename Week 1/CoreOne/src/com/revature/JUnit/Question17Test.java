package com.revature.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.driver.Question17;

class Question17Test {

	@Test
	void test() {
		assertTrue(Question17.sInterest(100, .05, 1) == 5);
	}

}
