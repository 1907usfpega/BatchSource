package com.revature.compare;

public class Student implements Comparable<Student>
{
	//first method of comparing: implementing Comparable
	private String label;
	private int studentID;
	private double gpa;
	
	public Student() 
	{
		super();
	}

	public Student(int studentID, String label, double gpa) 
	{
		super();
		this.label = label;
		this.studentID = studentID;
		this.gpa = gpa;
	}

	public String getLabel() 
	{
		return label;
	}

	public void setLabel(String label) 
	{
		this.label = label;
	}

	public int getStudentID() 
	{
		return studentID;
	}

	public void setStudentID(int studentID) 
	{
		this.studentID = studentID;
	}

	public double getGpa() 
	{
		return gpa;
	}

	public void setGpa(double gpa) 
	{
		this.gpa = gpa;
	}
	
	@Override
	public int compareTo(Student s)
	{
		return this.getStudentID()-s.getStudentID();
	}

	@Override
	public String toString() 
	{
		return "Student [label=" + label + ", studentID=" + studentID + ", gpa=" + gpa + "]";
	}
}
