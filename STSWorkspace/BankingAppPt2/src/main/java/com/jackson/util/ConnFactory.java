package com.jackson.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.jackson.util.ConnFactory;

public class ConnFactory 
{
	//private static instance of itself
		private static ConnFactory cf = new ConnFactory();
		
		private ConnFactory()
		{
			
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
		
		public Connection getConnection()
		{
			Connection conn = null;
			Properties prop = new Properties();
			try 
			{
				prop.load(new FileReader("database.properties"));
				Class.forName(prop.getProperty("driver"));
				conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			return conn;
		}
}
