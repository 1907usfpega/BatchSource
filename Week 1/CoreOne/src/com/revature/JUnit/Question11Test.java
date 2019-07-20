package com.revature.JUnit;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import com.revature.driver.Question11;

class Question11Test {

	@Test
	void test() {
		Question11 q11 = new Question11();
		float[] difClassFloats = q11.run();
		assertTrue(difClassFloats[0] == (float)1.0);
		assertTrue(difClassFloats[1] == (float)2.0);
	}

}
