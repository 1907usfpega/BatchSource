package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.questions.Q11;
import com.revature.utils.MyFunctions;

class Test11 {

	@Test
	void testGetfloat1() {
		MyFunctions.float1 = 2;
		assertEquals(Q11.getfloat1(),MyFunctions.float1);
	}

	@Test
	void testGetfloat2() {
		MyFunctions.float2 = 1.5f;
		assertEquals(Q11.getfloat2(),MyFunctions.float2);
	}

}
