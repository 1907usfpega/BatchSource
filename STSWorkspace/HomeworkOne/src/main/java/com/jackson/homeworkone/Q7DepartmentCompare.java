package com.jackson.homeworkone;

import java.util.Comparator;

public class Q7DepartmentCompare implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) 
	{
		return o1.getDepartment().compareTo(o2.getDepartment());
	}

}
