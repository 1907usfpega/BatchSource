package com.revature.beans;

import java.io.Serializable;

public class Person implements Serializable{
private String name;
private int age;
private int weight;
//codeblocks - things between the  { }
//static blocks and instance blocks
// an instance code block is 

{System.out.println("I'm an instance code block!)");}
static {System.out.println("I'm a static block");}



public Person(){
	
}

public Person ( String name, int age, int weight){
	this.name = name;
	this.age=age;
	this.weight=weight;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
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
public void increaseAgeBy(int x) {
	this.age+=x;
}
}		 


