package com.revature.classtypes;

public class Shark extends Fish implements Hunt{

	@Override
	public void findPrey() {
		System.out.println("I ate fishies!");
		
	}
	@Override
	public void swim() {
		System.out.println("da dum. daa dum. da dum da dum da dum.");
		
	}

	@Override
	public void breathe() {
		System.out.println("I don't need air!");
		
	}


}
