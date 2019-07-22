package com.revature.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IO {
	private static final String OUTFILE = "output.txt";
	private static final String INFILE = "input.txt";

	// write method
	public void writeOutputStreamContents(String contents) {
		OutputStream os = null;
		File file = new File(OUTFILE);
		try {
			// false will overwrite, true will append
			os = new FileOutputStream(file, false);
			os.write(contents.getBytes());
		} // end try
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end catch FileNotFoundException
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end catch IOException
		if (os != null) {
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // end catch
		} // end if

	}// end writeOutputStreamContents

	public String readInputStreamContents() {
		InputStream is = null;
		File file = new File(INFILE);
		StringBuilder sb = new StringBuilder();
		try {
			is = new FileInputStream(file);
			int b = 0;
			while ((b = is.read()) != -1) {
				char c = (char) b;
				sb.append(c);
			}
			if (is != null) {
				is.close();
			} // end if
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end catch
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}// end readInputStreamContents
}// end IO
