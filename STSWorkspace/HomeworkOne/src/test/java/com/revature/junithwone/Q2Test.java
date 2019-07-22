package com.revature.junithwone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.jackson.homeworkone.Q2Fibonacci;

class Q2Test 
{

	@BeforeEach
	void beforeEach(TestInfo info)
	{
		System.out.println("Initialize Test Data for "+info.getDisplayName());
	}
	
	
	@Test
	@DisplayName("25th Fibonacci Number Check")
	void testFibonacci() 
	{
		Q2Fibonacci q2 = new Q2Fibonacci();
		assertEquals(75025, q2.fibonacci(25));
	}

}
