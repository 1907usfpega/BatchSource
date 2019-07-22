package com.revature.funfactory;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HondaFactory hf = new HondaFactory();
		Car c1 = hf.getCar("crv", "red");
		Car c2 = hf.getCar("civic", "blackblue");
		System.out.println(c1);
		System.out.println(c2);
	}

}
