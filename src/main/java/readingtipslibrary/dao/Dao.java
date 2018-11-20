/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.dao;

import java.sql.SQLException;
import java.util.List;
import readingtipslibrary.domain.Tip;

/**
 * Interface for the data access objects
 * @author strajama
 */
public interface Dao<T> {
    /**
     * Finds the tips in the database
     * @return list of the tips of the type Type in a database
     * @throws SQLException 
     */
    public List<Tip> findAll() throws SQLException;
    /**
     * Inserts a tip into the database
     * @param t the tip to be added to the database
     * @return the inserted tip
     * @throws SQLException 
     */
    public Tip insert(T t) throws SQLException;
    
}
