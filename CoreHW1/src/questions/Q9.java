package questions;
import java.util.ArrayList;

public class Q9 {
	public static void prime(int n) {
		ArrayList<Integer> ints = new ArrayList<Integer>();
		//populate ArrayList with 1 through n
		for (int j = 0; j < n; j++) {
			ints.add(j+1);
		}
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
		
		//print all primes
		for(int i:primes) {
			System.out.print(i+" ");
		}
		System.out.println();
		
	}//end prime
}//end Q9
