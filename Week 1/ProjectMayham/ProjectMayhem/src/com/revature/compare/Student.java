package com.revature.compare;

public class Student implements Comparable<Student> {
	private int studentID;
	private String label;
	private double gpa;

	public Student() {
	};

	public Student(int studentID, String label, double gpa) {
		this.studentID = studentID;
		this.label = label;
		this.gpa = gpa;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public void setGPA(double gpa) {
		this.gpa = gpa;
	}
	
	public int getStudentID() {
		return studentID;
	}
	
	public String getLabel() {
		return label;
	}
	
	public double getGPA() {
		return gpa;
	}

	
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", label=" + label + ", gpa=" + gpa + "]";
	}
	
	@Override
	public int compareTo(Student arg0) {
		return this.getStudentID()-arg0.getStudentID();
	}

}
