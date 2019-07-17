package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StringTest 
{
	@BeforeAll
	static void beforeAll()
	{
		System.out.println("Before All");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info)
	{
		System.out.println("Initialize Test Data for "+info.getDisplayName());
	}
	
	@Test
	@DisplayName("Length Check")
	void meh() 
	{
		//fail("Not yet implemented");
		int actualLength = "ABCD".length();
		int expectedLength = 4;
		//assertEquals( expected value, actual value)
		assertEquals(expectedLength, actualLength);
	}
	
	@Test
	@DisplayName("Upper Case Check")
	void toUpperCase()
	{
		String str = "abcd";
		String result = str.toUpperCase();
		assertEquals("ABCD", result);
	}
	@Test
	@DisplayName("Check for Exception")
	void lengthException()
	{
		String s = null;
		assertThrows(NullPointerException.class, 
				()->{
					s.length();
				});
	}
	
	@Nested
	@DisplayName("StringNestingTests")
		class A
		{
			@Test
			@DisplayName("Length Check 2")
			void meh() 
			{
				int actualLength = "ABCD".length();
				int expectedLength = 4;
				assertEquals(expectedLength, actualLength);
			}
		}
		
}
