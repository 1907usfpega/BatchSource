package hw1.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hw1.hollander.ben.Q15;

class Q15Test {

	@Test
	void test() {
		
		Q15 testInstance = new Q15();
		double expected = 2;
		double actual = testInstance.add(1, 1);
		assertEquals(expected, actual);
		
		actual = testInstance.subtract(4, 2);
		assertEquals(expected, actual);
		
		actual = testInstance.multiply(1, 2);
		assertEquals(expected, actual);
		
		actual = testInstance.divide(4,  2);
		assertEquals(expected, actual);
	}

}
