package com.revature.bank;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
	
	//Private static instance of self
		private static ConnFactory cf = new ConnFactory();
		
		//Private Constructor
		private ConnFactory() {
			
		}
		
		//public synchronized Getter method (thread safe)
		public static synchronized ConnFactory getInstance() {
			if(cf == null) {
				cf = new ConnFactory();
			}
			return cf;
		}
		
		public Connection getConnection() {
			Connection conn = null;
			Properties prop = new Properties();
			try {
				prop.load(new FileReader("database.properties"));
				Class.forName(prop.getProperty("driver"));
				conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;	
		}
}
