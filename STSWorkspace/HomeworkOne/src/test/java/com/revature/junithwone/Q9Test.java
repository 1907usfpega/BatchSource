package com.revature.junithwone;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.jackson.homeworkone.Q9PrimeNums;

class Q9Test 
{
	@BeforeEach
	void beforeEach(TestInfo info)
	{
		System.out.println("Initialize Test Data for "+info.getDisplayName());
	}
	
	@Test
	void testFindPrimes() 
	{
		Q9PrimeNums q9 = new Q9PrimeNums();
		Integer[] expectedResult = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		ArrayList<Integer> s = q9.findPrimes();
		Integer[] actualResult = new Integer[s.size()];
		s.toArray(actualResult);
		assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	void testIsPrime() 
	{
		assertEquals(false, Q9PrimeNums.isPrime(9));
	}

}
