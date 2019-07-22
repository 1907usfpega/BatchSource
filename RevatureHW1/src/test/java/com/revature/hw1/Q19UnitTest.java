package com.revature.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Q19UnitTest {

	Q19 bleh = new Q19();
	ArrayList<Integer> aList;
	int[] primeless = {2,4,6,8,9,10};

	
	@Test
	void testAddInts() {
		aList = new ArrayList<Integer>();
		aList = bleh.addInts(10);
		
		for (int i = 0; i < aList.size(); i++)
		{
			System.out.print(aList.get(i) + " ");
		}
	}

	//Throws up a fail message, even if Driver class has correct value...and addInts works fine, but sum returns 0?
	@Test
	void testAddEvens() {
		Integer a = bleh.addEvens(aList);
		System.out.println("Sum of evens is " + a);
		if (a != 30)
		{
			fail("Your evens are odd, man.");
		}
	}

	@Test
	void testAddOdds() {
		if (bleh.addOdds(aList) != 25)
		{
			fail("The odds ain't in your favor, old timer.");
		}
	}

	@Test
	void testRemovePrimes() {
		ArrayList<Integer> noPrimes = bleh.removePrimes(aList);
		//Checks to see if arrays are same size.
		if (noPrimes.size() != primeless.length)
		{
			fail("Your lists ain't matching up.");
		}
		
		for (int i = 0; i < noPrimes.size(); i++)
		{
			int a = noPrimes.get(i);
			int b = primeless[i];
			if (a != b)
			{
				fail("Your numbers ain't matching up.");
			}
		}
	}

}
