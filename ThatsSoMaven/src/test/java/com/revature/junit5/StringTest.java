package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StringTest {

	String str;
	
	@BeforeAll
	static void beforeAllOfEm() {
		System.out.println("Before All");
	}
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initialize Test Data for "+info.getDisplayName());
	}
	
	@Test
	@DisplayName ("Length Check")
	void meh() {
		int actualLength = "ABCD".length();
		int expectedLength = 4;
		//assertEquals(expected value, actual value)
		assertEquals(expectedLength, actualLength);
	}
	
	@Test
	@DisplayName("Check toUpperCase")
	void toUpperCase() {
		//String str = "abcd";
		//String result = str.toUpperCase();
		//String expected = "ABCD"
		//assertEquals(expected,result);
		assertEquals("ABCD","abcd".toUpperCase());
	}
	
	@Test
	@DisplayName("Check for exception")
	void lengthException(){
		String s = null;
		assertThrows(NullPointerException.class,()->{
			s.length();
		});
	}
	
	@Nested
	@DisplayName("For an empty string")
	class EmptyStringTests{
		@BeforeEach
		void setToEmpty() {
			str="";
		}
		@Test
		void lengthIsZero() {
			assertEquals(0,str.length());
		}
		@Test
		void uppercaseIsEmpty() {
			assertEquals("",str.toUpperCase());
		}
	}

}
