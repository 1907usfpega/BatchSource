/**
 * 
 */
package dao;

import java.sql.SQLException;

import admin.Admin;


/**
 * @author MajorKey
 *
 */
public interface IAdminDao {
	
	//plan for only one admin in the db
	Admin getCurrentAdmin() throws SQLException;
	//use sequence.currval to select current admin
	Admin getAdmin(int id) throws SQLException;
	void updateAdmin(String firstname, String lastname) throws SQLException;
}
