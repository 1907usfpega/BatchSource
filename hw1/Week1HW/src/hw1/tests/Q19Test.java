package hw1.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import hw1.hollander.ben.Q19;

class Q19Test {

    @Test
    void q19() {
        Q19 q19 = new Q19();
        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 25, 4, 6, 8, 9, 10));

        assertTrue(expected.equals(q19.q19()));
    }
}
