package com.revature.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.driver.Question16;

class Question16Test {

	@Test
	void test() {
		Question16 q16 = new Question16();
		String[] s = {"this one", "and this one"};
		int correct = (s[0].length()+s[1].length());
		
		assertTrue(q16.length(s) == (correct));
	}


}
