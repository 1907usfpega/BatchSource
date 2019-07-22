package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.questions.Q13;

class TestQ13 {

	@Test
	void testPrintTriagle() {
		String result = "0\n" + 
						"10\n" + 
						"101\n" + 
						"0101\n";
		assertEquals(result, Q13.printTriagle());
	}

}
