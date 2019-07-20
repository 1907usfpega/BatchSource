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
	private static final String inFile = "inputData.txt";

	// write method
	public void writeOutputStreamContents(String contents) {
		OutputStream outstream = null;
		File file = new File(outFile);
		// false will override, true will append
		try {
			outstream = new FileOutputStream(file, true);
			outstream.write(contents.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (outstream != null) {
			try {
				outstream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public String readInputStreamContents() {
	InputStream is = null;
	File file = new File(inFile);
	StringBuilder s = new StringBuilder();
	try {
		is = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int b;
	try {
		while((b = is.read())!=-1) {
			char c = (char)b;
			s.append(c);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(is!=null) {
		try {
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return s.toString();
	}
}
