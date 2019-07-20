package com.revature.FunFactory;
//Factories create an object w/o exposing
//creation logic to client
public class HandaFactory {
/*
 * use a "factory" method to return a Car Model based on 
 * what String is given
 * if the method is given a parameter fo somethign besides
 * crv ro civic, it iwll return null
 * 
 */
	public Car getCar(String whatCar, String color) {
		if("civic".equals(whatCar)) {
			return new Car("Honda", 2019, "civic", color);
		} else if("crv".equals(whatCar)) {
			return new Car("Honda", 2019, "crv", color); 
		}
		return null;
	}
}
