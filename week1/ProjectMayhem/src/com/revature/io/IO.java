package com.revature.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IO {
	private static final String OUTFILE= "out.txt";
	private static final String INFILE= "in.txt";
	
	public void writeOutputStreamContents(String con) {
		OutputStream os=null;
		File file=new File(OUTFILE);
		try {
			os=new FileOutputStream(file,false);
			os.write(con.getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public String readInputStreamContents() {
		InputStream is=null;
		File file= new File(INFILE);
		StringBuilder s=new StringBuilder();
		try {
			is=new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int b=0;
		try {
			while((b=is.read())!=-1) {
				char c=(char)b;
				s.append(c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (is!=null) {
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
