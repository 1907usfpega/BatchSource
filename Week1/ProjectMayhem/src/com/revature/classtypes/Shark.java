/**
 * 
 */
package com.revature.classtypes;

/**
 * @author MajorKey
 *
 */
public class Shark extends Fish implements Hunt{

	@Override
	public void findPrey() {
		// TODO Auto-generated method stub
		System.out.println("I ate fishesssss");
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		System.out.println("I swim in water like a boss and I'm terrifying.");
	}

	@Override
	public void breathe() {
		// TODO Auto-generated method stub
		System.out.println("I breathe underwater.");
	}

}
