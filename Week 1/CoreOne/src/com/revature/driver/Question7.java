package com.revature.driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.revature.comparators.*;

public class Question7 {

	protected List<EmployeeForQ7> sortMe = new ArrayList<EmployeeForQ7>(
			Arrays.asList(
				new EmployeeForQ7[] {
						new EmployeeForQ7("Eddie", "Accounting", 24),
						new EmployeeForQ7("Dan", "Development", 23)
						}));

	protected void prompt() {
		System.out.println("Question 7: \n Solution:");
	}
	protected void run()  {
		System.out.println("Not sorted: ");
		for(EmployeeForQ7 s: sortMe) {
			System.out.println(s);
		}
		Collections.sort(sortMe, new EmployeeComparatorsByName());
		System.out.println("Sorted by name: ");
		for(EmployeeForQ7 s: sortMe) {
			System.out.println(s);
		}
		
		Collections.sort(sortMe, new EmployeeComparatorsByDepartment());
		System.out.println("Sorted by Department: ");
		for(EmployeeForQ7 s: sortMe) {
			System.out.println(s);
		}
		
		Collections.sort(sortMe, new EmployeeComparatorsByAge());
		System.out.println("Sorted by Age: ");
		for(EmployeeForQ7 s: sortMe) {
			System.out.println(s);
		}
		
	}
}