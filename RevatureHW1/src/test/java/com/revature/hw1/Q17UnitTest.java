package com.revature.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q17UnitTest {
	
	double a = 10000.00;
	double b = 0.15;
	double c = 2.5;

	@Test
	void testGetInterest() {
		double interest = Q17.getInterest(a, b, c);
		if(interest != 3750.00)
		{
			fail("Shoulda handled your money better.");
		}
	}

}
