package com.revature.bank;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    
    List<T> getAll() throws SQLException;
    
    public void delete(int accountNumber) throws SQLException;
    
    void update(T t) throws SQLException;   
}
     
