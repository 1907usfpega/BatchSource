package com.revature.beans;

import java.io.Serializable;

import com.revature.classtypes.Hunt;
import com.revature.exceptions.IncreasedByNegativeNumberException;

public class Person implements Hunt, Serializable{
	//POJO - plain ol java object
	private String name;
	private int age;
	private int weight;
	
		//instance code block
		//{System.out.println(this.name+" is in an instance code block!");}
		//static code block
		//static {System.out.println("I'm in a static code block.");}
	
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
	
	public boolean equals(Person p) {
		return( this.name == p.name && this.age==p.age && this.weight == p.weight);
	}
	
	public void increaseAgeBy(int x) throws IncreasedByNegativeNumberException {
		if(x<0) {
			throw new IncreasedByNegativeNumberException();
		}
		this.age+=x;
	}
	@Override
	public void findPrey() {
		System.out.println("I go grocery shopping");
		
	}
	
}
