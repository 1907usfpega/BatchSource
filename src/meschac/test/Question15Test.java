package meschac.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.meschac.mafoula.Question15;

class Question15Test {

	@Test
	void test() {
		Question15 testInstance = new Question15();
		double expected = 2;
		double actual = testInstance.add(1, 1);
		assertEquals(expected, actual);
		
		actual = testInstance.subtract(4, 2);
		assertEquals(expected, actual);
		
		actual = testInstance.multiply(1, 2);
		assertEquals(expected, actual);
		
		actual = testInstance.divide(4,  2);
		assertEquals(expected, actual);
	}

	}


