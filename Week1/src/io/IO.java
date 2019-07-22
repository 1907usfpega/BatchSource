package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IO {
	
	private static final String outFile = "output.txt";
	private static final String inFile = "input.txt";

	//write method
	public void writeOutputStringContents(String contents) {
		
		OutputStream os = null;
		File file = new File(outFile);
		
		//false will overwrite, true will append
		try {
			os = new FileOutputStream(file, false);
			os.write(contents.getBytes()); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
				e.printStackTrace();
		}
		
		if(os != null) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}//end writeOutput()
	
	
	public String readInputStreamContents() {
		
		InputStream is = null;
		File file = new File(inFile);
		
		StringBuilder s = new StringBuilder();
		
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int b = 0;
		try {
			while((b = is.read()) != -1) {
				char c = (char)b;
				s.append(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return s.toString();
		
	}//end readInput()
	
}//end IO class
