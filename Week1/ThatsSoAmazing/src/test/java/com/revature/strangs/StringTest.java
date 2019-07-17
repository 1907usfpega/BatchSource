package com.revature.strangs;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StringTest {
	private String st;
	@BeforeAll
	static void beforeAllofem() {
		System.out.println("Before All");
	}
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initialize Test Data for " +
		info.getDisplayName());
	}
	
	@Test
	void meh() {
		int actualLength = "ABCD".length();
		int expectedLength = 4;
		assertEquals(expectedLength, actualLength);
		//assertEquals(expected value, actual value);
	}
	@Test
	void toUpperCase(){
		String str = "abcd";
		String result = str.toUpperCase();
		assertEquals("ABCD", result);
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
	@Nested
		@DisplayName("For an empty string")
		class EnptyStringTests{
			@BeforeEach
			void setToEmpty() {
				st = "";
			}
			@Test
			void lengthIsZero() {
				assertEquals(0,st.length());
			}
			@Test
			void uppercaseIsEmpty() {
				assertEquals("", st.toUpperCase());
			}
		}
}
