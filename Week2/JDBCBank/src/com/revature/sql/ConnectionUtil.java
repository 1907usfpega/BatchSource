//@JustinHua

package com.revature.sql;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

		public static Connection getConnection() throws SQLException, IOException {
			Properties prop = new Properties();
			InputStream in = new FileInputStream();
			prop.load(in);
			String url = prop.getProperty("URL");
			String username = prop.getProperty("Username");
			String password = prop.getProperty("Password");
			return DriverManager.getConnection(url, username, password);
		}
	
}