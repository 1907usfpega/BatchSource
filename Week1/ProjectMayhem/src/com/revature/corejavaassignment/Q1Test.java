package com.revature.corejavaassignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q1Test {
	public Q1Test(int arr1[], int arr2[]) {
		this.test(arr1, arr2);
	}
	@Test
	void test(int ar1[], int ar2[]) {
		assertArrayEquals(ar1, ar2, "Array Not Sorted");
	}

}
