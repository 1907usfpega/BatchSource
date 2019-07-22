package meschac.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question5Test {

	@Test
	void test() {
		String expected = "hell";
		int idx = 4;
		String actual = com.meschac.mafoula.Question5.q5("hello", idx);
		assertEquals(expected, actual);
	}

}
