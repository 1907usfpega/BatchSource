package com.revature.classtypes;

public class Nemo extends Fish implements Hunt{

	@Override
	public void findPrey() {
		System.out.println("I ate fish");
	}

	@Override
	public void swim() {
		System.out.println("I go nyoom");
	}

	@Override
	public void breathe() {
		System.out.println("I breath water");
	}
	
}
