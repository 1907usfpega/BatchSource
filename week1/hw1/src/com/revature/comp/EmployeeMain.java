package com.revature.comp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.revature.comp.Employee;
import com.revature.comp.EmployeeComp;

public class EmployeeMain {

	public static List<Employee> sorts() {
		// TODO Auto-generated method stub
		List<Employee> attendance=new ArrayList<Employee>();
		attendance.addAll(Arrays.asList(new Employee[] {
				//new Employee("HR","Matt",33),
				new Employee("Staging","Ren",69),
				new Employee("HR","Hann",48),
				//new Employee("Business","Ligma",420),
				}
			));
		System.out.println("original List: ");
		for (Employee s: attendance) {
			System.out.println(s);
		}
		System.out.println("=============");
		System.out.println("Sort by Age: ");
		Collections.sort(attendance);
		for (Employee s: attendance) {
			System.out.println(s);
		}
		System.out.println("=============");
		System.out.println("Sort by Department: ");
		Collections.sort(attendance,new EmployeeComp());
		for (Employee s: attendance) {
			System.out.println(s);
		}
		System.out.println("=============");
		System.out.println("Sort by Name with lambda:");
		//functional interfaces have 1 method
		//we can use lambdas w/ these
		
		Collections.sort(attendance,(arg0,arg1)->{return arg0.getName().compareTo(arg1.getName());});
		for (Employee s: attendance) {
			System.out.println(s);
		}
		return attendance;

	}

}
