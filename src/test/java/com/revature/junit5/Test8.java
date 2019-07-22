package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.questions.Q8;

class Test8 {

	@Test
	void testSavePalindromes() {
		String result = "[madam, civic, radar, kayak, refer, did]";
		assertEquals(result, Q8.savePalindromes());
	}

}
