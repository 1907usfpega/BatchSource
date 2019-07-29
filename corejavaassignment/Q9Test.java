package com.revature.corejavaassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class Q9Test {
	public Q9Test(List<Integer> L1, List<Integer> L2) {
		this.test(L1, L2);
	}
	@Test
	void test(List<Integer>  l1, List<Integer> l2) {
		assertEquals(l1.size(), l2.size());
		for(int i = 0; i < l1.size(); i++) {
			assertEquals(l1.get(i), l2.get(i), "Primes not isolated");
		}
		
	}

}