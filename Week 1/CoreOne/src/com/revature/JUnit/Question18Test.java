package com.revature.JUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.revature.driver.Question18ConcreteSubclass;

class Question18Test {

	@Test
	void test() {
		Question18ConcreteSubclass q = new Question18ConcreteSubclass();
		assertTrue(q.anyUpper("heLLob3"));
		assertFalse(q.anyUpper("hi9"));
		assertTrue(q.toUpper("hellO3").equals("HELLO3"));
		assertFalse(q.toUpper("hello").equals("hello"));
		
	}

}
