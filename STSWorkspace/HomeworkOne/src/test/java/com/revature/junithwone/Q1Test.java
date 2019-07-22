package com.revature.junithwone;

import static org.junit.jupiter.api.Assertions.*;
import com.jackson.homeworkone.Q1BubbleSort;

//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class Q1Test 
{

	@BeforeEach
	void beforeEach(TestInfo info)
	{
		System.out.println("Initialize Test Data for "+info.getDisplayName());
	}
	
	@Test
	@DisplayName("Bubble Sort Check")
	void question1Test() 
	{
		Q1BubbleSort q1 = new Q1BubbleSort();
		int[] testArray = {1,0,5,6,3,2,3,7,9,8,4};
		int[] expectedArray = {0,1,2,3,3,4,5,6,7,8,9};
		
		//assertEquals( expected value, tested value)
		//assertArrayEquals(expected array, tested array)
		assertArrayEquals(expectedArray, q1.bubbleSort(testArray));
	}

}
