package com.revature.constructors;

public class Cat {

	private String name;
	private int numWhiskers;
	private int numTeeth;
	private int weight;
	private int livesLeft;
	
	public Cat() {
		this("Tom", 4, 20, 15, 9);
	}
	public Cat(int livesLeft) {
		this("Tom", 4, 20, 15, livesLeft);
	}
	public Cat(int weight, int livesLeft) {
		this("Tom", 4, 20, weight, livesLeft);
	}
	public Cat(int numTeeth, int weight, int livesLeft) {
		this("Tom", 4, numTeeth, weight, livesLeft);
	}
	public Cat(int numWhiskers, int numTeeth, int weight, int livesLeft) {
		this("Tom", numWhiskers, numTeeth, weight, livesLeft);
	}
	public Cat(String name, int numWhiskers, int numTeeth, int weight, int livesLeft) {
		this.name = name;
		this.numWhiskers = numWhiskers;
		this.numTeeth = numTeeth;
		this.weight = weight;
		this.livesLeft = livesLeft;
	}
	
	@Override
	public String toString() {
		return "Cat [name=" + name + ", numWhiskers=" + numWhiskers + ", numTeeth=" + numTeeth + ", weight=" + weight
				+ ", livesLeft=" + livesLeft + "]";
	}
	
	public static void main(String [] args) {
		Cat tom = new Cat();
		System.out.println(tom.toString());
	}
	
}
