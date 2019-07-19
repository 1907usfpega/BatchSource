package com.revature.classtypes;

public class Shark extends Fish implements Hunt, Hide{

	@Override
	public void findPrey() {
		System.out.println("SCANNINNNNG");
	}

	@Override
	public void swim() {
		System.out.println("swimming");
		
	}

	@Override
	public void breath() {
		System.out.println("innnn and ouuutttt");
		
	}
	
}
