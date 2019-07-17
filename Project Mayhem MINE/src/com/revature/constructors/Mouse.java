package com.revature.constructors;

public class Mouse {
	private int numTEET;
	private int numWhiskers;
	private int weight;
	}

public Mouse() {
	super();
}
public Mouse(int numWhiskers, int weight) {
	this()
	

	public Mouse(int numWhiskers, int weight) {
		this(17,numWiskers,weight);}
	
	super();
	this.numWhiskers = numWhiskers;
	this.weight = weight;
}



	public Mouse(int numTEET, int numWhiskers, int weight) {
		super();
		this.numTEET = numTEET;
		this.numWhiskers = numWhiskers;
		this.weight = weight;
	}


	@Override
	public String toString() {
		return "Mouse [numTEET=" + numTEET + ", numWhiskers=" + numWhiskers + ", weight=" + weight + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mouse jerry= new Mouse(200);
		Mouse gary=new Mouse(3,300);
		
		System.out.println(jerry.toString());
		System.out.println(gary.toString());

	}

}
