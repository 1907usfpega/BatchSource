package hw1.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q4Test {

	@Test
	void Q4Factorial() {
		int expected = 6;
		int actual = hw1.hollander.ben.Q4Factorial.q4(3);
		assertEquals(expected, actual);
	}

}
