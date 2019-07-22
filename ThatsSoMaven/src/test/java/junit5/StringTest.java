package junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StringTest {
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("This runs before all.");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("This ran after all.");
	}
	
	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("Initialize test data for " + info.getDisplayName());
	}
	
	
	@Test
	@DisplayName("Length Check")
	void test() {
		int actualLength = "ABCD".length();
		int expectedLength = 4;
		
		//assertEquals(expected value, actual value);
		assertEquals(expectedLength, actualLength);
		
	}//end test method
	
	
	@Test
	void toUpperCase() {
		String str = "abcd";
		String result = str.toUpperCase();
		assertEquals("ABCD", result);
		
	}//end toUpperCase method
	
	
	@Test
	@DisplayName("Check for Exceptions") //<--Passes if there is a NULL value
	void lengthException() { 
		String s = null;
		assertThrows(NullPointerException.class, ()->{s.length();});
		
	}//end lengthException
	

}//end StringTest class
