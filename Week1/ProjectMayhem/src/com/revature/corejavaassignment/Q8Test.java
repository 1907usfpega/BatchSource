package com.revature.corejavaassignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.corejavaassignment.Q7.Employee;

class Q8Test {
	public Q8Test(List<String> L1, List<String> L2) {
		this.test(L1, L2);
	}
	@Test
	void test(List<String>  l1, List<String> l2) {
		for(int i = 0; i < l1.size(); i++) {
			assertEquals(l1.get(i), (l2.get(i)), "Palindromes not isolated");
		}
		
	}

}