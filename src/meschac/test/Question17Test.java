package meschac.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.meschac.mafoula.Question17;

class Question17Test {

	@Test
	void test() {
		  Question17 q17 = new Question17();
	        double expected = 3*4*5; //60
	        double actual = q17.interest();
	        assertEquals(expected, actual);
	}

}
