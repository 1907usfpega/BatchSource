package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import homework1.Employee;
import homework1.EmployeeCompareName;

class Test7 {

	@Test
	void test() {
		//Creates a new ArrayList and adds in Employee objects
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.addAll(Arrays.asList(new Employee[] {
				
				new Employee ("Tyler", "Marketing", 34),
				new Employee ("Jane", "HR", 51)
		}));
		
		//Uses comparator to compare and sort the the names of all employees
		Collections.sort(employeeList, new EmployeeCompareName());
		
		//The sorted list now has a new order
		//Checks if the tested employee is the same as the expected employee
		assertEquals(employeeList.get(0).toString(), "[name=Jane, department=HR, age=51]");
		
	}//end test()

}//end Test7
