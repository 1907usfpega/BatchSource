package meschac.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.meschac.mafoula.Question18;

class Question18Test {

	@Test
	void test() {
		Question18 testInstance = new Question18();
		assertTrue(testInstance.hasUppercase("Hello"));
		
		String expectedString = "HELLO";
		assertEquals(expectedString, testInstance.toUppercase("hello"));
		
		Integer expectedInt = 20;
		assertEquals(expectedInt, testInstance.parseInt("10"));
	}

}
