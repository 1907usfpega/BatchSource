package questions;
import java.util.ArrayList;

public class Q19 {
	private static ArrayList<Integer> ints = new ArrayList<Integer>();

	public static void q19(int n) {
		for (int i = 0; i < n; i++) {
			ints.add(i+1);
		}
		System.out.println("Original Array:");
		System.out.println(ints.toString());
		
		int sum = 0;
		for(int i:ints ) {
			if(i%2 == 0) {
				sum+=i;
			}
		}
		System.out.println("\nSum of evens: "+sum);
		
		sum = 0;
		for(int i:ints ) {
			if(i%2 != 0) {
				sum+=i;
			}
		}
		System.out.println("\nSum of odds: "+sum);
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		boolean isPrime;
		for(int x: ints) {
			//System.out.println("\nTesting "+x);
			isPrime = true;
			if(x==1) {//1 is the only number which is neither prime nor composite
				isPrime = false;
			}
			for(int p:primes) {
				//System.out.print(p+" ");
				if(x%p == 0) {
					//System.out.println("\n"+x+" is divisible by "+p);
					isPrime=false;
					break;
				}//end if
			}//end foreach primes
			if(isPrime) {
				primes.add(x);
			}
		}//end foreach ints
		for(int p:primes) {
			ints.remove(ints.indexOf(p));		
		}
		
		System.out.println("\nArray without primes: ");
		System.out.println(ints);

	}// end q19
}// end Q19
