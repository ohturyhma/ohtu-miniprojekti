/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.dao;

import java.util.List;
import readingtipslibrary.domain.Blogpost;
import readingtipslibrary.domain.Tip;

/**
 *
 * @author nroope
 */
public class BlogDao implements Dao<Blogpost>{

    @Override
    public List<Tip> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tip insert(Blogpost t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
