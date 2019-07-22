package com.revature.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Assignment7 {

	public static void myNewMethod() {
		ArrayList<Employee> arr1 = new ArrayList<Employee>();

		arr1.add(new Employee("Big Steve", "hardwares", 56));
		arr1.add(new Employee("Lefty Lucy", "gardening", 34));
		arr1.add(new Employee("Little Richard", "furniture", 44));

		Collections.sort(arr1, new SortByName());
		System.out.println(arr1);
		Collections.sort(arr1, new SortByDepartment());
		System.out.println(arr1);
		Collections.sort(arr1, new SortByAge());
		System.out.println(arr1);
	}
}

	class SortByName implements Comparator<Employee> {

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub

			return o1.getName().compareTo(o2.getName());
		}

	}

	class SortByDepartment implements Comparator<Employee> {

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-o1generated method stub

			return o1.getDepartment().compareTo(o2.getDepartment());
		}

	}

	class SortByAge implements Comparator<Employee> {

		@Override
		public int compare(Employee o1, Employee o2) {

			if (o1.getAge() > o2.getAge()) {
				return 1;
			} else if (o1.getAge() < o2.getAge()) {
				return -1;
			} else
				// TODO Auto-generated method stub
				return 0;
		}

	}

	class Employee {
		private String name;
		private String department;
		private int age;

		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Employee(String name, String department, int age) {
			super();
			this.name = name;
			this.department = department;
			this.age = age;
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

		@Override
		public String toString() {
			return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
		}

	}


