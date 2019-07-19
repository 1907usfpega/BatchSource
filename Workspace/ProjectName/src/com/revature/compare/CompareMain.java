package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompareMain {

	public static void main(String[] args) {
		List<Student> studentlist = new ArrayList<Student>();
		studentlist.addAll(Arrays.asList(
				new Student[] {
						new Student(15, "Leo", 1.0),
						new Student(12, "Chestner", 3.4),
						new Student(19, "Pombers", 11.0),
						new Student(35, "Terry", 11.6),
				}
				));
		System.out.println("Original List: ");
		for (Student student : studentlist) {
			System.out.println(student);
		}
		System.out.println("==============");
		Collections.sort(studentlist);
		System.out.println("SortedById:");
		for (Student student : studentlist) {
			System.out.println(student);
		}

		System.out.println("SortedByComparator:");
		Collections.sort(studentlist, new StudentComparator());
		for (Student student : studentlist) {
			System.out.println(student);
		}
		System.out.println("==============");
		System.out.println("Sort by Lambda");
		Collections.sort(studentlist, (arg0, arg1)
				-> {return arg0.getName().compareTo(arg1.getName()
						);}
				);
		for (Student student : studentlist) {
			System.out.println(student);
		}
	}

}
