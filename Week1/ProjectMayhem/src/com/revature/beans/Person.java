package com.revature.beans;

public class Person {
	//POJO: plain ol' Java object
	private String name;
	private int age;
	private int weight;
	
	{System.out.println(this.getName()+ " is an instance of ");}

	static {System.out.println(" is an instance of ");}
	//constructor w/ args
	public Person(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	//constructor w/out args
	public Person() {
		//implicitly we get super();
	}
	public void increaseAgeBy(int x) {
		this.age += x;
	}
	//getters and setters
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getWeight() {
		return this.weight;
	}
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
}
