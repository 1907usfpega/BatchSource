package hw1.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hw1.hollander.ben.Q18;

class Q18Test {

	@Test
	void test() {
		Q18 testInstance = new Q18();
		assertTrue(testInstance.hasUppercase("Hello"));
		
		String expectedString = "HELLO";
		assertEquals(expectedString, testInstance.toUppercase("hello"));
		
		Integer expectedInt = 20;
		assertEquals(expectedInt, testInstance.parseInt("10"));
	}

}
