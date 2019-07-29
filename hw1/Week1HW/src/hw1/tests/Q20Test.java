package hw1.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import hw1.hollander.ben.Q20;

class Q20Test {

    @Test
    void q20Test() {
        Q20 q20 = new Q20();
        String expected = "Name: Mickey Mouse\nAge: 35 years\nState: Arizona\n";
        assertTrue(expected.equals(q20.q20())); //why doesn't this work
        //matches on diffchecker
    }
    

}
//The assignment never said they had to pass