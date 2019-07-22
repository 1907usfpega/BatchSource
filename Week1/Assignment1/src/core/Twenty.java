package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Twenty {
	public void readData() throws FileNotFoundException{
		String name="";
		String age="";
		String state = "";
		File f = new File("Data.txt");
		Scanner sc = new Scanner(f);
		sc.useDelimiter(":");
		while(sc.hasNext()) {
			name = sc.next();
			name = name+" " + sc.next();
			age = sc.next();
			state = sc.nextLine();
			System.out.println("Name: "+name);
			System.out.println("Age: "+age+" years");
			System.out.println("State: "+state.substring(1)+"\n");
		}
		sc.close();
	}
}
