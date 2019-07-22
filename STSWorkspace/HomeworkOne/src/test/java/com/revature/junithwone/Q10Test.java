package com.revature.junithwone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.jackson.homeworkone.Q10Ternary;

class Q10Test 
{
	@BeforeEach
	void beforeEach(TestInfo info)
	{
		System.out.println("Initialize Test Data for "+info.getDisplayName());
	}
	
	@Test
	void testMinValue() 
	{
		Q10Ternary q10 = new Q10Ternary();
		assertEquals(2, q10.minValue(2, 3));
	}

}
