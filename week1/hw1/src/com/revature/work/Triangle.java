package com.revature.work;

public class Triangle {

	public static void tri() {
		int counter=0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<=i;j++) {
				if (counter%2==0) {
					System.out.print("0");
				}
				else {
					System.out.print("1");
				}
				counter++;
			}
			System.out.println("");
			
		}
	}

}
