package com.revature.hw1;

import java.util.ArrayList;

/*
 * Create an ArrayList that stores #s 1-100 and prints out all
 * prime numbers to console.
 */

public class Q9 {

	public static ArrayList<Integer> primeParse()
	{
		ArrayList<Integer> vals = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
	
		for (int i = 1; i <= 100; i++)
		{
			vals.add(i);
		}
		
		/*
		 * Prime checker. If value isn't 1 or the number and has
		 * no remainder, it isn't prime, so won't be added to the list.
		 * Otherwise, will be added.
		 */
		for (int j = 0; j < vals.size(); j++)
		{
			Integer val = vals.get(j);
			int counter = 0;
			for (int k = 1; k < val; k++)
			{
			//	System.out.println(val + "/" + k + "=" + val/k);
				if (k > 1 && k < val)
				{
					int rem = val % k;
					if(rem == 0)
					{
						counter += 1;
					}
				}	
			}
			if (counter == 0)
			{
				primes.add(val);
			}
			else
			{
				continue;
			}
		}
		
		
		System.out.println("Q9: Primes are " + primes.toString());
		
		return primes;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
