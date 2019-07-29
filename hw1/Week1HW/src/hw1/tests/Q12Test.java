package hw1.tests;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Q12Test {

    @Test
    void test() {
        ArrayList<Integer> expected = new ArrayList<Integer>();
        //populate expected ArrayList
        for (int i=2; i<=100; i+=2) {
            expected.add(i);
        }
        
        ArrayList<Integer> actual = hw1.hollander.ben.Q12.q12();
        assertEquals(expected, actual);
    }

}
