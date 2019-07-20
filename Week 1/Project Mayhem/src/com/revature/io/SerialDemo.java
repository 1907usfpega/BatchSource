package com.revature.io;

public class SerialDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IO io = new IO();
		/* If output.txt does not exist, it will create it!
		 * If it doesn't exist, run it and then refresh the 
		 * project explorer to see it
		 * 
		 */
//		String a = "Bone, James, Bond";
//		io.writeOutputStreamContents(a + "Roll Tide! Boi!");
		//Read from a file
		
		//System.out.println(io.readInputStreamContents());
		
//		Person p1 = new Person("matty boi", 100, 10000);
//		Person p2 = new Person("leo", 24, 130);
//		Person p3 = new Person("brad", 25, 150);
//		IOWithCollections.personList.add(p1);		
//		IOWithCollections.personList.add(p2);
//		IOWithCollections.personList.add(p3);
//		
//		IOWithCollections.writePersonFile();
		
		IOWithCollections.readPersonFile();
		System.out.println(IOWithCollections.personList.toString());
	}

}
