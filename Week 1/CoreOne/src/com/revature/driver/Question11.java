package com.revature.driver;

import com.revature.anotherPackage.diffClassForQ11;

public class Question11 {
	// return floats from a class in different package
	public float[] run() {
		diffClassForQ11 diff = new diffClassForQ11();
		float[] gimme = { diff.getOne(), diff.getTwo() };
		return gimme;
	}

	protected void prompt() {
		System.out.println("Question 11:");
		System.out.print("Solution: ");
	}
}
