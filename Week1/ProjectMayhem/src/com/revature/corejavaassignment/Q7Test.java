package com.revature.corejavaassignment;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.revature.corejavaassignment.Q7.Employee;

class Q7Test {
	public Q7Test(List<Employee> L1, List<Employee> L2) {
		this.test(L1, L2);
	}
	@Test
	void test(List<Employee>  l1, List<Employee> l2) {
		for(int i = 0; i < l1.size(); i++) {
			assertTrue(l1.get(i).isEqual(l2.get(i)));
		}
		
	}

}
