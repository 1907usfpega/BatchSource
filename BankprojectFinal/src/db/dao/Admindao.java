package db.dao;

import java.sql.SQLException;
import java.util.List;

import db.beans.User;
import db.beans.UserAccount;

public interface Admindao {
	public abstract List <UserAccount> listviewUser() throws SQLException;
	public abstract void deleteUser(String username ) throws SQLException;
	public abstract void CreateUser(String username ,String password) throws SQLException;


}
