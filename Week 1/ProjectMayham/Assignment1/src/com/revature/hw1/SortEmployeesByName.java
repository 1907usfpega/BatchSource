package com.revature.hw1;

import java.util.Comparator;

public class SortEmployeesByName implements Comparator<Employee> {

	public SortEmployeesByName() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		int output = 0;
		for (int i = 0; i < o1.getName().length() && i < o2.getName().length(); i++) {
			if (o1.getName().charAt(i) > o2.getName().charAt(i)) {
				output = -1;
			} else if (o1.getName().charAt(i) < o2.getName().charAt(i)) {
				output = 1;
			}
		}
		
		if ((o1.getName().length() > o2.getName().length()) && output == 0) {
			output = -1;
		} else if ((o1.getName().length() < o2.getName().length()) && output == 0) {
			output = 1;
		}
		
		
		return output;
	}

}
