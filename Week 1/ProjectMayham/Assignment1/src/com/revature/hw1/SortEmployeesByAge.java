package com.revature.hw1;

import java.util.Comparator;

public class SortEmployeesByAge implements Comparator<Employee> {

	public SortEmployeesByAge() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return (o1.getAge() - o2.getAge());
	}

}
