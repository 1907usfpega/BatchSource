package hw1.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q13Test {

	@Test
	void test() {
		/*
		 * 0 
		 * 1 0
		 * 1 0 1
		 * 0 1 0 1
		 */
		String expected = "0 \n1 0 \n1 0 1 \n0 1 0 1 \n";
		String actual = hw1.hollander.ben.Q13.q13();
		assertEquals(expected, actual);
				
	}

}
