package ConstructorExample;

public class Auto {
	public int numDoors;
	public int numWheels;
	public String color;
	public double price;
	
	public Auto(int numDoors, int numWheels, String color, double price) {
		super();
		this.numDoors = numDoors;
		this.numWheels = numWheels;
		this.color = color;
		this.price = price;
	}

	public Auto(int numWheels, String color, double price) {
		this(4, numWheels, color, price );
		System.out.println("Hey 1");
	}
	
	public Auto(String color, double price) {
		this(18, color, price);
		System.out.println("Hey 2");
		
	}
	
	
}
