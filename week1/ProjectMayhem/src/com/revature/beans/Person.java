package com.revature.beans;

import java.io.Serializable;

import com.revature.classtypes.Hunt;
import com.revature.exceptions.IncreasedByNegativeNumberException;

public class Person implements Hunt, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -139870160391044081L;
	//POJO plain ol java object
	//more template than actual object?
	private String name;
	private int age;
	private int weight;
	
	public Person() {
		//implicitly get super();
		//even if other things are included
		this.name=null;
		this.age=0;
		this.weight=0;
	}

	//can leave out this if variable names are diff
	//but says its good practice
	public Person(String name, int age, int weight) {
		this.name=name;
		this.age=age;
		this.weight=weight;
	}
	
	//getter and setter
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public int getAge() {
		return age;
	}
	public void setWeight(int weight) {
		this.weight=weight;
	}
	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "name=" + name + ", age=" + age + ", weight=" + weight;
	}

	public void increaseAgeBy(int x) throws IncreasedByNegativeNumberException {
			this.age+=x;
	}

	@Override
	public void findPrey() {
		System.out.println("I hunt men");
	}
	
}
