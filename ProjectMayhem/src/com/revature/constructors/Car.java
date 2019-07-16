package com.revature.constructors;

public class Car {
	private int numDoors;
	private int numWheels;
	private int numSeats;
	private int height;
	private String color;
	
	public Car() {
		this("black", 5, 4, 60, 4);
	}
	public Car(String color) {
		this(color, 5, 4, 60, 4);
	}
	public Car(String color, int numSeats) {
		this(color, numSeats, 4, 60, 4);
	}
	public Car(String color, int numSeats, int numDoors) {
		this(color, numSeats, numDoors, 60, 4);
	}
	public Car(String color, int numSeats, int numDoors, int height) {
		this(color, numSeats, numDoors, height, 4);
	}
	public Car(String color, int numSeats, int numDoors, int height, int numWheels) {
		this.numDoors = numDoors;
		this.numWheels = numWheels;
		this.numSeats = numSeats;
		this.height = height;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Car: "+height+" in. tall "+color+" "+numDoors+" door "+numSeats+" seater with "+numWheels+" wheels.";
		//return "Car [numDoors=" + numDoors + ", numWheels=" + numWheels + ", numSeats=" + numSeats + ", height="
				//+ height + ", color=" + color + "]";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car def = new Car();
		System.out.println(def.toString());
		Car rensCar = new Car("red",5,4,55,4);
		System.out.println(rensCar.toString());

	}

}
