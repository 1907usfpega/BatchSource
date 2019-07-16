package com.revature.beans;

public class Person {
	//POJO - plain ol java object
	private String name;
	private int age;
	private int weight;
	
		//instance code block
		{System.out.println(this.name+" is in an instance code block!");}
		//static code block
		static {System.out.println("I'm in a static code block.");}
	
	//constructors
	public Person() {
		//Implicitly we get super();
	}
	public Person(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	
	//getters and setters
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getWeight() {
		return weight;
	}
	@Override
	public String toString() {
		return "Person [name = " + name + ", age = " + age + ", weight = " + weight + "]";
	}
	
	
}
