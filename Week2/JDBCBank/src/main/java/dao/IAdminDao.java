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
	
	Admin getAdmin(int id) throws SQLException;
}
