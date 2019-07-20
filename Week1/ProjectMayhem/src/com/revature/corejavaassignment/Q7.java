package com.revature.corejavaassignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.revature.compare.Student;

public class Q7 {

	public Q7() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q7 **********\n");
		Employee employee1 = new Employee("Ted", "Engineering", 26);
		Employee employee2 = new Employee("Bill", "Human Resources", 24);
		
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.addAll(Arrays.asList(
				new Employee[] {employee2, employee1}
							));
		List<Employee> sortedByNameAge = new ArrayList<Employee>();
		sortedByNameAge.addAll(Arrays.asList(
				new Employee[] {employee2, employee1}
							));
		List<Employee> sortedByDept = new ArrayList<Employee>();
		sortedByDept.addAll(Arrays.asList(
				new Employee[] {employee1, employee2}
							));
		
		System.out.println("\nBefore sorting:");
		for(Employee E : employeeList)
			System.out.println(E.toString());
		
		Collections.sort(employeeList, new NameComparator());
		Q7Test tester = new Q7Test(employeeList, sortedByNameAge);
		System.out.println("\nAfter sorting by name:");
		
		for(Employee E : employeeList)
			System.out.println(E.toString());

		Collections.sort(employeeList, new DepartmentComparator());
		Q7Test tester2 = new Q7Test(employeeList, sortedByDept);
		System.out.println("\nAfter sorting by department:");
		for(Employee E : employeeList)
			System.out.println(E.toString());
		
		Collections.sort(employeeList, new AgeComparator());
		Q7Test tester3 = new Q7Test(employeeList, sortedByNameAge);
		System.out.println("\nAfter sorting by age:");
		for(Employee E : employeeList)
			System.out.println(E.toString());
		
		System.out.println("\n\n");
	}
	class Employee{
		
		public Employee(String name, String department, int age) {
			super();
			this.name = name;
			this.department = department;
			this.age = age;
		}
		private String name;
		private String department;
		private int age;
		public boolean isEqual(Employee emp) {
			if(this.getAge() == emp.getAge() &&
					this.getName().equals(emp.getName())&&
					this.getDepartment().equals(emp.getDepartment()))
				return true;
			return false;
		}
		
		@Override
		public String toString() {
			return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDepartment() {
			return department;
		}
		
		public void setDepartment(String department) {
			this.department = department;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
	}
	class NameComparator implements Comparator<Employee>{
		public int compare(Employee employee1, Employee employee2) {
			return employee1.getName().compareTo(employee2.getName());
		}
	}
	class DepartmentComparator implements Comparator<Employee>{
		public int compare(Employee employee1, Employee employee2) {
			return employee1.getDepartment().compareTo(employee2.getDepartment());
		}
	}
	class AgeComparator implements Comparator<Employee>{
		public int compare(Employee employee1, Employee employee2) {
			if(employee1.getAge() > employee2.getAge()) {
				return 1;
			}
			else if(employee1.getAge() < employee2.getAge()) {
				return -1;
			}
			return 0;
		}
	}

}
