package day2.pt2;

public class Mouse {

	//Declare variables
	private int numTeeth;
	private int numWhiskers;
	private int weight;
	
	
	//Generate default constructor
	public Mouse() {
		super();
	}
	
	//Constructor with 1 parameter defined
	public Mouse (int weight) {
		this(4,weight); //Calls next constructor and passes in values
	}
	
	//Constructor with 1 parameter defined and 1 value passed in
	public Mouse(int numWhiskers, int weight) {
		this(12, numWhiskers,weight); //calls other constructor
	}
	
	//Generate constructor with all args and values will be passed in
	public Mouse(int numTeeth, int numWhiskers, int weight) {
		super();
		this.numTeeth = numTeeth;
		this.numWhiskers = numWhiskers;
		this.weight = weight;
	}
	
	//Generate toString() method
	@Override
	public String toString() {
		return "Mouse [numTeeth=" + numTeeth + ", numWhiskers=" + numWhiskers + ", weight=" + weight + "]";
	}

	
	public static void main(String[] args) {
	
		Mouse none = new Mouse(); //will result in default values
		Mouse Jerry = new Mouse(4); //passes in a weight
		Mouse Mighty = new Mouse(6,7); //passes in whiskers & weight

		System.out.println(none.toString()); //prints out info
		System.out.println(Jerry.toString()); 
		System.out.println(Mighty.toString());
		
	}//end main

}//end class Mouse
