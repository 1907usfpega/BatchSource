package com.revature.junit5;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.utils.Employee;
import com.revature.questions.Q7;

class TestQ7 {
	
	@Test
	void testSortByAge() {
		List<Employee> input = new ArrayList<Employee>();
		input.addAll(Arrays.asList(new Employee[] { 
				new Employee("Matt", "RH", 59),
				new Employee("Chesnut", "Sales", 34), 
				new Employee("Leo", "tech", 24) }));
		
		List<Employee> output = new ArrayList<Employee>();
		output.addAll(Arrays.asList(new Employee[] { 
				new Employee("Leo", "tech", 24),
				new Employee("Chesnut", "Sales", 34),
				new Employee("Matt", "RH", 59) }));
		assertTrue(output.equals(Q7.sortByAge(input)));
	}
//
//	@Test
//	void testSortByName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSortByDepartment() {
//		fail("Not yet implemented");
//	}

}
