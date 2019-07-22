package com.revature.junithwone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.jackson.homeworkone.Q4Factorial;

class Q4Test 
{

	@BeforeEach
	void beforeEach(TestInfo info)
	{
		System.out.println("Initialize Test Data for "+info.getDisplayName());
	}
	
	@Test
	@DisplayName("n-Factorial Check")
	void testFactorial() 
	{
		Q4Factorial q4 = new Q4Factorial();
		assertEquals(120, q4.factorial(5));
	}

}
