package com.revature.classtypes;

public interface Hunt {
	void findPrey();
	default void hide() {
		System.out.println("sneak!");
	}
}
