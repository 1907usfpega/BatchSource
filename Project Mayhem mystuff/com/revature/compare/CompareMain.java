package com.revature.compare;

public class CompareMain {

	public static void main(String[] args) {

		List<Student> studentList= new ArrayList<Students>();
		studentList.addAll(Arrays.asList(new Student[] {
				new Student(15,"Matt",6.59),
				new Student(71,"Chesnut",3.4),
				new Student(43,"Levi",.3),
				new Student(22,"Deonta",10.0),
				new Student(88,"Terry",4.0),
				new Student(37,"Dayana",3.5),
				new Student(23,"Zach",2.12),
				new Student(4,"Leo",9.9),
		}));
		System.out.println("Original List");
		for(Student s:studentList) {
			System.out.println(s);
		}
		System.out.println("========");
		Collections.sort(studentList);
		System.out.println("Sorted byStudentID");
		for(Student s:studentList) {
			System.out.println(s);
		
			
		}
	}
	

}
