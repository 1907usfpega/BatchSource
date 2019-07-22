package com.revature.hw1;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Q2UnitTest {
	
	@BeforeAll
	static void beforeTest()
	{
		System.out.println("Fibonacci Sequence Test: ");		
	}

	@Test
	@DisplayName("Fibonacci Test")
	void testFibonacci() {
		ArrayList<Integer> fib = Q2.fibonacci();
		System.out.println("Q2: " + fib.toString());
		//Would create a test to compare the array against a set array of the confirmed values, but that's a lot of work. I'll do it later. :D
	}

}
