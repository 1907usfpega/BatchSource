package com.revature.io;
//supposed to import a whole bunch of these


public class IOWithCollections {
	private static final String personFile= "person.txt";
	public static ArrayList<Person> personList=
			new ArrayList<Person>();
	
	public static void writePersonFile() {
		ObjectOutputStream objectOut=
				new ObjectOutputStream( new FileOutputStream(personFile));
		objectOut.writeObject(personList);
		
	objectOut.close();
		//WHOLE THING JUST NOT FINISHED
	}
			
	

}
