package com.revature.junithwone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jackson.homeworkone.Q15Calculator;

class Q15Test 
{

	@Test
	void testAddition() 
	{
		Q15Calculator q15 = new Q15Calculator();
		assertEquals(5, q15.addition(2, 3));
	}

	@Test
	void testSubtraction() 
	{
		Q15Calculator q15 = new Q15Calculator();
		assertEquals(-1, q15.subtraction(2, 3));
	}

	@Test
	void testMultiplication() 
	{
		Q15Calculator q15 = new Q15Calculator();
		assertEquals(6, q15.multiplication(2, 3));
	}

	@Test
	void testDivision() 
	{
		Q15Calculator q15 = new Q15Calculator();
		assertEquals(1, q15.division(3, 3));
	}

}
