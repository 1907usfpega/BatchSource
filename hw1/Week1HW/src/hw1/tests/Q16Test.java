package hw1.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hw1.hollander.ben.Q16;

class Q16Test {
	


	@Test
	void test() {
	    Q16 testInstance = new Q16();
		int expected = 5;
		int actual = testInstance.q16(new String[] {"hello"}); //pass in String[] args to function
		assertEquals(expected, actual);
	}

}
//completed