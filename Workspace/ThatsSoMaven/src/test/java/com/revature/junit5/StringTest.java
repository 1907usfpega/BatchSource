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

	@BeforeAll
	static void beforeAllOfEm() {
		System.out.println("beforeAll");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println(info.getDisplayName());
	}
	
	@Test
	@DisplayName("Length Test")
	void meh() {
		int actualLength = "ABCD".length();
		int expectedLength = 4;
		//assertEquals( expected value, actual value);
		assertEquals(expectedLength, actualLength);
	}
	
	@Test
	@DisplayName("Check for Exception")
	void lengthException() {
		String s = null;
		assertThrows(NullPointerException.class, 
				()->{
					s.length();
				});
	}
	
	@Test
	@DisplayName("UpperCaseCheck")
	void toUpperCase() {
		String str = "abc";
		String result = str.toUpperCase();
		assertEquals("ABC",result);
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
