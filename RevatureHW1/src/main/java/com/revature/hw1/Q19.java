package com.revature.hw1;

import java.util.ArrayList;

/*
 * Create an ArrayList and insert integers 1 through 10. Display 
 * the ArrayList. Add all the even numbers up and display the 
 * result. Add all the odd numbers up and display the result. 
 * Remove the prime numbers from the ArrayList and print out the 
 * remaining ArrayList.
 */

public class Q19 {
	private ArrayList<Integer> integerList = new ArrayList<Integer>();
	private Integer evenSum = 0;
	private Integer oddSum = 0;
	
	//Adds integers according to requested length.
	public ArrayList<Integer> addInts(int a)
	{
		for (int i = 1; i <= a; i++)
		{
			integerList.add(i);
		}
		
		return integerList;
	}
	
	public Integer addEvens(ArrayList<Integer> a)
	{
		for (int i = 0; i < integerList.size(); i++)
		{
			if (Q6.evenFlow(integerList.get(i)) == true)
			{
				evenSum += integerList.get(i);
			}
		}
		return evenSum;
	}
	
	public Integer addOdds(ArrayList<Integer> a)
	{
		for (int i = 0; i < integerList.size(); i++)
		{
			if (Q6.evenFlow(integerList.get(i)) == false)
			{
				oddSum += integerList.get(i);
			}
		}
		return oddSum;
	}
	
	public ArrayList<Integer> removePrimes(ArrayList<Integer> a)
	{
		
		for (int j = 0; j < a.size(); j++)
		{
			Integer val = a.get(j);
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
				a.remove(j);
			}
			else
			{
				continue;
			}
		}
		
		return a;

	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
