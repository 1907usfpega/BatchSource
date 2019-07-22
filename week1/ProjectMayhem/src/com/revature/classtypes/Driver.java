package com.revature.classtypes;

import com.revature.beans.Person;

public class Driver {

	public static void main(String[] args) {
		Nemo clownFish=new Nemo();
		clownFish.breathe();
		clownFish.findPrey();
		clownFish.swim();
		

		Person c = new Person ("Ren Elsen", 69, 420);
		c.findPrey();
	}

}
