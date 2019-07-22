package core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EighteenTest {

	@Test
	void test() {
		Eighteen a = new Eighteen();
		boolean actual = a.checkUppercase("hooooHoo"); 
		boolean expected = true;
		assertEquals(actual, expected);
	}

}
