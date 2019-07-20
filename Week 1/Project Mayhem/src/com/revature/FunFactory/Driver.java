package com.revature.FunFactory;

public class Driver {
	public static HandaFactory hf = new HandaFactory();
	public static void main(String[] args) {
		Car c1 = hf.getCar("crv", "red");
		Car c2 = hf.getCar("civic",  "white");
		Car c3 = hf.getCar("lemon", "clear");
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);

	}
}
