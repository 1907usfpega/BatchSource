package com.revature.hw1;

import java.util.Comparator;

public class SortEmployeesByDepartment implements Comparator<Employee> {

	public SortEmployeesByDepartment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		int output = 0;
		for (int i = 0; i < o1.getDept().length() && i < o2.getDept().length(); i++) {
			if (o1.getDept().charAt(i) > o2.getDept().charAt(i)) {
				output = 1;
			} else if (o1.getDept().charAt(i) < o2.getDept().charAt(i)) {
				output = -1;
			}
		}
		
		if ((o1.getDept().length() > o2.getDept().length()) && output == 0) {
			output = -1;
		} else if ((o1.getDept().length() < o2.getDept().length()) && output == 0) {
			output = 1;
		}
		
		return output;
	}

}
