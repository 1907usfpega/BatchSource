package com.revature.questions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.driver.Driver;

class Question11Test {

	@Test
	void testDoTask() {
		float[] expected = new float[] {
		Driver.question11Float1 = 2f,
		Driver.question11Float2 = 5f};
		assertArrayEquals(expected, Question11.doTask());
	}
}
