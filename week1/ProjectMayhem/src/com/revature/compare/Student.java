package com.revature.compare;

public class Student implements Comparable<Student>{
	
	private int studentId;
	private String lable;
	private double gpa;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int studentId, String lable, double gpa) {
		super();
		this.studentId = studentId;
		this.lable = lable;
		this.gpa = gpa;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
		return "Student [studentId=" + studentId + ", lable=" + lable + ", gpa=" + gpa + "]";
	}

	@Override
	public int compareTo(Student arg0) {
		
		return this.getStudentId()-arg0.getStudentId();
	}
	
	
	

}
