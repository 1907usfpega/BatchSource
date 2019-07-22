package com.revature.io;

import com.revature.beans.Person;

public class SerialDemo {

	public static void main(String[] args) {
		IO io =new IO();
		/*String a="Edogawa Conan, tantei da.";
		io.writeOutputStreamContents(a);
		io.writeOutputStreamContents(a+" shut up you're like 12");
		*/
		//System.out.println(io.readInputStreamContents());
		
		/*Person p1=new Person("Matt",35,256);
		Person p2=new Person("Ren",25,120);
		Person p3=new Person("Hann",22,100);
		IOWithCollections.pList.add(p1);
		IOWithCollections.pList.add(p2);
		IOWithCollections.pList.add(p3);
		
		IOWithCollections.writePersonFile();*/
		
		IOWithCollections.readPersonFile();
		System.out.println(IOWithCollections.pList.toString());
	}

}
