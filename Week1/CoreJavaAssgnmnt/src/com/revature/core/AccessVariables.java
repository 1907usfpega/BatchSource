/**
 * 
 */
package com.revature.core;

import com.revature.core.helper.AccessFloats;

/**
 * @author MajorKey
 *Question 11
 */
public class AccessVariables {

	private AccessFloats access = new AccessFloats();
	
	public void changeGpa(float gpa) {
		access.setGpa(gpa);
	}
	public void changePrice(float price) {
		access.setPrice(price);
	}
	public void addFloats() {
		System.out.println(access.getGpa() + access.getPrice());
	}
}
