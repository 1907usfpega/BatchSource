/**
 * 
 */
package com.revature.constructors;

/**
 * @author MajorKey
 * A class exercise to practice chaining constructors
 * It is common practice to use this format 
 */
public class ClassExercise {
	
	private  int age, weight, height, force;
	private String name;

	/**
	 * @param age
	 * @param weight
	 * @param height
	 * @param force
	 * @param name
	 */
	public ClassExercise(int age, int weight, int height, int force, String name) {
		super();
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.force = force;
		this.name = name;
	}

	/**
	 * @param age
	 * @param force
	 * @param name
	 */
	public ClassExercise(int age, int force, String name) {
		//super();
		//this.age = age;
		//this.force = force;
		//this.name = name;
		this(age,150,7, force, name);
	}

	/**
	 * @param age
	 * @param name
	 */
	public ClassExercise(int age, String name) {
		//super();
		//this.age = age;
		//this.name = name;
		this(age, 600, name);
	}

	/**
	 * @param name
	 */
	public ClassExercise(String name) {
		//super();
		//this.name = name;
		this(40, name);
	}

	/**
	 * 
	 */
	public ClassExercise() {
		super();
	}

	@Override
	public String toString() {
		return "ClassExercise [age=" + age + ", weight=" + weight + ", height=" + height + ", force=" + force
				+ ", name=" + name + "]";
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassExercise a = new ClassExercise();
		ClassExercise b = new ClassExercise("Bob");
		ClassExercise c = new ClassExercise(22, "Deonta");
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
	}

}
