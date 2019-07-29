package hw1.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q10Test {

	@Test
	void q10Test() {
		int expected = 1;
		int actual = hw1.hollander.ben.Q10Ternary.q10(1, 2);
		assertEquals(expected, actual);
		
		actual = hw1.hollander.ben.Q10Ternary.q10(2,  1);
		assertEquals(expected, actual);
	}

}
