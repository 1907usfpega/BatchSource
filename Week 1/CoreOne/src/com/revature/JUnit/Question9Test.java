package com.revature.JUnit;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import com.revature.driver.Question9;

class Question9Test {

	@Test
	void testgetPrimes() {
		String primes = "2 3 4 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97";
		List<Integer> ali = new ArrayList<Integer>();
		for(int i = 1; i < 101; i++) {
			ali.add(i);
		}
		String p = Question9.getPrimes(ali); 
		System.out.println(p);
		System.out.println(primes);
		assertTrue(p.equals(primes));
	}

}
