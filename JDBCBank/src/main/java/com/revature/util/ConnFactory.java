package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
	
	//private static instance of self
		private static ConnFactory cf = new ConnFactory();
		
		//private constructor
		private ConnFactory()
		{
			super();
		}
		
		//synchronized "getter" method
		public static synchronized ConnFactory getInstance()
		{
			if(cf == null)
			{
				cf = new ConnFactory();
			}
			return cf;
		}
		
		
		//FileReader would be useful for the BankApp project.
		public Connection getConnection()
		{
			Connection conn = null;
			Properties prop = new Properties();
			//TryCatch for literally everything. :D
			try {
				prop.load(new FileReader("database.properties"));
				Class.forName(prop.getProperty("driver"));
				conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
