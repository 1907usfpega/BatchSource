package com.revature.comparators;

import java.util.Comparator;

import com.revature.driver.EmployeeForQ7;

public class EmployeeComparatorsByName implements Comparator<EmployeeForQ7>{

	@Override
	public int compare(EmployeeForQ7 o1, EmployeeForQ7 o2) {		
		return o1.getName().compareTo(o2.getName());
	}

}
