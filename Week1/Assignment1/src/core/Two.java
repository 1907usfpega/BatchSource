package core;

public class Two {

	public Two() {
		// TODO Auto-generated constructor stub
	}
	public void fibNumber() {
		int a=0;
		int b=1;
		int j =0;
		System.out.print("First 20 Fib numbers: "+0+" ");
		System.out.print(1+" ");
		for(int x=3;x<25;x++) {
			System.out.print(a+b+" ");
			j=a+b;
			a=b;
			b=j;
		}
	}
}
