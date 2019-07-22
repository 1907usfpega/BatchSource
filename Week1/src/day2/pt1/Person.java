package day2.pt1;

import java.io.Serializable;

import day3.pt2.NegativeNumberException;
import day4.pt1.Hunt;

public class Person implements Hunt, Serializable{
	
	//POJO: Plain ol Java Object
	private String name;
	private int age;
	private int weight;
	
	
//------------------------------------Constructors-----------------------------------------
	public Person() { //<-- Constructor with no parameters/arguments
		//Default constructor
		//Once you add constructor with args, you need to specify one without if you want it
		//Has a built in super();
	}
	
	
	public Person(String name, int age, int weight) { //<-- Constructor with all parameters/args

		//this.object = parameter passed in
		this.name = name;  
		this.age = age;
		this.weight = weight;
		
	}
	
//------------------------------------Getters & Setters------------------------------------
	public void setName(String name) { //<-- Setter for name, need to pass in String name arg
		this.name = name;			  //<-- Return type is void (no return)
	}
	
	public String getName() { //<-- Return type is String, do not pass in args
		return name;
	}
	
	
	public void setAge(int age) { //<-- Setter for age, need to pass in int age arg
		this.age = age;			  //<-- Return type is void (no return)
	}
	
	public int getAge() { //<-- Return type is int, do not pass in args
		return age;
	}
	
	
	public void setWeight(int weight) { //<-- Setter for weight, need to pass in int weight arg
		this.weight = weight;			  //<-- Return type is void (no return)
	}
	
	public int getWeight() { //<-- Return type is int, do not pass in args
		return weight;
	}

	
//------------------------------------toString--------------------------------------------
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	

//------------------------------------Increase Age----------------------------------------

	public void increaseAge(int x) throws NegativeNumberException {
		if(x<0) {
			throw new NegativeNumberException();
		}
		this.age += x;
	}

	
//------------------------------------Implemented Methods----------------------------------------
	@Override
	public void findPrey() {
		System.out.println("Going grocery shopping.");
		
	}
	
}//end Person Class