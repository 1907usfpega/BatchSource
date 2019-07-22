package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.questions.Q18;

class TestQ18 {

	@Test
	void testCheckUppercase() {
		Q18 q18 = new Q18();
		assertEquals(false,q18.checkUppercase("daYana"));
	}

	@Test
	void testConvertToUppercase() {
		Q18 q18 = new Q18();
		assertEquals("HELLO THERE", q18.convertToUppercase("Hello there"));
	}

	@Test
	void testAddTen() {
		Q18 q18 = new Q18();
		assertEquals(17,q18.addTen());//given user typed 7
	}

}
