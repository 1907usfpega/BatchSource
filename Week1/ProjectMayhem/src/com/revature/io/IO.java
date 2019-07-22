package com.revature.io;

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

	// write method
	public void writeOutputStreamContents(String contents) {
		OutputStream os = null;
		File file = new File(outFile);
		try {
			os = new FileOutputStream(file, false);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// false will overwrite, true will append
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public String readInputStreamContents() {
			InputStream is= null;
			File file = new File(inFile);
			StringBuilder s= new StringBuilder();
			try {
				is=new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int b = 0;
			try {
				while (b=is.read()!=-1) {
					
				}
					
			}
	}

}
