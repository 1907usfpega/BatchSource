package com.revature.junithwone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.jackson.homeworkone.Q3ReverseString;

class Q3Test 
{
	@BeforeEach
	void beforeEach(TestInfo info)
	{
		System.out.println("Initialize Test Data for "+info.getDisplayName());
	}
	
	@Test
	@DisplayName("Reverse String Check")
	void testReverseString() 
	{
		Q3ReverseString q3 = new Q3ReverseString();
		assertEquals("elppA", q3.reverseString("Apple"));
	}

}
