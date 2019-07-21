package com.revature.JUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.revature.driver.Question20;

public class Question20Test {
	
	@Test
	void test() {
		String[] line = Question20.formatFile().split("\n");
		
		assertFalse(line[2].trim().equals("Name: Mickey Mouse"));
		assertTrue(line[3].trim().equals("State: Arizona"));
		assertTrue(line[11].trim().equals("State: California"));
		assertTrue(line[1].trim().equals("Name: Mickey Mouse"));
	}
}
