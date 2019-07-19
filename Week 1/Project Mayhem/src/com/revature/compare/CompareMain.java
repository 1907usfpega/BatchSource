package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.addAll(Arrays.asList( 
				new Student[] {
						new Student(15, "matt", 10),
						new Student(1, "eddie", 4),
						new Student(20, "marcos", 3.5),
						new Student(14, "humberto", 3.7),
						new Student(13, "dab", 1),
						new Student(1337, "rick sanches", 200),
						new Student(9, "morty", 0.4),
						new Student(3, "ted", 100),
				}));
		System.out.println("Original List ");
		for(Student s: studentList) {
			System.out.println(s);
		}
		System.out.println("==============================");
		Collections.sort(studentList);
		System.out.println("Sorted by Student ID");
		for(Student s: studentList) {
			System.out.println(s);
		}
		System.out.println("==============================");
		Collections.sort(studentList, new StudentComparator());
		System.out.println("Sorted by GPA");
		for(Student s: studentList) {
			System.out.println(s);
		}
		System.out.println("==============================");
		System.out.println("Sort by Label w/ Lambda");
		//Functional interfaces have ONE method
		//We can use lambdas w/ these
		Collections.sort(studentList,(arg0, arg1)
				->{
					return arg0.getLable().compareTo(arg1.getLable()
							);}
				);
		for(Student s: studentList) {
			System.out.println(s);
		}
		
	}
	

}
