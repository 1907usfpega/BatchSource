package com.revature.beans;

<<<<<<< HEAD
import java.io.Serializable;

import com.revature.classtypes.Hunt;
import com.revature.exceptions.IncreasedByNegativeNumberException;

public class Person implements Hunt,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4986267534723049849L;
	//POJO- plain ol java object
	private String name;
	private int age;
	private int weight;
	//code blocks- {things between}
	//static and instance
	//instance code block, runs before the constructor
	{System.out.println(this.getName()+ "is in an instance code block!");}
	//static code block
	static {System.out.println("im a static code block");}
	//Constructor with args
	public Person(String name,int age, int weight) {
		this.name=name;
		this.age=age;
		this.weight=weight;
	}
	//Consturctor with no args
	public Person() {
		//Implicitly we get - super();
	}
	//getters and setters
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	 public void increaseAgeBy(int x) throws IncreasedByNegativeNumberException {
		if(x<0) {
			throw new IncreasedByNegativeNumberException();
		}
		 this.age+=x;
	 }
	@Override
	public void findPrey() {
		System.out.println("I go to WalMart, meeeeeegh");
		
	}
=======
import com.revature.classtypes.Hunt;

public class Person implements Hunt {
	//POJO - plain ol java object
	
	@Override
	public void findPrey() {
		// TODO Auto-generated method stub
		System.out.println("I go to Walmart)!!!");
	}

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

>>>>>>> ec17887aa226515703225d76adef61fef521f005
	
}
