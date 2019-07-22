package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.questions.Q19;

class TestQ19 {

	@Test
	void testSumOdd() {
		Q19 q19 = new Q19();
		assertEquals(25,q19.sumOdd(q19.listArray));
	}

	@Test
	void testSumEven() {
		Q19 q19 = new Q19();
		assertEquals(30,q19.sumEven(q19.listArray));
	}

}
