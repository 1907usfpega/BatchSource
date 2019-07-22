package meschac.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.meschac.mafoula.Question14;

class Question14Test {

	@Test
	void test() {
		Question14 actual = new Question14 ();
        String expected = "[I,  , a, m,  , l, e, a, r, n, i, n, g,  , C, o, r, e,  , J, a, v, a]";
        assertEquals("DefaultCase", actual.q14(0));
        assertEquals("2.0", actual.q14(1)); //double
        assertEquals(LocalTime.now().withNano(0).toString(), actual.q14(2));
        assertEquals(expected, actual.q14(3));
	}

}
