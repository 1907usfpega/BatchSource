package com.revature.driver;



public class EmployeeForQ7 {
	private String name;
	private String department;
	private int age;
	
	public EmployeeForQ7(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public EmployeeForQ7() {
		super();
		// TODO Auto-generated constructor stub
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
		return "EmployeeForQ7 [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	
	

}
