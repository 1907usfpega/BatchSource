package com.revature.io;

public class SerialDemo {

	public static void main(String[] args) {
		IO io= new IO();
		/*if output.txt does not exist, it will create it!
		 * If it doesnt exist, run it, and then refresh 
		 * the project
		 * explorer to see it
		 * 
		 */
		/*
		 * String a= "Bond,James Bond."; io.writeOutputStreamContents(a+
		 * " Roll Tide. Woo!");
		 */
		//Read from a file
		System.out.println(io.readInputStreamContents());
	}

}
;