package meschac.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Question8Test {

	@Test
	void test() {
		ArrayList<String> expected = new ArrayList<String>();
		ArrayList<String> actual = com.meschac.mafoula.Question8.q8();

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
