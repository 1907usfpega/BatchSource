package com.revature.io;

public class IO {
	//2ns step
	private static final String outFile="output.txt"
	private static final String inFile="input.txt"

	//write method 1 step
	public void writeOutputStreamContents(String contents) {
		OutputStream os=null;
		File file= new File(outFile);
		//false will overwrite, true will append
		
		
		try {
			os- new FileOutputStream(file,false);// this can be true or false 
			os.write(contents.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			}
		if(os!=null) {
			try {
				os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		public String read InputStreamContents() {
			InputStream is= null;
			File file= new File(inFile);
			StringBuilder s= new StringBuilder();
			is= new FileInputStream(file);
			catch (FileNotFoundException e) {
				e.printStackTrace();
				}
			int b=0;
			while((b=is.read()) !=-1) {
				char c= (char)b;
				s.append(c);
			} catch (IOException e) {
				e.printStackTrace();
				}
			if(is!=null) {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
				}
			
		}
		return 
		
		os= new FileOutputStream(file,false);
		
		
		
	}
}
