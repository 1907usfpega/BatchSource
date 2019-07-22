package com.revature.arrays;

public class FunWithArrays {
	//gorup of like-typed variables that are referred to by a compiler

	public static void main(String[] args) {
		int s=7;
		//create int array with 7 "buckets"
		int [] myArray= new int[s];
		//int myArray[]= new int[s]; <- still cool
		//in array w/ hardcoded values
		int [] chaos= {3,5,6,3,2,664,345,224,7663};
		
		System.out.println(chaos[1]);
		System.out.println(chaos);
		// TODO Auto-generated method stub
		for (int i=0;i<myArray.length;i++) {
			myArray[1]=i*5
					//System.out.println(i+ "element is" + myArray[1]);
		}
		for (int i:chaos) {
			System.out.println(i);
		}
		System.out.println(Arrays.toString(chaos));
		Arrays.sort(chaos);
		System.out.println(Arrays.toString(chaos));

	}

}
