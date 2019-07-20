package com.revature.funFactory;

public class Driver {
	public static HondaFactory hf = new HondaFactory();
	
	public static void main(String args[]) {
		Car c1 = hf.getCar("crv", "red");
		Car c2 = hf.getCar("civic", "blue");
		Car c3 = hf.getCar("potato", "clear");
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}

	public Driver() {
		// TODO Auto-generated constructor stub
	}

}
