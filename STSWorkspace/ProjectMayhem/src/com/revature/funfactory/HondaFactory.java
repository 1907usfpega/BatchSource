package com.revature.funfactory;

public class HondaFactory 
{
	/*
	 * use a factory to return a car model based on what strings are given
	 * if the method is given something other than crv or civic, return null
	 */
	public Car getCar(String whatCar, String whatColor)
	{
		if("civic".equals(whatCar))
		{
			return new Car("Honda", 2019, "Civic", whatColor);
		}
		else if("crv".equals(whatCar))
		{
			return new Car("Honda", 2019, "CRV", whatColor);
		}
		return null;
	}
}
