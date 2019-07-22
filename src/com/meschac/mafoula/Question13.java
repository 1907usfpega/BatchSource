package com.meschac.mafoula;

public class Question13 {
	public static String q13() {
		int pos = 1;
		String str = new String();
		for (int col=0; col<5; col++){
		  for (int row=0; row<col; row++){
			  if (pos%2==0) {
				  System.out.print("1 ");
				  str += "1 ";
			  }
			  else {
				  System.out.print("0 ");
				  str += "0 ";
			  }
			  pos++;
		  	}
		  if (pos==1) {continue;} //don't start with newline
		  System.out.println();
		  str += "\n";
		  }
		return str;
	}
}


