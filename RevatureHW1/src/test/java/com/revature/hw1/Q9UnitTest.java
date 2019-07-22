package com.revature.hw1;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Q9UnitTest {

	int[] confirmedPrime = {1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
	
	@Test
	void testPrimeParse() {
		ArrayList<Integer> testPrimes = Q9.primeParse();
		
		//Checks to see if array is same size as confirmed array.
		if (testPrimes.size() != confirmedPrime.length)
		{
			fail("There aren't the same amount of numbers here. Sure you got them all?");
		}
		
		//Confirms that values match up.
		for (int i = 0; i < testPrimes.size(); i++)
		{
			if (testPrimes.get(i) != confirmedPrime[i])
			{
				fail("The numbers Mason, what do they mean?!");
			}
		}
	}

}
