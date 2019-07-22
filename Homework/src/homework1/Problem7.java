package homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem7 {
	
	static void sortEmployees() {
	
	//Creates a new ArrayList and adds in Employee objects
	List<Employee> employeeList = new ArrayList<Employee>();
	employeeList.addAll(Arrays.asList(new Employee[] {
			
			new Employee ("Tyler", "Marketing", 34),
			new Employee ("Jane", "HR", 51)
	}));
	
	
//------------------------------------Sort by Name-----------------------------------------
	//Uses comparator to compare and sort the the names of all employees
	System.out.println("Q7.) Employees sorted by name:");
	Collections.sort(employeeList, new EmployeeCompareName());
	for(Employee name : employeeList) {
		System.out.println(name);
	}
	System.out.println("--------------------");
	
	
//------------------------------------Sort by Dept-----------------------------------------
	//Uses comparator to compare and sort the the departments of all employees
	System.out.println("Employees sorted by department:");
	Collections.sort(employeeList, new EmployeeCompareDept());
	for(Employee dept : employeeList) {
		System.out.println(dept);
	}
	System.out.println("--------------------");
	
	
//------------------------------------Sort by Age-----------------------------------------
	//Uses comparator to compare and sort the the ages of all employees
	System.out.println("Employees sorted by age:");
	Collections.sort(employeeList, new EmployeeCompareAge());
	for(Employee age : employeeList) {
		System.out.println(age);
	}
	
	}//end sortEmployees
	
}//end Problem7 class
