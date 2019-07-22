package Assignment.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JavaQ7Comparator {
	String name;

	int age;

	String department;

	public JavaQ7Comparator(String string, int i, String string2) {
		// TODO Auto-generated constructor stub
	
	}

	void Employee(String name, int age, String department)

	{

		this.name = name;

		this.age = age;

		this.department = department;

	}

	public String toString() {

		return "Employee- Name: " + name + ", Age: " + age + ", Department: " + department;

	}

}

class SortByName implements Comparator<JavaQ7Comparator>

{

	public int compare(JavaQ7Comparator first, JavaQ7Comparator second)

	{

		return first.name.compareTo(second.name);

	}

}

class SortByAge implements Comparator<JavaQ7Comparator>

{

	public int compare(JavaQ7Comparator first, JavaQ7Comparator second)

	{

		return first.age - second.age;

	}

}

class SortByDepartment implements Comparator<JavaQ7Comparator>

	{

	public int compare(JavaQ7Comparator first, JavaQ7Comparator second)

	{

	return first.department.compareTo(second.department);

	}



	}

	
