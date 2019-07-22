package com.revature.junithwone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.jackson.homeworkone.Employee;
import com.jackson.homeworkone.Q7TestComparators;

class Q7Test 
{

	@BeforeEach
	void beforeEach(TestInfo info)
	{
		System.out.println("Initialize Test Data for "+info.getDisplayName());
	}
	
	@Test
	void testTestAgeCompare() 
	{
		Q7TestComparators q7 = new Q7TestComparators(new Employee("Frank West", "Marketing", 23), new Employee("Gertrude Jones", "Advertising", 24));
		assertEquals(true, q7.testAgeCompare());
		
	}

	@Test
	void testTestNameCompare() 
	{
		Q7TestComparators q7 = new Q7TestComparators(new Employee("Frank West", "Marketing", 23), new Employee("Gertrude Jones", "Advertising", 24));
		assertEquals(true, q7.testNameCompare());
	}

	@Test
	void testTestDepartmentCompare() 
	{
		Q7TestComparators q7 = new Q7TestComparators(new Employee("Frank West", "Marketing", 23), new Employee("Gertrude Jones", "Advertising", 24));
		assertEquals(false, q7.testDepartmentCompare());
	}

}
