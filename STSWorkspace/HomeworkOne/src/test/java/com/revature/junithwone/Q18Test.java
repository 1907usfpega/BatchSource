package com.revature.junithwone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jackson.homeworkone.Q18ChildClass;

class Q18Test {

	@Test
	void testCheckUppercase() 
	{
		Q18ChildClass q18 = new Q18ChildClass();
		assertEquals(true, q18.checkUppercase("Apple"));
	}

	@Test
	void testLowerToUpper() 
	{
		Q18ChildClass q18 = new Q18ChildClass();
		assertEquals("APPLE", q18.lowerToUpper("Apple"));
	}

	@Test
	void testAddTen() 
	{
		Q18ChildClass q18 = new Q18ChildClass();
		assertEquals(27, q18.addTen("17"));
	}

}
