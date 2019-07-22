package com.revature.questions;
//Q7. Sort two employees based on their name, department, and age using the Comparator interface.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.revature.utils.Employee;

public class Q7 {
	static List<Employee> employeeList;

	public static List<Employee> sortByAge(List<Employee> employeeList2) {
		Collections.sort(employeeList2, new EmployeeAgeComparator());
		System.out.println("Sorted by age:");
		for (Employee emp : employeeList2) {
			System.out.println(emp.getAge());
		}
		return employeeList2;
	}
	
	public static List<Employee> sortByName(List<Employee> employeeList2) {
		Collections.sort(employeeList2, new EmployeeNameComparator());
		System.out.println("\nSorted by name:");
		for (Employee emp : employeeList2) {
			System.out.println(emp.getName());
		}
		return employeeList2;
	}
	
	public static List<Employee> sortByDepartment(List<Employee> employeeList2) {
		Collections.sort(employeeList2, new EmployeeDepComparator());
		System.out.println("\nSorted by Dep:");
		for (Employee emp : employeeList2) {
			System.out.println(emp.getDepartment());
		}
		return employeeList2;
	}

	public static void sortEmployees() {
		employeeList = new ArrayList<Employee>();
		employeeList.addAll(Arrays.asList(new Employee[] { new Employee("Matt", "RH", 59),
				new Employee("Chesnut", "Sales", 34), new Employee("Leo", "tech", 24), }));

		sortByAge(employeeList);
		sortByName(employeeList);
		sortByDepartment(employeeList);
	}

}

//===========================================================================

//comparing by age
class EmployeeAgeComparator implements Comparator<Employee> {
	public int compare(Employee arg0, Employee arg1) {

		return (int) (arg0.getAge() - arg1.getAge());
	}
}

//comparing by department
class EmployeeDepComparator implements Comparator<Employee> {
	public int compare(Employee arg0, Employee arg1) {

		return arg0.getDepartment().compareTo(arg1.getDepartment());
	}
}

//comparing by name
class EmployeeNameComparator implements Comparator<Employee> {
	public int compare(Employee arg0, Employee arg1) {

		return arg0.getName().compareTo(arg1.getName());
	}
}