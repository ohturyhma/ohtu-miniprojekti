/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.dao;

import java.sql.SQLException;
import java.util.List;
import readingtipslibrary.domain.Podcast;
import readingtipslibrary.domain.Tip;

/**
 *
 * @author nroope
 */
public class PodcastDao implements Dao<Podcast>{

    @Override
    public List<Tip> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tip insert(Podcast t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
