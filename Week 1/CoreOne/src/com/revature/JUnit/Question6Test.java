package com.revature.JUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.revature.driver.Question6;

class Question6Test {

	@Test
	void intTest() {
		for (int i = -10; i < 100; i+=2) {
			assertTrue(Question6.isIntEven(i+""));
		}
		
	}
	@Test
	void doubleTest() {
		for (double i = -10.0; i < 100.0; i+=2.0) {
			assertTrue(Question6.isIntEven(i+""));
		}
		
	}
	@Test
	void StringTest() {
		
		assertFalse(Question6.isIntEven("a"));
		assertFalse(Question6.isIntEven("4.I HELLOi"));
			
		
	}

}
