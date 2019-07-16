package com.revature.driver.beans;

public class Person 
{
	//this is a POJO: plain ol java object
	public String name;
	public int age;
	private int weight;
	
	
	
	//default constructor
	public Person()
	{
		//implicitly we get the constructor of the super class
		//sometimes we shouldn't put values into the default constructor
	}
	
	//constructor with args
	public Person(String name, int age, int weight)
	{
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	//acessor method for name
	public String getName() 
	{
		return name;
	}
	
	//mutator method for name
	public void setName(String name) 
	{
		this.name = name;
	}
	
	//acessor method for age
	public int getAge() 
	{
		return age;
	}
	
	//mutator method for age
	public void setAge(int age) 
	{
		this.age = age;
	}
	
	//acessor method for weight
	public int getWeight() 
	{
		return weight;
	}
	
	//mutator method for weight
	public void setWeight(int weight) 
	{
		this.weight = weight;
	}
	
	//instance code block runs before constructor
	{
		System.out.println(this.getName() + " is in a code block");
	}
	
	static //static code block runs before constructor
	{
		System.out.println("Im a static code block!");
	}
	
	//toString override
	public String toString()
	{
		return "Name: "+name+"\nAge: "+age+"\nWeight: "+weight+"\n";
	}

}
