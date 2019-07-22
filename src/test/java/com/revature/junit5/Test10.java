package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.questions.Q10;

class Test10 {

	@Test
	void test() {
		assertEquals(64,Q10.findMin(84, 64));
	}

}
