package com.revature.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q15UnitTest {
	Q15 bleh = new Q15();
	Double a = 4.2;
	Double b = 69.69;

	@Test
	void testAddition() {
		if(bleh.addition(a, b) != 73.89)
		{
			fail("That don't add up.");
		}
	}

	@Test
	void testSubtraction() {
		if (bleh.subtraction(a, b) != -65.49)
		{
			fail("The numbers lie.");
		}
	}

	@Test
	void testMultiplication() {
		if (bleh.multiplication(a, b) != 292.698);
		{
			fail("You got 8 1/3 percents AT BEST, at beating me.");
		}
	}

	@Test
	void testDivision() {
		if (bleh.division(a, b) != 0.06026689625484288)
		{
			fail("Cause Kurt Angle KNOWS he can't beat me, and he's not even gonna try.");
		}
	}

}
