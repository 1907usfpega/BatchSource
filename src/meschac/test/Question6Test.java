package meschac.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Question6Test {

	@Test
	void test() {
		//isEven
				boolean expected = true;
				boolean actual = com.meschac.mafoula.Question6.q6(42);
				System.out.println(actual);
				assertEquals(expected, actual);
				
				//expected remains true, actual should change to false
				actual = com.meschac.mafoula.Question6.q6(43);
				//assertNotEquals(expected, actual);
	}

}
