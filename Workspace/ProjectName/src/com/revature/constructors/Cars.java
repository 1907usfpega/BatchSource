package com.revature.constructors;

public class Cars {
	private int numWheels;
	private int numDoors;
	private int numSeats;
	private String color;
	private double price;
	private static int DEFAULTSEATS = 5;
	
	
	
	public Cars(int numWheels, int numDoors, int numSeats, String color, double price) {
		super();
		this.numWheels = numWheels;
		this.numDoors = numDoors;
		this.numSeats = numSeats;
		this.color = color;
		this.price = price;
	}
	public Cars(int numDoors, int numSeats, String color, double price){
		this(4, numDoors, numSeats, color, price);
	}
	public Cars(int numSeats, String color, double price){
		this( 4, numSeats, color, price);
	}
	public Cars(String color, double price){
		this( Cars.DEFAULTSEATS, color, price);
	}
	public Cars(int numSeats, double price){
		this( numSeats, "Red", price);
	}
	public Cars(double price) {
		this(Cars.DEFAULTSEATS, price);
	}
	public Cars() {
		this(45000);
	}
	



	@Override
	public String toString() {
		return "Cars [numWheels=" + numWheels + ", numDoors=" + numDoors + ", numSeats=" + numSeats + ", color=" + color
				+ ", price=" + price + "]";
	}



	public static void main(String[] agrs) {
		Cars car1 = new Cars();
		Cars car2 = new Cars(30000);
		Cars car3 = new Cars("Blue", 200000);
		Cars bus = new Cars(20, "Green", 150000);
		Cars truck = new Cars(8, 2, 3, "Black", 400000);
		
		System.out.println("car1 = " + car1.toString() + "\n" + "car2 = " + car2.toString());
		System.out.println("car3 = " + car3.toString() + "\n" + "bus = " + bus.toString());
		System.out.println("truck = " + truck.toString());
		
	}
}
