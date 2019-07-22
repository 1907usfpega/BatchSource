package meschac.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question4Test {

	@Test
	void test() {
		int expected = 6;
		int actual = com.meschac.mafoula.Question4.q4(3);
		assertEquals(expected, actual);
	}

}
