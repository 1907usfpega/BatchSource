package com.revature.constructors;

public class Lecture {
	private int time;
	private String Subject;
	private String professor;
	private String department;
	private int roomNum;
	
	public Lecture() {
		this(207);
	}
	public Lecture(int roomNum) {
		this("Biology", roomNum);
	}
	public Lecture(String department, int roomNum) {
		this("Knighten", department, roomNum);
	}
	public Lecture(String professor, String department, int roomNum) {
		this("Anatomy", professor, department, roomNum);
	}
	public Lecture(String subject, String professor, String department, int roomNum) {
		this(1, subject, professor, department, roomNum);
	}
	public Lecture(int time, String subject, String professor, String department, int roomNum) {
		super();
		this.time = time;
		Subject = subject;
		this.professor = professor;
		this.department = department;
		this.roomNum = roomNum;
	}

	
	public String toString() {
		return "Lecture [time=" + time + ", Subject=" + Subject + ", professor=" + professor + ", department="
				+ department + ", roomNum=" + roomNum + "]";
	}
	
	public static void main(String []args) {
		Lecture myLecture = new Lecture();
		System.out.println(myLecture.toString());
	}
}
