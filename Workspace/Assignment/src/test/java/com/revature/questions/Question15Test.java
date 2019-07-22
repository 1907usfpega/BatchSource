package com.revature.questions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question15Test {

	@Test
	void testMultiplication() {
		int input1 = 5;
		int input2 = 10;
		int expected = input1*input2;
		Question15 q15 = new Question15();
		assertEquals(expected, q15.multiplication(input1, input2));
	}

}
