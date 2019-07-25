package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain {

	public static void main(String[] args) {
		List<Student> studentList= new ArrayList<Student>();
		studentList.addAll(Arrays.asList(
				new Student[] {
				new Student(15, "Matt",6),
				new Student(1, "Chesnut",5),
				new Student(20, "Levi",4),
				new Student(23, "Deonta",3),
				new Student(30, "Zach",2),
	}));
		System.out.println("Orifinal List");
		for(Student s:studentList) {
			System.out.println(s);
	}
		System.out.println("==========");
		Collections.sort(studentList);
		System.out.println("Sorted by StudentID");
		for(Student s:studentList) {
			System.out.println(s);
	}
		System.out.println("==========");
		Collections.sort(studentList,new StudentComparatory());
		System.out.println("Sort by GPA:");
		for(Student s:studentList ) {
		
		}
		System.out.println("==========");
		System.out.println("Sorta by Label w/ Lambda");
		//Functional interfaces have 1 method
		//can use lambdas w/ these
		Collections.sort(studentList,(arg0,arg1));
}
	
}
