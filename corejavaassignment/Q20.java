		package com.revature.corejavaassignment;
		import java.io.*;
		
		public class Q20 {
		
			public Q20() throws IOException{
				System.out.println("********** Q20 **********\n");		
		FileReader fr = null;
		
		try {
		   fr = new FileReader("C:\\Users\\ljapp\\Desktop\\"
		   		+ "Git\\BatchSource\\Week1\\ProjectMayhem\\src\\"
		   		+ "com\\revature\\corejavaassignment\\Data.txt");
		   int i;
		   char c;
		   String outStr = "";
		   int partOfId = 0;
		   String tempString = "";
		   while ((i = fr.read()) != -1) {
			  c =(char)i;
			  switch(c) {
				case '\n':
					partOfId = 0;
					tempString = tempString.substring(0, tempString.length() - 1);
					outStr = outStr.concat("State: " + tempString + " State\n\n");
					//System.out.println("State: " + tempString + " State\n");
					tempString = "";
					break;
				case ':':
					switch(partOfId) {
						case 0:
							outStr = outStr.concat("Name: " + tempString);
							//System.out.print("Name: " + tempString);
							partOfId++;
							break;
						case 1:
							outStr = outStr.concat(" " + tempString + "\n");
							//System.out.println(" " + tempString);
							partOfId++;
							break;
						case 2:
							outStr = outStr.concat("Age: " + tempString + " years\n");
							//System.out.println("Age: " + tempString + " years");
							partOfId++;
							break;		
					}
					tempString = "";
					break;
				default:
					tempString += String.valueOf(c);
					break;
			  }
		   }
		   outStr = outStr.concat("State: " + tempString + " State\n\n");
		  // System.out.println("State: " + tempString + " State\n");
		   Q20Test tester = new Q20Test(outStr, "Name: Mickey Mouse\n" + 
		   										"Age: 35 years\n" + 
										   		"State: Arizona State\n\n" +
										   		"Name: Hulk Hogan\n" + 
										   		"Age: 50 years\n" + 
										   		"State: Virginia State\n\n" +
										   		"Name: Roger Rabbit\n" + 
										   		"Age: 22 years\n" + 
										   		"State: California State\n\n" +
										   		"Name: Wonder Woman\n" + 
										   		"Age: 18 years\n" + 
										   		"State: Montana State\n\n");
		   System.out.println(outStr);
		   
		   fr.close();
		} catch(FileNotFoundException fe) {
			   System.out.println("File not found, dumbass!");
		        }
			}
		}