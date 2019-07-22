package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.addAll(Arrays.asList(new Student[] { new Student(15, "Matt", 6.59), new Student(71, "Chesnut", 3.4),
				new Student(43, "Levi", .3), new Student(22, "Deonta", 10.0), new Student(88, "Terry", 4.0),
				new Student(37, "Dayana", 3.5), new Student(23, "Zach", .12), new Student(42, "Leo", 9.9), }));

		System.out.println("Original list:");
		for (Student s : studentList) {
			System.out.println(s);
		} // end for
		System.out.println("==================");

		Collections.sort(studentList);
		System.out.println("Sorted by Student ID");
		for (Student s : studentList) {
			System.out.println(s);
		} // end for
		System.out.println("==================");

		Collections.sort(studentList, new StudentComparator());
		System.out.println("Sorted by GPA");
		for (Student s : studentList) {
			System.out.println(s);
		} // end for
		System.out.println("==================");

		System.out.println("Sort by label with Lambda");
		/*
		 * Lambda: anonymous function (sort of) used with functional interfaces
		 * Functional Interface: has 1 (one) method in this case, basically does the
		 * same thing as StudentComparator but without having to actually make the
		 * comparator
		 */

		Collections.sort(studentList, (arg0, arg1) -> {
			return arg0.getLabel().compareTo(arg1.getLabel());
		});
		for (Student s : studentList) {
			System.out.println(s);
		} // end for
		System.out.println("==================");

	}// end main
}// end CompareMain
