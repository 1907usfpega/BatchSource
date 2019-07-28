package hw1.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q5Test {

	@Test
	void q5Test() {
		String expected = "hell";
		int idx = 4;
		String actual = hw1.hollander.ben.Q5Substring.q5("hello", idx);
		assertEquals(expected, actual);
		
	}

}
