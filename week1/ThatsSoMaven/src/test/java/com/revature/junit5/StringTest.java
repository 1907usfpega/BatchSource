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
	private String str;
	
	//runs once, same with afterAll
	@BeforeAll
	static void beforeAllOfEm() {
		System.out.println("it is done");
	}
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("init test data for "+info.getDisplayName());
	}

	@Test
	@DisplayName ("Length Check")
	void meh() {
		int actualLength="abcd".length();
		int expectLength=4;
		//assertEquals(<expected>,<actual>);
		assertEquals(expectLength,actualLength);
	}
	
	@Test
	@DisplayName ("Caps Check")
	void toUpperCase() {
		String str="abcd";
		String res=str.toUpperCase();
		assertEquals("ABCD", res);
	}
	
	@Test
	@DisplayName ("Check for exception")
	void lengthException() {
		String s=null;
		assertThrows(NullPointerException.class,()->{
			s.length();
		});
	}
	
	@Nested
	 @DisplayName ("Testing Empties")
	 class EmptyStringTests{
		@BeforeEach
		void setEmpty(){
			str="";
		}
		@Test
		void lengthIsZero() {
			assertEquals(0,str.length());
		}
		@Test
		void upperCaseEmpty() {
			assertEquals("", str.toUpperCase());
		}
	}
	

}
