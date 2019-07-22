package com.revature.hw1;

import java.util.ArrayList;

/*
 * Displays a triangle according to specs using any type of loop. Simple print statements will be unacceptable. (Million years dungeon.)
 * 
 * 0
 * 1 0
 * 1 0 1
 * 0 1 0 1
 */

public class Q13 {

	private static int counter = 0;
	private static ArrayList<Integer> vals = new ArrayList<Integer>();
	
	public static void ioTriangle()
	{
		vals.add(0);
		boolean switcher = false;
		while (counter <= 4)
		{
			for (int i = 0; i < counter; i++)
			{
				if (switcher == false)
				{
					System.out.print("0 ");
					switcher = true;
				}
				else if (switcher == true)
				{
					System.out.print("1 ");
					switcher = false;
				}
			}
			/*
			 * for (int i: vals) { System.out.print(vals.get(i) + " "); }
			 * 
			 * if (vals.get(counter) == null || vals.get(counter) == 1) { vals.add(0); }
			 * 
			 * else if (vals.get(counter) == 0) { vals.add(1); }
			 */
			counter++;
			System.out.println("");
		}
	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
