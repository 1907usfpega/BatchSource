package com.revature.corejavaassignment;

import com.revature.compare.Student;

public class Q10 {
	private String tempSt;
	public Q10() {
		// TODO Auto-generated constructor stub
		System.out.println("********** Q10 **********\n");
		tempSt = "";
		compare(10, 20);
		Q10Test tester1 = new Q10Test("<", tempSt);
		compare(3.2445, -24.13);
		Q10Test tester2 = new Q10Test(">", tempSt);
		compare(12.0, 2.320);
		Q10Test tester3 = new Q10Test(">", tempSt);
		compare(0.0324445, 224.1333);
		Q10Test tester4 = new Q10Test("<", tempSt);
		System.out.println("\n\n");
	}
	public void compare(double a, double b) {
		System.out.println("Comparing " + String.valueOf(a) + 
							" and " + String.valueOf(b));
		this.tempSt = (a > b ? ">" : "<");
		System.out.println(String.valueOf(a) + " " + 
							 tempSt + " " + 
							String.valueOf(b) + "\n");
	}

}
