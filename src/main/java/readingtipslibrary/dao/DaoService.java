/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import readingtipslibrary.domain.Tip;

/**
 *
 * @author Vertti
 */
public class DaoService {

    private TipDao tipDao;

    public DaoService(Database database) {
        this.tipDao = new TipDao(database);
    }

    public boolean insert(Tip tip) {
        try {
            tipDao.insert(tip);
        } catch (SQLException e) {
            return false;
        }

        return true;
    }
    
    public List<Tip> findAll(String type) {
        List<Tip> tips = new ArrayList<>();
        
        try {
            tips = tipDao.findAll(type);
        } catch (SQLException e) {
            return tips;
        }

        return tips;

    }
    
    public boolean deleteAll(String type) {
        try {
            tipDao.deleteAll(type);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
