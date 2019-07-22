package com.revature.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompairMain {

	public static void main(String[] args) {
		List<Student> attendance=new ArrayList<Student>();
		attendance.addAll(Arrays.asList(new Student[] {
				new Student(15,"Matt",6.95),
				new Student(69,"Ren",3.14),
				new Student(71,"Chesnut",3.4),
				new Student(22,"Levi",.3),
				new Student(43,"Deonte",10),
				new Student(37,"Dayana",3.5),
				new Student(23,"Zach",2.12),
				new Student(4,"Leo",9.9)
				}
			));
		System.out.println("original List: ");
		for (Student s: attendance) {
			System.out.println(s);
		}
		System.out.println("=============");
		System.out.println("Sort by ID: ");
		Collections.sort(attendance);
		for (Student s: attendance) {
			System.out.println(s);
		}
		System.out.println("=============");
		System.out.println("Sort by GPA: ");
		Collections.sort(attendance,new StudentComparator());
		for (Student s: attendance) {
			System.out.println(s);
		}
		System.out.println("=============");
		System.out.println("Sort by Lable with lambda:");
		//functional interfaces have 1 method
		//we can use lambdas w/ these
		
		Collections.sort(attendance,(arg0,arg1)->{return arg0.getLable().compareTo(arg1.getLable());});
		for (Student s: attendance) {
			System.out.println(s);
		}
		
	}

}
