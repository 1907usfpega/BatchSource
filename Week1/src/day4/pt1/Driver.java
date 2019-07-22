package day4.pt1;

import day2.pt1.Person;

public class Driver {

	public static void main(String[] args) {
		
		Shark Bruce = new Shark();
		Bruce.swim();
		Bruce.findPrey();
		Bruce.breathe();

		System.out.println();
		
		Person gal = new Person();
		gal.findPrey();
	}

}
