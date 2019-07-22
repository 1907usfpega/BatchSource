package com.revature.junithwone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.jackson.homeworkone.Q5Substring;

class Q5Test 
{

	@BeforeEach
	void beforeEach(TestInfo info)
	{
		System.out.println("Initialize Test Data for "+info.getDisplayName());
	}
	
	@Test
	@DisplayName("Substring Check")
	void testMySubstring() 
	{
		Q5Substring q5 = new Q5Substring();
		assertEquals("App", q5.mySubstring("Apple", 3));
	}

}
