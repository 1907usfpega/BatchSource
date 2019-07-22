package com.revature.classtype;

public class Shark extends Fish implements Hunt{

	@Override
	public void findPrey() {
		System.out.println("I eat stuff");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swim() {
		System.out.println("I swim in water and I'm terrifying.");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void breathe() {
		System.out.println("I breathe under water, meeeee");
		// TODO Auto-generated method stub
		
	}

}
