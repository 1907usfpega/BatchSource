package com.revature.junithwone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.jackson.homeworkone.Q13ConsoleTriangle;

class Q13Test {

	@Test
	void testPrintTriangle() 
	{
		Q13ConsoleTriangle q13 = new Q13ConsoleTriangle();
		assertEquals("0101", q13.printTriangle(4));
	}

}
