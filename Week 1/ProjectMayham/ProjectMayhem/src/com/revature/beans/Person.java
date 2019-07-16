package com.revature.beans;

public class Person {
	//POJO - plain ol' java object
	private String name;
	private int age;
	private int weight;
	
	// code blocks - {things between}
	// static and instance
	
	// static code block
	static {System.out.println("I'm a static code block!");}
	
	// Constructor with args
	public Person(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	// Constructor without args
	public Person() {
		// implicitly we get - super();
	}
	
	// instance code block
	// runs before the constructor
	{System.out.println(this.getName() + " I'm in an instance code block!");}
	
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
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	
	
}
