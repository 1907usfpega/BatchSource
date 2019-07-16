package com.revature.constructors;

public class Mouse {
	private int numTeeth = 17;
	private int numWhiskers;
	private int weight;
	
	public Mouse() {
		super();
	}
	public Mouse(int weight) {
		this(4, weight);
	}
	public Mouse(int numTeeth, int numWhiskers, int weight) {
		super();
		this.numTeeth = numTeeth;
		this.numWhiskers = numWhiskers;
		this.weight = weight;
	}
	public Mouse(int numWhiskers, int weight) {
		this(17, numWhiskers, weight);
	}
	
	@Override
	public String toString() {
		return "Mouse [numTeeth=" + numTeeth + ", numWhiskers=" + numWhiskers + ", weight=" + weight + "]";
	}
	
	public static void main(String[] ogre) {
		Mouse jerry = new Mouse(50);
		Mouse gerry = new Mouse(3, 300);
		System.out.println("jerry " + jerry.toString());
		System.out.println("gerry " + gerry.toString());
	}
	
}
