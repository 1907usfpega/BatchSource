package com.revature.beans;

public class Person {
	//POJO- plan ol java object
	private String name;
	private int age;
	private int weight;//code blocks
	
	//Constructor with args
	public Person(String name, int age, int weight) {
		this.name=name;
		this.age=age;
		this.weight=weight;
	}
	//Constructor with no args
	public Person() {
		//implicitly we get - super(); "There but we don't see it".. Only when default is created
	}
	//create getters and setters
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	//next getter setter
	public void setAge(String age) {
		this.age=age;
	}
	public String getAge() {
		return age;
	}
	//next
	public void setWeight(String weight) {
		this.weight=weight; 
	}
	public String getWeight() {
		return weight;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}

}
 