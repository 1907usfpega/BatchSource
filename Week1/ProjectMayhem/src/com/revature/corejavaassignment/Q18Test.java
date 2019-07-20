package com.revature.corejavaassignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q18Test {
	public Q18Test(int int1, int int2) {
		this.test(int1, int2);
	}
	@Test
	void test(int in1, int in2) {
		assertEquals(in1, in2, "Mismatch, incorrect sum");
	}

}
