package Assignment.Java;

import java.util.ArrayList;
import java.util.List;

public class JavaQ9ArrayList100 {
		public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		int i;
		  
		// storing from 1 to 100
		for(i=1; i<=100; i++)
		list.add(i);
		  
		for(int num: list)
		{
		// logic for prime number
		// if it is divisible by any, breaking loop
		for(i=2; i<num; i++)
		{
		if(num%i == 0)
		break;
		}
		  
		// if it's not divisible by any then it comes till i is num
		if(i==num)
		System.out.print(num+" ");
		}
		}
		}

