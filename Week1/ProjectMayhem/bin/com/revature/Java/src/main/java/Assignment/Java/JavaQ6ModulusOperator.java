package Assignment.Java;

public class JavaQ6ModulusOperator {

	static boolean numEven(int x) {
		boolean numEven = true;
		for(int i=1;1<=x; i++)
			numEven = !numEven;
		return numEven;
	}
	public static void main(String args[]) {
		int x = 4;
		if(numEven(x))
			System.out.println("is even");
		else
			System.out.println("is odd");
	}
}

