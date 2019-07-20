package com.revature.corejavaassignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q14Test {
	public Q14Test(double double1, double double2) {
		this.test(double1, double2);
	}
	@Test
	void test(double in1, double in2) {
		assertEquals(in1, in2, "Mismatch, square root failed");
	}

}
