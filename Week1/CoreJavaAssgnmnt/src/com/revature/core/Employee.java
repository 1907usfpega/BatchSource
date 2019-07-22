/**
 * 
 */
package com.revature.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author MajorKey
 *Question 7
 *Make static method taking two employees as params 
 *use comparator interface for above to sort
 */
public class Employee {
	
	private String name;
	private String department;
	private int age;
	
	/**
	 * @param name
	 * @param department
	 * @param age
	 */
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	/**
	 * @param name
	 * @param age
	 */
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	/**
	 * @param name
	 */
	public Employee(String name) {
		super();
		this.name = name;
	}
	/**
	 * 
	 */
	public Employee() {
		super();
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	static class NameComparator implements Comparator<Employee> {

		@Override
		public int compare(Employee x, Employee y) {
			return x.getName().compareTo(y.getName());
		}
	}
	static class DeptComparator implements Comparator<Employee> {
		@Override
		public int compare(Employee x, Employee y) {
			return x.getDepartment().compareTo(y.getDepartment());
		}	
	}
	static class AgeComparator implements Comparator<Employee> {
		@Override
		public int compare(Employee x, Employee y) {
			if(x.getAge()== y.getAge())  
				return 0;  
			else if(x.getAge() > y.getAge())  
				return 1;  
			else  
				return -1;  
		}	
	}
	
	public static void main(String [] args) {
		Employee b = new Employee("v", "CE", 8);
		
		ArrayList<Employee> al = new ArrayList<Employee>();
		al.add(new Employee("Deonta", "Software Engineering", 22));
		al.add(new Employee("Vince", "Human Resources", 28));
		
		Collections.sort(al, new Employee.NameComparator());
		
		System.out.println("Name Comparator: ");
		Iterator<Employee> itr=al.iterator();
		System.out.println(((Employee) itr.next()).toString());
		System.out.println(((Employee) itr.next()).toString());
		
		Collections.sort(al, new Employee.DeptComparator());
		
		System.out.println("Department Comparator: ");
		Iterator<Employee> itr2 =al.iterator();
		System.out.println(((Employee) itr2.next()).toString());
		System.out.println(((Employee) itr2.next()).toString());
		
		Collections.sort(al, new Employee.AgeComparator());
		
		System.out.println("Age Comparator: ");
		Iterator<Employee> itr3=al.iterator();
		System.out.println(((Employee) itr3.next()).toString());
		System.out.println(((Employee) itr3.next()).toString());
	}
}


