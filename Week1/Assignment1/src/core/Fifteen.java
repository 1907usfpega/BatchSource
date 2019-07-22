package core;

public class Fifteen implements JustSumn {

	
	@Override
	public int add(int a, int b) {
		int result =a;
		for (int i = 0; i < b; i++) {
			result++;
		}
		System.out.println(a+" + "+b+" = "+result);
		return result;
	}

	@Override
	public int subtract(int a, int b) {
		// TODO Auto-generated method stub
		int result = a-b;
		System.out.println(a+" - "+b+" = "+result);
		return result;
	}

	@Override
	public int multiply(int a, int b) {
		int result=a;
		for (int i = 0; i < b; i++) {
			result+=a;	
		}
		System.out.println(a+" x "+b+" = "+result);
		return result;
	}

	@Override
	public double divide(double a, double v) {
		double result = a/v;
		System.out.println(a+" / "+v+" = "+result);
		return result;
	}
	
}
