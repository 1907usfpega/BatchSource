package com.revature.funfactory;

//create object w/o exposing creation logic to client
public class HondaFactory {
	public Car getCar(String whatCar, String color) {
	
		if ("civic".equals(whatCar)) {
			return new Car("Honda", 2019, "Civic", color);
		} else if ("crv".equals(whatCar)) {
			return new Car("Honda", 2019, "CRV", color);
		}
			return null;
		}
}
