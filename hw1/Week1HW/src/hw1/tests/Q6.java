package hw1.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q6 {

	@Test
	void q6() {
		//isEven
		boolean expected = true;
		boolean actual = hw1.hollander.ben.Q6Even.q6(42);
		System.out.println(actual);
		assertEquals(expected, actual);
		
		//expected remains true, actual should change to false
		actual = hw1.hollander.ben.Q6Even.q6(43);
		//assertNotEquals(expected, actual);
	}

}
