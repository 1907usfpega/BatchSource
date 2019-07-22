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
				new Student(15, "Matt", 6.89),
				new Student(45, "MChetnut", 67.89),
				new Student(14, "Deontay", 10.0),
				new Student(16, "Terry", 4.0),
				new Student(17, "Dayana", 9.89),
				new Student(15, "Zach", 0.12),
				new Student(4, "Matt", 9.9),
		}
		
		));
		System.out.println("Original List: ");
		for(Student s: studentList) {
			System.out.println(s);
		}
		
		System.out.println("==========");
		Collections.sort(studentList);
		System.out.println("sorted by student id");
		for(Student s: studentList) {
			System.out.println(s);
		} 
		System.out.println("==========");
		System.out.println("sort by label w/Lambda");
		//a functional interface has one method
		
		//we can use Lambdas w/these
		Collections.sort(studentList,(arg0, arg1)
				->{return 
						arg0.getLabel().compareTo(arg1.getLabel()
								);}
				);
		for(Student s:studentList) {
			System.out.println(s);
		}
		
	}

}
