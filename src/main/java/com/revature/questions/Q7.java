package com.revature.questions;
//Q7. Sort two employees based on their name, department, and age using the Comparator interface.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class Q7 {

	public static void main(String[] args) {
		List<Employee> employeeList= new ArrayList<Employee>();
		employeeList.addAll(Arrays.asList(
				new Employee[] {
						new Employee("Matt", "RH", 59),
						new Employee("Chesnut", "Sales", 34),
						new Employee("Leo", "tech", 24),
				}));
	}
	public static void compareByName
		Collections.sort(employeeList,new EmployeeAgeComparator());
		System.out.println("Sorted by age:");
		for(Employee emp:employeeList) {
			System.out.println(emp.age);
		}
		
		Collections.sort(employeeList,new EmployeeNameComparator());
		System.out.println("\nSorted by name:");
		for(Employee emp:employeeList) {
			System.out.println(emp.name);
		}
		
		Collections.sort(employeeList,new EmployeeDepComparator());
		System.out.println("\nSorted by Dep:");
		for(Employee emp:employeeList) {
			System.out.println(emp.department);
		}



}

//===========================================================================

//comparing by age
class EmployeeAgeComparator implements Comparator<Employee> {
	public int compare(Employee arg0, Employee arg1) {
		
		return (int)(arg0.age-arg1.age);
	}
}

//comparing by department
class EmployeeDepComparator implements Comparator<Employee> {
	public int compare(Employee arg0, Employee arg1) {
		
		return arg0.department.compareTo(arg1.department);
	}
}

//comparing by name
class EmployeeNameComparator implements Comparator<Employee> {
	public int compare(Employee arg0, Employee arg1) {
		
		return arg0.name.compareTo(arg1.name);
	}
}


//===========================================================================
class Employee {// implements Comparable<Employee>{
	
	String name;
	String department;
	int age;

	protected Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}

//	public int compareTo(Employee arg0) {
//		return this.age-arg0.age;
//	}
	
	
}