package day4.pt6;

public class Comparisons implements Comparable<Comparisons> {
	//1st method of comparing - Implement Comparable
	
	private int studentID;
	private String label;
	private double gpa;
	
	
	public Comparisons() {
		super();
	}


	public Comparisons(int studentID, String label, double gpa) {
		super();
		this.studentID = studentID;
		this.label = label;
		this.gpa = gpa;
	}


	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}


	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}


	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}


	@Override
	public String toString() {
		return "Comparisons [studentID=" + studentID + ", label=" + label + ", gpa=" + gpa + "]";
	}


	@Override
	public int compareTo(Comparisons arg0) {
		return this.getStudentID() - arg0.getStudentID();
	}
	
	
	
	
}//end Comparisons class
