package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.questions.Q9;

class Test9 {

	@Test
	void testPrintPrime() {
		String result = "2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 ";
		assertEquals(result, Q9.printPrime());
	}

}
