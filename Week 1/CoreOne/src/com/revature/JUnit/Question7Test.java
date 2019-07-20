package com.revature.JUnit;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.comparators.EmployeeComparatorsByAge;
import com.revature.comparators.EmployeeComparatorsByDepartment;
import com.revature.comparators.EmployeeComparatorsByName;
import com.revature.driver.EmployeeForQ7;

class Question7Test {
	
	private static List<EmployeeForQ7> arr = Arrays.asList(
				new EmployeeForQ7[] {
						new EmployeeForQ7("Eddie", "Accounting", 23),
						new EmployeeForQ7("Dan", "Development", 24),
						new EmployeeForQ7("Jane", "Checking", 50)
						});
	
	
	private static List<EmployeeForQ7> byName = Arrays.asList(
			new EmployeeForQ7[] {
					new EmployeeForQ7("Dan", "Development", 24),
					new EmployeeForQ7("Eddie", "Accounting", 23),
					new EmployeeForQ7("Jane", "Checking", 50)
					});
	private static List<EmployeeForQ7> byDepartment = Arrays.asList(
			new EmployeeForQ7[] {
					new EmployeeForQ7("Eddie", "Accounting", 23),
					new EmployeeForQ7("Jane", "Checking", 50),
					new EmployeeForQ7("Dan", "Development", 24)

					});
	private static List<EmployeeForQ7> byAge = Arrays.asList(
			new EmployeeForQ7[] {
					new EmployeeForQ7("Eddie", "Accounting", 23),
					new EmployeeForQ7("Dan", "Development", 24),
					new EmployeeForQ7("Jane", "Checking", 50)
					});

	@Test
	void testSortByName() {
		
		Collections.sort(arr, new EmployeeComparatorsByName());
		for(int i = 0; i < 3; i++) {
			assertTrue (arr.get(i).getName().equals(byName.get(i).getName()));
		}
	}
	@Test
	void testSortByDepartment() {
		
		Collections.sort(arr, new EmployeeComparatorsByDepartment());
		for(int i = 0; i < 3; i++) {
			assertTrue (arr.get(i).getDepartment().equals(byDepartment.get(i).getDepartment()));
		}
	}
	@Test
	void testSortByAge() {
		
		Collections.sort(arr, new EmployeeComparatorsByAge());
		for(int i = 0; i < 3; i++) {
			assertTrue (arr.get(i).getAge() == byAge.get(i).getAge());
		}
	}

}
