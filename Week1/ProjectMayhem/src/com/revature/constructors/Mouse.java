<<<<<<< HEAD
package com.revature.constructors;

public class Mouse {
	private int numTeeth;
	private int numWhiskers;
	private int weight;
	
	
	public Mouse() {
		super();
		}
	public Mouse (int weight) {
		this(4,weight);
	}
	
	public Mouse(int numWhiskers, int weight) {
		this(17,numWhiskers,weight);
	}
	public Mouse(int numTeeth, int numWhiskers, int weight) {
		super();
		this.numTeeth = numTeeth;
		this.numWhiskers = numWhiskers;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Mouse [numTeeth=" + numTeeth + ", numWhiskers=" + numWhiskers + ", weight=" + weight + "]";
	}
	public static void main(String[] args) {
		Mouse jerry= new Mouse(200); 
		Mouse gary=new Mouse(3,303);
		Mouse terry= new Mouse();
		System.out.println(jerry.toString());
		System.out.println(gary.toString());
		System.out.println(terry.toString());
	}

=======
/**
 * 
 */
package com.revature.constructors;

/**
 * @author MajorKey
 *Chaining constructors
 */
public class Mouse {

	private int newTeeth, numWhiskers, weight;
	
	/**
	 * 
	 */
	public Mouse() {
		super();
	}

	/**
	 * @param weight
	 */
	public Mouse(int weight) {
		//super();
		//this.weight = weight;
		this(4, weight);
	}

	/**
	 * @param numWhiskers
	 * @param weight
	 */
	public Mouse(int numWhiskers, int weight) {
		//super();
		//this.numWhiskers = numWhiskers;
		//this.weight = weight;
		this(17,numWhiskers,weight);
	}

	/**
	 * @param newTeeth
	 * @param numWhiskers
	 * @param weight
	 */
	public Mouse(int newTeeth, int numWhiskers, int weight) {
		super();
		this.newTeeth = newTeeth;
		this.numWhiskers = numWhiskers;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Mouse [newTeeth=" + newTeeth + ", numWhiskers=" + numWhiskers + ", weight=" + weight + "]";
	}

	public static void main(String [] args) {
		Mouse jerry = new Mouse(200);
		Mouse gary = new Mouse(3,303);
		
		System.out.println(jerry.toString());
		System.out.println(gary.toString());
	}
>>>>>>> ec17887aa226515703225d76adef61fef521f005
}
