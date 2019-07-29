package com.revature.corejavaassignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q4Test {
	public Q4Test(long int1, long int2) {
		this.test(int1, int2);
	}
	@Test
	void test(long in1, long in2) {
		assertEquals(in1, in2, "Mismatch, incorrect factorial");
	}

}
