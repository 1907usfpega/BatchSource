package com.revature.assignment1;

import java.util.Comparator;

/**
 * Assignment #1 Question 7
 * Sort two employees based on their name, department,
 * and age using the Comparator interface.
 * 
 * @author Kyle Kolstad
 *
 * 
 */
public class Employee {

	private String name, department;
	private int age;

	/**
	 * 
	 */
	public Employee() {

	}

	public Employee(String name, String department, int age) {
		System.out.println("Employee Object Created!");
		this.name = name;
		this.department = department;
		this.age = age;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public int getAge() {
		return age;
	}
}

class SortByName implements Comparator<Employee> {
	
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
}

class SortByDepartment implements Comparator<Employee> {
	
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getDepartment().compareTo(o2.getDepartment());
	}
}

class SortByAge implements Comparator<Employee> {
	
	@Override
	public int compare(Employee o1, Employee o2) {	
		return o1.getAge() - o2.getAge();
	}
}
