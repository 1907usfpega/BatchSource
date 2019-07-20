package com.revature.corejavaassignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q6Test {
	public Q6Test(boolean bn1, boolean bn2) {
		this.test(bn1, bn2);
	}
	@Test
	void test(boolean b1, boolean b2) {
		assertEquals(b1, b2, "Even/Odd incorrect");
	}

}
