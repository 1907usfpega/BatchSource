package com.revature.dao;



import java.sql.SQLException;

import com.revature.admin.Admin;




public interface AdminDao {
	
	Admin getAdmin(int id) throws SQLException;
}
