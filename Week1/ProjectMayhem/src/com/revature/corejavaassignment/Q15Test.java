package com.revature.corejavaassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Q15Test {
	public Q15Test(double double1, double double2) {
		this.test(double1, double2);
	}
	@Test
	void test(double in1, double in2) {
		assertEquals(in1, in2, "Mismatch, operation not identified");
	}

}
