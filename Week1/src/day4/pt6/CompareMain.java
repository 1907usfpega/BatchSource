package day4.pt6;

import java.util.*;

public class CompareMain {

	public static void main(String[] args) {
		
		List<Comparisons> studentList = new ArrayList<Comparisons>();
		studentList.addAll(Arrays.asList(new Comparisons[] { 
				
		new Comparisons(12,"Tyler",3.28),
		new Comparisons(41,"Jane",2.90),
		new Comparisons(33,"Marg",4.1),
		new Comparisons(8,"Kason",3.72),
		new Comparisons(28,"Mike",0.09),
		new Comparisons(50,"Sherry",4.08),
		new Comparisons(1,"Liam",1.84),}));
		
		System.out.println("Original List");
		for(Comparisons s:studentList) {
			System.out.println(s);
		}

		
//------------------------------------Sort Comparable-----------------------------------------
		System.out.println("--------------------");
		System.out.println("Sorted by StudentID ");
		Collections.sort(studentList);
		for(Comparisons s:studentList) {
			System.out.println(s);
		}
		
		
//------------------------------------Sort Comparator-----------------------------------------
		System.out.println("--------------------");
		System.out.println("Sorted by GPA");
		Collections.sort(studentList, new StudentComparator());
		for(Comparisons s:studentList) {
			System.out.println(s);
		}
		
		
//------------------------------------Sort Lambda-----------------------------------------
		//Functional Interfaces have 1 method
		//Use lambdas with Functional Interfaces
		System.out.println("--------------------");
		System.out.println("Sorted by Label w/ Lambda");
		
		Collections.sort(studentList, (arg0, arg1)->
				{return arg0.getLabel().compareTo(arg1.getLabel());}); //<--Lambda???
		
		for(Comparisons s:studentList) {
			System.out.println(s);
		}
		
		
	}//end main

}//end CompareMain
