package meschac.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Question12Test {

	@Test
	void test() {
		ArrayList<Integer> expected = new ArrayList<Integer>();
        //populate expected ArrayList
        for (int i=2; i<=100; i+=2) {
            expected.add(i);
        }
        
        ArrayList<Integer> actual = com.meschac.mafoula.Question12.q12();
        assertEquals(expected, actual);
	}

}
