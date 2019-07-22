package com.revature.junithwone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.jackson.homeworkone.Q11AccessFloats;

class Q11Test 
{
	@BeforeEach
	void beforeEach(TestInfo info)
	{
		System.out.println("Initialize Test Data for "+info.getDisplayName());
	}
	
	@Test
	void testAddTheseNums() 
	{
		Q11AccessFloats q11 = new Q11AccessFloats();
		assertEquals(30, q11.addTheseNums());
	}

}
