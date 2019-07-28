package hw1.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import hw1.hollander.ben.Employee;

class Q7Test {

    @Test
    void test() {
        List<Employee> testInstance = new ArrayList<Employee>();
      //Add employees
        testInstance.addAll(Arrays.asList(
                new Employee [] {
                        new Employee ("Dora", "Deli", 60),
                        new Employee ("Bob", "Bakery", 46),
                        new Employee ("Gary", "Grocery", 57) 
                }));
        
        List<Employee> expected = new ArrayList<Employee>();
        expected.addAll(Arrays.asList(
                new Employee[] {
                        new Employee ("Bob", "Bakery", 46),
                        new Employee ("Gary", "Grocery", 57),
                        new Employee ("Dora", "Deli", 60)
                }));
        
        Collections.sort(testInstance);//sort by age defined in Employee class
        //toString should point to the same reference in the String pool; showing that the values are equal
        assertEquals(testInstance.toString(), expected.toString());
        
        //Sort by Name
        expected.clear(); //empty list & setup again
        expected.addAll(Arrays.asList(
                new Employee[] {
                        new Employee ("Bob", "Bakery", 46),
                        new Employee ("Dora", "Deli", 60),
                        new Employee ("Gary", "Grocery", 57)
                }));
        
        Collections.sort(testInstance,(arg0, arg1) ->{
            return arg0.getName().compareTo(arg1.getName());
        });
        assertEquals(expected.toString(), testInstance.toString());

        //Sort by dept
        expected.clear();
        expected.addAll(Arrays.asList(
                new Employee[] {
                        new Employee ("Bob", "Bakery", 46),
                        new Employee ("Dora", "Deli", 60),
                        new Employee ("Gary", "Grocery", 57)
                }));
        Collections.sort(testInstance,(arg0, arg1) ->{
            return arg0.getDept().compareTo(arg1.getDept());
        });
        assertEquals(expected.toString(), testInstance.toString());
    }

}
