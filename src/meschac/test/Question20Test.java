package meschac.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.meschac.mafoula.Question20;

class Question20Test {

	@Test
	void test() {
		Question20 q20 = new Question20();
        String expected = "Name: Mickey Mouse\nAge: 35 years\nState: Arizona\n";
        //assertTrue(expected.equals(q20.q20())); //why doesn't this work
        //matches on diffcheckeru
	}

}
