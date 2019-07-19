package com.revature.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question7 {
	public static void doTask() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.addAll(Arrays.asList(new Employee[] {
			new Employee("Max", "IT", 35),
			new Employee("Tim", "IT", 28),
			new Employee("Felix", "HR", 21),
			new Employee("Brad", "HR", 69),
			new Employee("Matt", "Finance", 42),
			new Employee("Edd", "Finance", 30),
			new Employee("Niklas", "Finance", 101),
			new Employee("Guenther", "Sales", 14),
			new Employee("Gerry", "Sales", 25),
			new Employee("Berthold", "IT", 80),
			new Employee("Samantha", "Production", 23),
			new Employee("Martha", "Training", 9),
			
		})
		);
		System.out.println("=======================");
		System.out.println("Sorted by age, the employees are: ");
		//Collections.sort(employees, new AgeComparator());
		employees = sortBy(employees, 'a');
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		System.out.println("=======================");
		System.out.println("Sorted by name, the employees are: ");
		//Collections.sort(employees, new NameComparator());
		employees = sortBy(employees, 'n');
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		System.out.println("=======================");
		System.out.println("Sorted by department, the employees are: ");
		//Collections.sort(employees, new DepartmentComparator());
		employees = sortBy(employees, 'd');
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
	public static List<Employee> sortBy(List<Employee> employees, char c) {
		switch(c) {
		case('a'): Collections.sort(employees, new AgeComparator()); break;
		case('d'): Collections.sort(employees, new DepartmentComparator()); break;
		case('n'): Collections.sort(employees, new NameComparator()); break;
		default: System.out.println("invalid char option was given. please chose a, d or n "
				+ "for age department and name. \n List was most likely not sorted");
		
		}
		return employees;
	}
}

class Employee {
	public String name;
	public String department;
	public int age;

	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	public Employee() {
	}
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
}

class NameComparator implements Comparator<Employee> {

	public int compare(Employee o1, Employee o2) {

		return o1.name.compareTo(o2.name);
	}

}

class DepartmentComparator implements Comparator<Employee> {

	public int compare(Employee o1, Employee o2) {

		return o1.department.compareTo(o2.department);
	}

}

class AgeComparator implements Comparator<Employee> {

	public int compare(Employee o1, Employee o2) {

		return o1.age - o2.age;
	}

}