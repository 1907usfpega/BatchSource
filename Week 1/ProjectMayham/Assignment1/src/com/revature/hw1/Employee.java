package com.revature.hw1;

public class Employee {
	
	private String name;
	private String dept;
	private int age;

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", age=" + age + "]";
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

	public Employee(String name, String dept, int age) {
		this.name = name;
		this.dept = dept;
		this.age = age;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

}
