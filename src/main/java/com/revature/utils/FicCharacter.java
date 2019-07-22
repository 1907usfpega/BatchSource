package com.revature.utils;

public class FicCharacter {
	// Create a entity to receive data

	private String firstName;
	private String lastName;
	private String state;
	private String age;

	public FicCharacter(String firstName, String lastName, String age, String state) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.state = state;
		this.age = age;
	}

	// print on given format
	@Override
	public String toString() {
		return "Name:  " + firstName + " " + lastName + "\nAge: " + age + " years" + "\nState: " + state + " State";
	}

}