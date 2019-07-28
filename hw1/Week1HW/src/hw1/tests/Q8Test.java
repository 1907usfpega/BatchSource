package hw1.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Q8Test {

	@Test
	void q8Test() {
		ArrayList<String> expected = new ArrayList<String>();
		ArrayList<String> actual = hw1.hollander.ben.Q8Palindrome.q8();

		//"refer", "billy", "did"
		expected.add("madam");
		expected.add("civic");
		expected.add("radar");
		expected.add("kayak");
		expected.add("refer");
		expected.add("did");
		
		boolean check = expected.equals(actual);
		assertEquals(true, check);
	}

}
