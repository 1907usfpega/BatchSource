package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.VideoGame;
import com.revature.util.ConnFactory;

public class VGDaoImpl {
	public static ConnFactory cf= ConnFactory.getInstance();
	
	//get specific
	public VideoGame getVGbyID(int id)throws SQLException{
		VideoGame vg=null;
		Connection con=cf.getConnection();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from videogame where VGID= "+id);
		while(rs.next()) {
			vg=new VideoGame(rs.getInt(1),rs.getString(2),rs.getInt(3));
		}
		return vg;
	}
	public void insertVG(VideoGame vg) throws SQLException{
		String sql="insert into videogame values(?,?,?)";
		Connection con=cf.getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, vg.getId());
		ps.setString(2, vg.getName());
		ps.setInt(3, vg.getMetaScore());
		ps.executeUpdate();
	}
}
