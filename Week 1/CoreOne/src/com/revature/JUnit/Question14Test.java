package com.revature.JUnit;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

class Question14Test {

	@Test
	void testSq() {
		double sq = Math.sqrt(Double.parseDouble("16"));
		double ans = 4; 
		assertTrue(sq == ans);
	}
	@Test
	void testSplit() {
		String three =  "I am learning Core Java";
		String[] split = three.split(" ");
		for(String s: split) {
			System.out.println(s.trim());
		}
		assertTrue(split[0].equals("I"));
		assertTrue(split[1].equals("am"));
		assertTrue(split[2].equals("learning"));
		assertTrue(split[3].equals("Core"));
		assertTrue(split[4].equals("Java"));
	}


}
