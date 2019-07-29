package hw1.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import hw1.hollander.ben.Q14Switch;

class Q14Test {

    @Test
    void test() {
        Q14Switch actual = new Q14Switch();
        String expected = "[I,  , a, m,  , l, e, a, r, n, i, n, g,  , C, o, r, e,  , J, a, v, a]";
        assertEquals("DefaultCase", actual.q14(0));
        assertEquals("2.0", actual.q14(1)); //double
        assertEquals(LocalTime.now().withNano(0).toString(), actual.q14(2));
        assertEquals(expected, actual.q14(3));
        
        
    }

}
