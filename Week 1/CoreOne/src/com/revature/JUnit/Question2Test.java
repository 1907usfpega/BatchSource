package com.revature.JUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.revature.driver.Question2;

class Question2Test {

	String answer = "0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 28657 46368 ";
	@Test
	void test() {
		Question2 q2 = new Question2();
		assertTrue(answer.equals(q2.run()));
	}

}
