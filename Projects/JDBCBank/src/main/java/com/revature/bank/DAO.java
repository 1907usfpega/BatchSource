package com.revature.bank;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    
	
	/**
	 * 
	 * @return
	 */
    List<T> getAll() throws SQLException;
     
    /**
     * 
     * @param t
     */
    //void save(T t);
     
    /**
     * Method used to update an object in the database
     * @param t
     * @param params
     */
    void update(T t);
     
    /**
     * Method to delete an object from the database
     * @param t
     */
    //void delete(T t);
}
