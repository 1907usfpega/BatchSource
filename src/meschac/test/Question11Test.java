package meschac.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question11Test {

	@Test
	void test() {

		
			float expected1 = 1.5f;
			float expected2 = 2.5f;
			float[] returnData = com.meschac.mafoula.Question11.q11();
			float actual1 = returnData[0];
			float actual2 = returnData[1];
			
			assertEquals(expected1, actual1);
			assertEquals(expected2, actual2);
	}

}
