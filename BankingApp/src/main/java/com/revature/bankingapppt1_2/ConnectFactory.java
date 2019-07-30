package com.revature.bankingapppt1_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectFactory {
	
	private static ConnectFactory cf = new ConnectFactory();
	public static synchronized ConnectFactory getInstance() {
		if(cf == null) {
			cf = new ConnectFactory();
			
		}
		return cf;
	}
	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(
					prop.getProperty("url"), 
					prop.getProperty("user"), 
					prop.getProperty("password"));
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		return conn;
	}

}
