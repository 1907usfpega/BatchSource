package com.revature.funfactory;

public class HondaFactory {
	public Car getCar(String whatCar, String whatColor) {
		if("civic".equals(whatCar)) {
			return new Car("Honda", 2019, "Civic", whatColor);
		}else if(whatCar.equals("crv")) {
			return new Car("Honda", 2019, "CRV", whatColor);
		}else {
			return null;
		}
	}
}
