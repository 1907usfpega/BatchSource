package com.reavture.compare;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student arg0, Student arg1) {
		
		return (int)(arg0.getGpa()-arg1.getGpa());
	}

}
