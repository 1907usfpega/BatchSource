package com.revature.beans;

public class Person {
	//POJO - plain ol java object
	
	private String name;
	private int age;
	private int weight;
	
	public static void main (String[] args){
		System.out.println("I am in the MAIN method");
		Person a = new Person();
		Person b = new Person();
	}
	
	//Instance & Static code blocks
	{System.out.println("I am a INSTANCE code of block");}
	static {System.out.println("I am a STATIC code of block");}
	
	public Person(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	public Person() {
		//implicity calls super();
	}
	
	//GETTERS AND SETTERS (Alt+Shift+S)
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getWeight() {
		return weight;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	
	

}