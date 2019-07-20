package com.revature.JUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.revature.driver.Question12;

class Question12Test {

	@Test
	void test() {
		String correct = "2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 52 54 56 58 60 62 64 66 68 70 72 74 76 78 80 82 84 86 88 90 92 94 96 98 100";
		Question12 q12= new Question12();
		assertTrue(q12.getEvens().equals(correct));
	}

}
