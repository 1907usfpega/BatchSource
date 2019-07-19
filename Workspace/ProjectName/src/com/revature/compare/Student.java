package com.revature.compare;

public class Student implements Comparable<Student>{
	public Student() {}
	public Student(int studentID, String name, Double gPA) {
		this.studentID = studentID;
		this.name = name;
		GPA = gPA;
	}
	private int studentID;
	private String name;
	private Double GPA;
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getGPA() {
		return GPA;
	}
	public void setGPA(Double gPA) {
		GPA = gPA;
	}
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + ", GPA=" + GPA + "]";
	}
	
	public int compareTo(Student arg0) {
		return this.getStudentID()-arg0.getStudentID();
	}
}
