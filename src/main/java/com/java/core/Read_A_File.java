package com.java.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Read_A_File {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		 BufferedReader reader = null;
         try{
             reader = new BufferedReader(new FileReader("\\Users\\johnm\\OneDrive\\Desktop\\Data.txt"));
             String line;
             while((line = reader.readLine()) != null){
                 String[] data = line.split(":");
                 System.out.println("Name: "+data[0]+" "+data[1]);
                 System.out.println("Age: "+ data[2]+" years");
                 System.out.println("State: "+ data[3]+" State");
                 System.out.println("\n");
             }
         }catch(IOException ex){
             ex.printStackTrace();
         }finally{
             if(reader != null){
                 reader.close();
             }
         }

	}

}
