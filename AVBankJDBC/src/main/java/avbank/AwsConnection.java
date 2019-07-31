package avbank;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AwsConnection {
	
	private static AwsConnection aws = new AwsConnection();

	private AwsConnection() {
		super();
	}

	public static synchronized AwsConnection getInstance() {
		if(aws==null) {
			aws=new AwsConnection();
			
		}
		return aws;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		/*
		 * Connection conn=null; Properties prop= new Properties(); try { prop.load(new
		 * FileReader("dbConn.properties")); // LOAD } catch (FileNotFoundException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); } try {
		 * Class.forName(prop.getProperty("driver")); // SET CLASS NAME } catch
		 * (ClassNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } 
		 */
		 try {
			 //conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@avrev.crpmrsiojerx.us-east-1.rds.amazonaws.com:1521:ORCLAV", "jdbcUser", "p4ssw0rd");
			// LOG IN
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
