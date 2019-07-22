package factory;

public class Driver {
	
	public static HondaFactory hf = new HondaFactory();
	public static void main(String[] args) {
		Car c1 = hf.getCar("crv", "teal");
		Car c2 = hf.getCar("civic", "white");
		Car c3 = hf.getCar("potato", "brown");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
	}//end main
	
	
}//end Driver class
