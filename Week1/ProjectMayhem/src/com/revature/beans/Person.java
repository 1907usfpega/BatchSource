package com.revature.beans;

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
	
}
