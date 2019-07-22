package com.revature.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q12UnitTest {

	@Test
	void testEnhancedLoopEvens() {
		int[] evenArray = new int[101];
		for (int i = 0; i < evenArray.length; i++)
		{
			evenArray[i] = i;
		}
		System.out.print("Q12: ");
		Q12.enhancedLoopEvens(evenArray);	}

}
