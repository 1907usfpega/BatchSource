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
	
	//write method
	public void writeOutputStreamContents(String contents) {
		OutputStream os = null;
		File file = new File(outFile);
		//false will overwrite, true iwll append
		try {
			os = new FileOutputStream(file, false);
			os.write(contents.getBytes());
		} catch(FileNotFoundException fe) {
			fe.printStackTrace();
		} catch(IOException ie){
			ie.printStackTrace();
		}
		if(os != null) {
		//	os.close();
		}
	}
	public String readInputStreamContents() {
		InputStream is = null;
		File file = new File(inFile);
		StringBuilder s = new StringBuilder();
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		}
		int b = 0;
		try {
			while((b = is.read()) != -1) {
				char c = (char)b;
				s.append(c);
			}
		} catch(IOException ie) {
			ie.printStackTrace();
		}
		if(is != null) {
			try {
				is.close();
			} catch(IOException ie) {
				ie.printStackTrace();
			}
		}
		return s.toString();
	}
	
	
	public IO() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
