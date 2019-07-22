package com.revature.hw1;

import java.util.Comparator;

/*
 * Sorts two employees by name, department, and age using Comparator
 * interface.
 * TODO: Study up on demo class to help. Fix implementation of compare methods(or otherwise create new Classes for them...)
 */

public class Q7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Employee implements Comparator<Employee>{
	private String name;
	private String dept;
	private int age;
	
	Employee()
	{
		
	}
	
	Employee(String n, String d, int a)
	{
		name = n;
		dept = d;
		age = a;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	//Compares values.
	public int compare(Employee o1, Employee o2) 
	{
		return o1.getName().compareTo(o2.getName());
	}
	
	public int compareDepts(Employee o1, Employee o2)
	{
		return o1.getDept().compareTo(o2.getDept());
	}
	
	public int compareAge(Employee o1, Employee o2)
	{
		return o1.getAge() - o2.getAge();
	}

}
