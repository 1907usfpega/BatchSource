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
		List<Employee> original = new ArrayList<Employee>();
		original.addAll(Arrays.asList(new Employee[] { 
				new Employee("Matt", "RH", 59),
				new Employee("Chesnut", "Sales", 34), 
				new Employee("Leo", "tech", 24) }));
		
		String output = Q7.sortByAge(original).toString();
		
		List<Employee> answer = new ArrayList<Employee>();
		answer.addAll(Arrays.asList(new Employee[] { 
				new Employee("Leo", "tech", 24),
				new Employee("Chesnut", "Sales", 34),
				new Employee("Matt", "RH", 59) }));
		
		assertEquals(answer.toString(),output);
	}

	@Test
	void testSortByName() {
		List<Employee> original = new ArrayList<Employee>();
		original.addAll(Arrays.asList(new Employee[] { 
				new Employee("Matt", "RH", 59),
				new Employee("Chesnut", "Sales", 34), 
				new Employee("Leo", "tech", 24) }));
		
		String output = Q7.sortByName(original).toString();
		
		List<Employee> answer = new ArrayList<Employee>();
		answer.addAll(Arrays.asList(new Employee[] { 
				new Employee("Chesnut", "Sales", 34),
				new Employee("Leo", "tech", 24),
				new Employee("Matt", "RH", 59) }));
		
		assertEquals(answer.toString(),output);
	}

	@Test
	void testSortByDepartment() {
		List<Employee> original = new ArrayList<Employee>();
		original.addAll(Arrays.asList(new Employee[] { 
				new Employee("Matt", "RH", 59),
				new Employee("Chesnut", "Sales", 34), 
				new Employee("Leo", "tech", 24) }));
		
		String output = Q7.sortByDepartment(original).toString();
		
		List<Employee> answer = new ArrayList<Employee>();
		answer.addAll(Arrays.asList(new Employee[] { 
				new Employee("Matt", "RH", 59),
				new Employee("Chesnut", "Sales", 34),
				new Employee("Leo", "tech", 24) }));
		
		assertEquals(answer.toString(),output);
	}

}
