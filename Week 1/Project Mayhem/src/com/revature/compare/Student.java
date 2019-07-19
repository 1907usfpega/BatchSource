package com.revature.compare;

public class Student implements Comparable<Student>{
	//first method of comparing: implement Comparable
	private int studentID;
	private String lable;
	private double gpa;
	
	public Student(int studentID, String lable, double gpa) {
		super();
		this.studentID = studentID;
		this.lable = lable;
		this.gpa = gpa;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", lable=" + lable + ", gpa=" + gpa + "]";
	}
	@Override
	public int compareTo(Student arg0) {
		return this.getStudentID() - arg0.getStudentID();
	}
	
	
}
