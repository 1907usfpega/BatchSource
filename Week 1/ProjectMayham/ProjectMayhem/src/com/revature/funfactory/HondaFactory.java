package com.revature.funfactory;

// Factories create an object without exposing creation logic to the client

public class HondaFactory {

	/*
	 * use a "factory" method to return a Car Model based on what string is given.
	 * If the method is given a parameter of something besides crv or civic, it will return null.
	 */
	
	public Car getCar(String whatCar, String color) {
		if ("civic".equals(whatCar)) {
			return new Car("Honda", 2019, "Civic", color);
		} else if ("crv".equals(whatCar)) {
			return new Car("Honda", 2019, "crv", color);
		} else {
			return null;
		}
	}
	
}
