package com.revature.comp;

import java.util.Comparator;

public class EmployeeComp implements Comparator<Employee> {

	@Override
	public int compare(Employee arg0, Employee arg1) {
		// TODO Auto-generated method stub
		return (int)(arg0.getDepartment().compareTo(arg1.getDepartment()));
	}

}
