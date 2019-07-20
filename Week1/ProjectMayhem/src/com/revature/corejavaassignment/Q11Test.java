package com.revature.corejavaassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Q11Test {
	public Q11Test(float float1, float float2) {
		this.test(float1, float2);
	}
	@Test
	void test(float in1, float in2) {
		assertEquals(in1, in2, "Mismatch, failed to isolate evens");
	}

}
