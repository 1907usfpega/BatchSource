package Assignment.Java;

public class JavaQ4NFactorial {

	public static void main(String[] args) {
		int i, factorial=1;
		int n= 10;
		for(i=1;i<=n; i++) {
		factorial=factorial*i;
	
	}
		System.out.println("Factorial of: "+n+"\nis: "+factorial);
	}
}