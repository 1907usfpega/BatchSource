package com.revature.constructors;

public class Mouse {
	private int numTeeth;
	private int numWhisk;
	private int weight;
	
	
	public Mouse() {
		super();
	}
	
	public Mouse(int weight) {
		this(4,weight);
	}
	
	public Mouse(int numWhisk, int weight) {
		this(17,numWhisk,weight);
	}

	public Mouse(int numTeeth, int numWhisk, int weight) {
		super();
		this.numTeeth = numTeeth;
		this.numWhisk = numWhisk;
		this.weight = weight;
	}


	@Override
	public String toString() {
		return "Mouse [numTeeth=" + numTeeth + ", numWhisk=" + numWhisk + ", weight=" + weight + "]";
	}
	
	public static void main (String[] args) {
		Mouse a = new Mouse(200);
		Mouse b = new Mouse(3,21);
		Mouse c = new Mouse(13,23,51);
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
	}
}
