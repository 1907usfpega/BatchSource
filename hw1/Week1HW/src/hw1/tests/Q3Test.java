package hw1.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q3Test {
	
	@Test
	void testQ3() {
		//FIXME assert(expected, actual)
		String expected = "olleh";
		String actual = hw1.hollander.ben.Q3ReverseString.q3("hello");
		assertEquals(expected, actual);
	}

}
