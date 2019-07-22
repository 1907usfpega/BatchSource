package meschac.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question3Test {

	@Test
	void test() {
		//FIXME assert(expected, actual)
		String expected = "olleh";
		String actual = com.meschac.mafoula.Question3.q3("hello");
		assertEquals(expected, actual);
	}

}
