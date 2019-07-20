package com.revature.funFactory;

public class HondaFactory {
	
	public Car getCar(String whatCar, String whatColor) {
		if("civic".equals(whatCar))
			return new Car("Honda", "Civic", 2019, whatColor);
		if("crv".equals(whatCar))
			return new Car("Honda", "CRV", 2019, whatColor);
		return null;
	}

	public HondaFactory() {
		// TODO Auto-generated constructor stub
	}

}
