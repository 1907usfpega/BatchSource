package com.revature.JUnit;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.revature.driver.Question15;

class Question15Test {

	@Test
	void test() {
		Question15 q15 = new Question15();
		assertTrue(q15.addition(1, 2) == 3);
		assertTrue(q15.subtraction(3, 4) == -1);
		assertTrue(q15.multiplication(3, 4) == 12);
		assertTrue(q15.division(6, 3) == 2);
	}

}
