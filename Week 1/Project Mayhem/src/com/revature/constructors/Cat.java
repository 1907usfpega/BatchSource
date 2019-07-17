package com.revature.constructors;

public class Cat {

	private String name;
	private int age;
	private String temper;
	private int legs;
	private String color;
	
	
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cat(String name, int age, String temper, int legs, String color) {
		super();
		this.name = name;
		this.age = age;
		this.temper = temper;
		this.legs = legs;
		this.color = color;
	}

	public Cat(String name,int age, String temper, int legs) {
		this(name, age, temper, legs, "Brown");
	}
	public Cat(String name,int age, String temper) {
		this(name, age, temper, 4);
	}
	public Cat(String name,int age) {
		this(name, age, "Angry");
	}
	public Cat(String name) {
		this(name, 7);
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + ", temper=" + temper + ", legs=" + legs + ", color=" + color
				+ "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat Tom = new Cat("Tom");
		System.out.println(Tom.toString());
		Cat Peg = new Cat("Peg", 12, "Mild", 3);
		System.out.println(Peg.toString());
	}

}
