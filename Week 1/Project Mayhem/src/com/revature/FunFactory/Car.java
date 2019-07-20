package com.revature.FunFactory;

public class Car {

	private String make; 
	private int year; 
	private String modle; 
	private String color;
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String make, int year, String modle, String color) {
		super();
		this.make = make;
		this.year = year;
		this.modle = modle;
		this.color = color;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getModle() {
		return modle;
	}
	public void setModle(String modle) {
		this.modle = modle;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Car [make=" + make + ", year=" + year + ", modle=" + modle + ", color=" + color + "]";
	} 
	
	
	
}
