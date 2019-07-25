/**
 * 
 */
package Employees;

import Application.Application;
import Driver.Test;

/**
 * @author MajorKey
 *
 */
public class Admin extends Employee{

	
	/**
	 * @param name
	 * @param test
	 */
	public Admin(String name, Test test) {
		super(name, test);
	}

	public void joint(String userName) {
		System.out.println("Hello " + userName + ". My name is " + this.getName() + ". I was told you want a joint account, so let's get started.");
		Application a = new Application();
		a.startJointApplication(this.getTest());
		analyzeApplication(userName, a);
	}
}
