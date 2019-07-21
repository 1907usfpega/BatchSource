package com.revature.JUnit;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.revature.driver.Question19;

class Question19Test {

	static Question19 q19 = new Question19();
	
	@Test
	void getAllEvensTest() {
		ArrayList<Integer> evens = q19.getAllEven();
		for(int i: evens) {
			assertTrue(i%2 == 0);
		}
	}
	
	@Test
	void getAllOddsTest() {
		ArrayList<Integer> odds = q19.getAllOdd();
		for(int i: odds) {
			assertTrue(i%2 != 0);
		}
	}

}
