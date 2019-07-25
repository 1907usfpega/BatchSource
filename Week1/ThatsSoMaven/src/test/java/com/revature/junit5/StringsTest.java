package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StringsTest {
	@BeforeAll
	static void beforeAllofem() {
		System.out.println("Before All");
	}
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("initialize Test Data for");
		info.getDisplayName();
	}
	@Test
	@DisplayName("Length Check")
	void meh() {
		int actualLength= "ABCD".length();
		int expectedLength=4;
		//assertEquals( expected value, actual value);
		assertEquals(expectedLength, actualLength);
		
		
	}
	@Test
	void toUpperCase() {
		String str= "abcd";
		String result=str.toUpperCase();
		assertEquals("ABCD",result);
	}
	
	@Test
	@DisplayName("check for exception")
	void lengthException() {
		String s=null;
		assertThrows(NullPointerException.class,
				()->{
					s.length();
				});
	}
	
	
}
