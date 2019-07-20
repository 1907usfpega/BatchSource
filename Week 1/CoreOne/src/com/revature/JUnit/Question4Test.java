package com.revature.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.driver.Question4;

class Question4Test {

	
	@Test
	void FactorialTest() {
		int fac = 1;
		Question4 q4 = new Question4();
		for(int i = 1; i < 100; i++) {
			assertEquals(q4.factorial(i), fac*=i);
		}
		assertEquals(q4.factorial(0), 1);
	}

}
