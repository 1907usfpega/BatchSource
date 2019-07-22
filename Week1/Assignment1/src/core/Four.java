package core;

public class Four {

	public Four() {
		// TODO Auto-generated constructor stub
	}
	public int factorial(int n) {
		int a=1;
		for(int x=n;x>0;x--) {
			a=a*x;
		}
		return a;
	}
}
