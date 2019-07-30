package com.revature.assignment1;

/**
 * Assignment #1 Question 13
 *Display the triangle on the console as follows using any type of loop. Do NOT use a
 *simple group of print statements to accomplish this.
 *0
 *1 0
 *1 0 1
 *0 1 0 1
 * 
 * @author Kyle Kolstad
 *
 * 
 */
public class Triangle {

	String string = "";
	public Triangle() {
		
	}
	
	public void displayTriangle(int numberOfLines){
		int switchSides = 0;
		for(int i = 0; i < numberOfLines; i++) {
			if(i % 2 == 0) {
				if(switchSides == 0) {
					string = string + "0";
					System.out.println(string);
					switchSides = 1;
				} else {
					string = "1" + string;
					System.out.println(string);
					switchSides = 0;
				}
			} else {
				if(switchSides == 1) {
					string = string + "1";
					switchSides = 1;
					System.out.println(string);
				} else {
					string = "0" + string;
					System.out.println(string);
					switchSides = 0;
				}
			}
		}
	}
}
