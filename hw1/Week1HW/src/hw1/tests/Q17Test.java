package hw1.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hw1.hollander.ben.Q17;

class Q17Test {

    @Test
    void q17Test() {
        Q17 q17 = new Q17();
        double expected = 3*4*5; //60
        double actual = q17.interest();
        assertEquals(expected, actual);
    }

}
//Enter in 3, 4, 5
//Completed