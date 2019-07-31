package db.daoImpl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import db.beans.User;
import db.beans.UserAccount;
import db.dao.Admindao;
import db.util.ConnFactory;

public class AdmindaoImpl implements  Admindao{
public static ConnFactory cf = ConnFactory.getInstance();
   
	 public void deleteUser(String username) throws SQLException {
		   Connection conn = cf.getConnection();
		   // TODO Auto-generated method stub
		    String sql = "Delete From USER1 where username = ?";
		    PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1, username);
		    ps.executeUpdate(); }
	       
	       
	       


   public  void CreateUser(String username,String password ) throws SQLException {
	Connection conn = cf.getConnection();
	String sql = "INSERT INTO USER1 ( username,password )VALUES(?,?)";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, username);
	ps.setString(2, password);
	ps.executeUpdate(); 
}



public static void updateUser(User user) throws SQLException {
	// TODO Auto-generated method stub
	Connection conn = cf.getConnection();
	   String sql ="Update User1 set userid=? where userid=? ";
	   PreparedStatement ps = conn.prepareStatement(sql);
	   ps.setString(1,user.getUsername());
	   ps.setString(2,user.getPassword());
	  
	   ps.executeUpdate();
   }



@Override
public List<UserAccount> listviewUser() throws SQLException {
	// TODO Auto-generated method stub
			List<UserAccount> userList = new ArrayList<UserAccount>(); 
			Connection conn= cf.getConnection();
			// TODO Auto-generated method stub
			Statement stmt= (Statement) conn.createStatement();
			ResultSet rs= ((java.sql.Statement) stmt).executeQuery("SELECT * FROM USER1");
			UserAccount s= null;
			while(rs.next()) {
				s= new UserAccount (rs.getString(1),rs.getInt(2));
				userList.add(s);
				
			}
			return userList;
		}












}









	


















	







