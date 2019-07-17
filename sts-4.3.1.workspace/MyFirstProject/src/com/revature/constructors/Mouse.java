package com.revature.constructors;

public class Mouse {
	private int numTeeth;
	private int numWhiskers;
	private int weight;

	public static void main(String[] args) {
		Mouse jerry = new Mouse(200);
		Mouse gary = new Mouse(3,300);
		
		System.out.println(jerry.toString());
		System.out.println(gary.toString());
	}	
	
	public Mouse() { super();}
	
	public Mouse(int weight) {
		this(4, weight);
	}
	
	public Mouse(int numWhiskers, int weight) {
		this(17, numWhiskers, weight);
	}

	public Mouse(int numTeeth, int numWhiskers, int weight) {
		super();
		this.numTeeth = numTeeth;
		this.numWhiskers = numWhiskers;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Mouse [numTeeth=" + numTeeth + ", numWhiskers=" + numWhiskers + ", weight=" + weight + "]";
	}

}
