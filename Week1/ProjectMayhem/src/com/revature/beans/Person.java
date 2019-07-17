package com.revature.beans;

public class Person {
	//POJO - plain ol java object
	
	private String name;
	private int age, weight;
	
	/*
	 * code blocks - {things between{}}
	 * static and instance
	 * runs before the constructor
	 * possible use case: 
	 * static-- setting up a DB connection once before object is made
	 * instance-- handling some business before each object instantiation
	 */
	
	//instance code block
	{System.out.println(this.getName() + " is in an instance code block");}
	
	//static code block
	static {System.out.println("im a static code block");}
	
	//constructor with args
	public Person(String name, int age, int weight) {
		this.setName(name);
		this.setAge(age);
		this.setWeight(weight);
	}
	
	//constructor with no args
	public Person() {
		//implicitly calls super(); if we create no args constructor or when system creates default constructor
	}
	
	//getters and setters

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + ", toString()=" + super.toString()
				+ "]";
	}

	
}
