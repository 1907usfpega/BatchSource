package com.revature.hw1;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class Q1UnitTest {
	
	int[] q1 = {0,1,5,6,3,2,3,7,9,8,4};
	

	@BeforeAll
	static void beforeTest()
	{
		System.out.println("Array pre-sort");		
	}
	

	@Test
	@DisplayName("Sort Check")
	void testBubbleSort() 
	{
		int[] q1A = Q1.bubbleSort(q1);
		for (int i = 0; i < q1A.length-1; i++)
		{
			System.out.print(i + " ");
			if (q1A[i] > q1A[i+1])
			{
				fail("Method did not sort correctly");
			}
		}
		System.out.println("");	
	}

}
