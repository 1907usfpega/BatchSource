package com.revature.beans;

import java.io.Serializable;

import com.revature.exceptions.increaseByNegativeNumberExcpetion;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2244017761814744441L;
	/*POJO- plain ol java object:
	 * has private fields
	 * doesn't do anything
	 */
	private String name; 
	private int age; 
	private int weight;
	//code blocks- {things between}
	//static and instance
	
	//instance code block
	//runs before the constructor so getName will be null
	{System.out.println(this.getName() + " is in a code block");}
	
	static {System.out.println("im a static code block!");}
	
	//Constructor with args
	public Person(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	//Constructor without args
	public Person() {
		//implicitly we get -super()
	}
	//getters and setters
	//Alt-Shift-S
	//can auto generate getters/setters/ and constructors
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

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	public void increaseAgeby(int x) throws increaseByNegativeNumberExcpetion {
		if(x<0) {
			throw new increaseByNegativeNumberExcpetion();
		}
		this.age+=x;
	}
	
}
