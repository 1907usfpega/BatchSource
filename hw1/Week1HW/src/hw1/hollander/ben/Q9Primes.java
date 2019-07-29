package hw1.hollander.ben;
import java.util.ArrayList;
import java.util.Iterator;

public class Q9Primes {
	public static ArrayList<Integer> q9(int maxNum) {
		//not sure how to implement Eratosthenes sieve
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		//ArrayList cannot handle primitive
		for (int i=1; i<=maxNum; i++) { //add 1-100 into arr
			arr.add(i);
		}
		Iterator<Integer> itr = arr.iterator();
		while (itr.hasNext()) {
			int n = (int) itr.next(); //cast to int
			int divisor = n-1;
			while(divisor >= 1) {
				if (n==1 || n==2) {
					System.out.println(n); //Will print out 1 & 2 if they are passed in
					primes.add(n);
					break;
				}
				if (n%divisor==0) {
					break;
				}
				divisor--;
				if (divisor==1) {
					System.out.println(n);
					primes.add(n);
				}
				
			}
		}
		return primes;
	}
}
//COMPLETED