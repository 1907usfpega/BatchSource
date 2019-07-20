package com.revature.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.driver.Question13;

class Question13Test {

	@Test
	void TriangleTest() {
		String correct = "0 \n1 0 \n1 0 1 \n0 1 0 1";
		System.out.println(correct);
		System.out.println(Question13.printTriangle());
		assertTrue(Question13.printTriangle().equals(correct));
	}

}
