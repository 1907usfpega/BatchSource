package com.revature.constructors;

public class mouse {
	private int numTeeth;
	private int numWhiskers;
	private int weight;
	
		
	public mouse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public mouse(int numTeeth, int numWhiskers, int weight) {
		super();
		this.numTeeth = numTeeth;
		this.numWhiskers = numWhiskers;
		this.weight = weight;
	}
	
	public mouse(int numWhiskers, int weight) {
		this(17, numWhiskers, weight);
	}
	public mouse(int weight) {
		this(4, weight);
	}
	@Override
	public String toString() {
		return "mouse [numTeeth=" + numTeeth + ", numWhiskers=" + numWhiskers + ", weight=" + weight + "]";
	}

	public static void main(String[] args) {
		mouse jerry = new mouse(200);
		mouse gerry = new mouse(3, 303); 
		System.out.println(jerry.toString());
		System.out.println(gerry.toString());
	}
}
