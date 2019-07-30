package com.revature.dao;


public interface UserDao {
	void createUser(String u,String f, String l, String p, int a, int em);
	void updateUsers(String f, String l,String p, String u);
	void deleteUser(String u);
}
