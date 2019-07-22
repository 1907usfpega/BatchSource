package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.revature.questions.Q15;

class TestQ15 {

	@Test
	void testSum() {
		Q15 q15 = new Q15();
		assertEquals(5,q15.sum(2, 3));
	}

	@Test
	void testMultiply() {
		Q15 q15 = new Q15();
		assertEquals(6,q15.multiply(2, 3));
	}

	@Test
	void testDivide() {
		Q15 q15 = new Q15();
		assertEquals(2,q15.divide(10, 5));
	}

	@Test
	void testSubstract() {
		Q15 q15 = new Q15();
		assertEquals(5,q15.substract(10, 5));
	}

}
