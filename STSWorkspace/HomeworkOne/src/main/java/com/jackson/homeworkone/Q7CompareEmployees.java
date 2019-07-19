package com.jackson.homeworkone;

import java.util.Comparator;

public class Q7CompareEmployees implements Comparator<Employee>
{
	public int compare(Employee o1, Employee o2) 
	{
		int i = o1.getName().compareTo(o2.getName());
		if(i != 0)
			return i;
		i = o1.getDepartment().compareTo(o2.getDepartment());
		if(i != 0)
			return i;
		return o1.getAge()-o2.getAge();
	}
	
}
