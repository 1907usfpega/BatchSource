package com.revature.constructors;

public class Car {

	public String color;
	public int numWheels;
	public int miles;
	public String make;
	public String model;
	
	public Car()
	{
		
	}
	
	public Car(String color)
	{
		this(4, color);
	}
	
	public Car(int numWheels, String color)
	{
		this(1200, numWheels, color);
	}
	
	public Car(int miles, int numWheels, String color)
	{
		this("Toyota", miles, numWheels, color);
	}
	
	public Car(String make, int miles, int numWheels, String color)
	{
		this("Rav4", make, miles, numWheels, color);
	}
	
	public Car(String model, String make, int miles, int numWheels, String color) 
	{
		this.color = color;
		this.numWheels = numWheels;
		this.miles = miles;
		this.make = make;
		this.model = model;
	}

	@Override
	public String toString() 
	{
		return "Car [color=" + color + ", numWheels=" + numWheels + ", miles=" + miles + ", make=" + make + ", model="
				+ model + "]";
	}



	public static void main(String[] args) 
	{
		Car racecar = new Car("Red");
		
		System.out.println(racecar.toString());
	}

}
