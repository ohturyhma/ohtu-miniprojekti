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
 *
 * @author strajama
 */
public interface Dao<T> {
    
    public List<Tip> findAll() throws SQLException;
    public Tip insert(T t) throws SQLException;
    
}
