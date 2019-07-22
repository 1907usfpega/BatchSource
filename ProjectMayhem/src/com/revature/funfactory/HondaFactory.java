package com.revature.funfactory;

//factories create an object w/o exposing creation logic to client
public class HondaFactory {

	public Car getCar(String whatCar, String color) {
		if ("civic".equals(whatCar.toLowerCase())) {
			return new Car("Honda", 2019, "Civic", color);
		} else if (whatCar.toLowerCase().equals("crv")) {
			return new Car("Honda", 2019, "CRV", color);
		} else {
			return null;
		}//end if

	}// end getCar

}// end HondaFactory
