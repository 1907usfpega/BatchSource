package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {  //<--Singleton Factory

	//private static instance of self
	private static ConnectionFactory cf = new ConnectionFactory();
	
	//private constructor
	private ConnectionFactory() {
		super();
	}
	
	//public static synchronized getter
	public static synchronized ConnectionFactory getInstance() {
		if (cf == null) {
			cf = new ConnectionFactory();
		}
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}//end getConnection()
	
	
	
}//end ConectionFactory class
