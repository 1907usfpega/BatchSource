package projectMayhem;

import com.revature.beans.Person;

public class driver {
	//single line comment
	/*this is
	 *  a 
	 * multi-line comment
	 * package is a namespace to 
	 * organize classes and interfaces
	 * package names are lowercase separated by periods
	 * constants are all caps (usually delimited by underscores)
	 * ar
	 *  */
	public static void main(String[] args) {
		/* public - access modifier, anyone can see
		 * static- belongs to the class, does not need to be instantiated
		 * String[] args -parameter utilized in this method
		 * 
		 * */
		System.out.println("Goodbye Earth");
		//ctl /shift /o to import Person
		Person a = new Person("Matt", 33, 270);
		Person b = new Person ("Bob", 22, 130);
		Person c = new Person ("Robert", 22, 450);
		c.increaseAgeBy(-4);
		System.out.println(c.getAge());
		
		
		
		
		System.out.println(a.toString());
		
	}
	
	
	
}
