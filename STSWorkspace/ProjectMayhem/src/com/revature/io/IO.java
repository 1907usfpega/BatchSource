package com.revature.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IO 
{
	private static final String outPath = "output.txt";
	private static final String inPath = "input.txt";
	
	public void writeOutputStreamContents(String contents)
	{
		OutputStream output = null;
		File f = new File(outPath);
		//false will override the file, true will append to the end
		try 
		{
			output = new FileOutputStream(f, false);
			output.write(contents.getBytes());
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		if(output != null)
		{
			try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String readStringInputContents()
	{
		InputStream input = null;
		File f = new File(inPath);
		StringBuilder s = new StringBuilder();
		try
		{
			input = new FileInputStream(f);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		int b = 0;
		try {
			while((b=input.read())!=-1)
			{
				char c = (char)b;
				s.append(c);
			}
			if(input != null)
			{
				input.close();
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return s.toString();
	}
}
