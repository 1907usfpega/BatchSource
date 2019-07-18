package com.revature.classtypes;

public class Shark extends Fish implements Hunt {

	@Override
	public void findPrey() {
		System.out.println("I ate fishes!");
	}

	@Override
	public void swim() {
		System.out.println("I swim in water and I'm terrifying.");
	}

	@Override
	public void breathe() {
		System.out.println("I breathe underwater, meeeeeeeeegh");
	}
	
}
