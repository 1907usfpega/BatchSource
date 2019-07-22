package meschac.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.meschac.mafoula.Question19;

class Question19Test {

	@Test
	void test() {
		Question19 q19 = new Question19();
        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 25, 4, 6, 8, 9, 10));

        assertTrue(expected.equals(q19.q19()));
	}

}
