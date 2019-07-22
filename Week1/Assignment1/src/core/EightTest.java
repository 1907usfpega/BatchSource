package core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EightTest {

	@Test
	void test() {
		Eight a = new Eight();
		boolean actual =a.isPalindrome("kayla");
		boolean expected = false;
		assertEquals(actual,expected);
	}

}
