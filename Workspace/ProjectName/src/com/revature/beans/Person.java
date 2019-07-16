package com.revature.beans;

public class Person {
	//POJO = plain old java object
	private String name;
	private int age;
	private int weight;
	//codeblocks - things between braces
	//static and instance
	//instance codeblock; runs before the constructor;
	{System.out.println("i'm in an instance code block");}
	//static codeblock:
	static {System.out.println("I'm a static codeblock");}
	
	public Person() {
		this("Anton", 9, 115);
	}
	
	public Person(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
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
	
	public int getWeigth() {
		return weight;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
}
