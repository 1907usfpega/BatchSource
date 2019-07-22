package com.revature.classtypes;

public class Shark extends Fish implements Hunt {

	@Override
	public void findPrey() {
		// TODO Auto-generated method stub
		System.out.println("I hate fish");
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		System.out.println("I swim in water and....");
	}

	@Override
	public void breath() {
		// TODO Auto-generated method stub
		System.out.println("I breathe underwater");
	}
	

}
