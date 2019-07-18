package com.revature.classtypes;

public class Shark extends Fish implements Hunt{

	public Shark() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void findPrey() {
		System.out.println("I ate fishes!");
	}
	@Override
	public void swim() {
		System.out.println("I am terrifying in water!");
	}
	@Override
	public void breathe() {
		System.out.println("I have gills, rawr!");
	}
	

}
