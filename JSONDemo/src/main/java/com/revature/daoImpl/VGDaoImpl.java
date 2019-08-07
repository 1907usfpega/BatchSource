package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.VideoGame;
import com.revature.util.ConnFactory;

public class VGDaoImpl {
	public static ConnFactory banana = ConnFactory.getInstance();
	
	//get specific video game 
	public VideoGame getVGbyID(int ID) throws SQLException {
		VideoGame vg = null;
		Connection conn = banana.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from videoGame where vgID = "+ID);
		while(rs.next()) {
			vg = new VideoGame(rs.getInt(1),rs.getString(2),rs.getInt(3));
		}
		return vg;
	}//end getVGbyID
	
	//insert row
	public void insertVG(VideoGame vg) throws SQLException{
		String sql = "insert into videogame values(?,?,?)";
		Connection conn = banana.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, vg.getVgID());
		ps.setString(2, vg.getVgName());
		ps.setInt(3, vg.getVgMetaScore());
		ps.executeUpdate();
	}//end insertVG
	
	

}//end VGDaoImpl
