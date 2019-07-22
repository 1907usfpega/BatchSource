package meschac.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.meschac.mafoula.Question16;

class Question16Test {

	@Test
	void test() {
		 Question16 testInstance = new Question16();
			int expected = 5;
			int actual = testInstance.q16(new String[] {"hello"}); //pass in String[] args to function
			assertEquals(expected, actual);
	}

}
