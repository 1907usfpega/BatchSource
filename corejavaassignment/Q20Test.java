package com.revature.corejavaassignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q20Test {
	public Q20Test(String str1, String str2) {
		this.test(str1, str2);
	}
	@Test
	void test(String st1, String st2) {
		assertEquals(st1, st2, "Mismatch, not Fibonacci");
	}

}

