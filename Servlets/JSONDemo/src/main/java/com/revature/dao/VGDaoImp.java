package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.VideoGame;
import com.revature.util.ConnFactory;

public class VGDaoImp {
	public static ConnFactory banana = ConnFactory.getInstance();
	
	// get specific
	public VideoGame getVGById(int id) throws SQLException {
		VideoGame vg = null;
		Connection conn = banana.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM VIDEOGAME WHERE VGID = " + id);
		while(rs.next()) {
			vg = new VideoGame(rs.getInt(1), rs.getString(2), rs.getInt(3));
		}
		return vg;
	}
	
	// insert row
	public void insertVG(VideoGame vg) throws SQLException {
		Connection conn = banana.getConnection();
		String sql = "INSERT INTO VIDEOGAME VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, vg.getVgID());
		ps.setString(2, vg.getVgName());
		ps.setInt(3, vg.getVgMetaScore());
		ps.executeUpdate();
	}
}
