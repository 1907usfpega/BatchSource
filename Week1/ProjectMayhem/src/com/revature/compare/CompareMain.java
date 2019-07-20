package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain {

	public CompareMain() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[]) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.addAll(Arrays.asList(
				new Student[] {
						new Student(15, "Matt", 6.59),
						new Student(71, "Chestnut", 3.4),
						new Student(43, "Levi", 0.3),
						new Student(22, "Deonta", 10.0),
						new Student(37, "Terry", 4.0),
						new Student(33, "Jim", 3.8),
						new Student(1, "Abe", 2)
						
				}));
		System.out.println("Original list");
		for(Student S : studentList) {
			System.out.println(S);
		}
		System.out.println("========================");
		Collections.sort(studentList);
		for(Student S : studentList) {
			System.out.println(S);
		}
	}

}
