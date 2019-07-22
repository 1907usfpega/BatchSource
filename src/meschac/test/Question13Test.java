package meschac.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question13Test {

	@Test
	void test() {
		/*
		 * 0 
		 * 1 0
		 * 1 0 1
		 * 0 1 0 1
		 */
		String expected = "0 \n1 0 \n1 0 1 \n0 1 0 1 \n";
		String actual = com.meschac.mafoula.Question13.q13();
		assertEquals(expected, actual);
	}

}
