package homework1;

import java.util.ArrayList;
import java.util.List;

public class Problem9 {
	
	static void primeNumbers() {
		
		//Creates an ArrayLists to store numbers
		List<Integer> primes = new ArrayList<Integer>();

		//Adds the numbers 1-100 to the list
		for(int i = 1; i <= 100; i++ ) {
			primes.add(i);
		}
			
		//Creates the beginning of the print statement
		System.out.println("Q9.) These are all the prime numbers between 1-100:");
	
		//Uses a for loop to iterate through the loop and find the prime numbers
		for(int x = 1; x < primes.size()-1; x++ ) {
			boolean prime = true;
			
			//Test each number 1-100 using modulus
			for (int i = 2; i < primes.get(x); i++) 
				if (primes.get(x) % i == 0) {
					prime = false; //<--Numbers that are not prime will be false
			    }
			if(prime) {
				System.out.print(primes.get(x) + "  "); //<--Prints only the prime numbers
			}		
		}
		
	}//end primeNumbers()

}//end Problem9 class
