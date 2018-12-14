/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary;

import org.junit.Before;
import org.junit.Test;
import java.sql.SQLException;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import readingtipslibrary.dao.DaoService;
import readingtipslibrary.dao.Database;
import readingtipslibrary.dao.TipDao;
import readingtipslibrary.domain.Tip;

/**
 *
 * Testing service-classes
 */
public class ServiceTest {

    private DaoService daoService;
    private Database database;

    @Before
    public void setup() throws ClassNotFoundException, SQLException {
        database = new Database("jdbc:sqlite:test.db");
        database.init();
        daoService = new DaoService(database);
    }

    @Test
    public void selectRandomTipSelectsATip() throws SQLException {
        Tip tip = Tip.tipFromType("book");
        tip.getField("author").setContent("J.K.Rowlings");
        tip.getField("title").setContent("Philosophers stone");
        tip.getField("isbn").setContent("123-123-123");
        tip.getField("description").setContent("Harry pottah");
        tip.getField("url").setContent("www.PorryHattah.com");
                
        daoService.insert(tip);
        
        Tip tip1 = daoService.selectRandomTip();
        assertEquals(tip.getField("title").getContent(), tip1.getField("title").getContent());
        daoService.deleteAll("book");
        
        //
    }
    
    @Test 
    public void deleteById() throws SQLException {
        
        Tip tip = Tip.tipFromType("book");
        tip.getField("author").setContent("J.K.Rowlings");
        tip.getField("title").setContent("Philosophers stone");
        tip.getField("isbn").setContent("123-123-123");
        tip.getField("description").setContent("Harry pottah");
        tip.getField("url").setContent("www.PorryHattah.com");
                
        daoService.insert(tip);
        List<Tip> list = daoService.findAll("book");
        String i = list.get(0).getField("id").getContent();
        int id = Integer.parseInt(i);
        
        boolean onnistuko = daoService.deleteById("book", id);
        assertEquals(true, onnistuko);
        daoService.deleteAll("book");
    }
    
    @Test 
    public void selectById() throws SQLException {
        
        Tip tip = Tip.tipFromType("book");
        tip.getField("author").setContent("J.K.Rowlings");
        tip.getField("title").setContent("Philosophers stone");
        tip.getField("isbn").setContent("123-123-123");
        tip.getField("description").setContent("Harry pottah");
        tip.getField("url").setContent("www.PorryHattah.com");
                
        daoService.insert(tip);
        List<Tip> list = daoService.findAll("book");
        String i = list.get(0).getField("id").getContent();
        int id = Integer.parseInt(i);
        
        Tip tip1 = daoService.findById("book", id);
        assertEquals(tip.getField("title").getContent(), tip1.getField("title").getContent());
        daoService.deleteAll("book");
    }
    
    @Test 
    public void editById() throws SQLException {
        
        Tip tip = Tip.tipFromType("book");
        tip.getField("author").setContent("J.K.Rowlings");
        tip.getField("title").setContent("Philosophers stone");
        tip.getField("isbn").setContent("123-123-123");
        tip.getField("description").setContent("Harry pottah");
        tip.getField("url").setContent("www.PorryHattah.com");
                
        daoService.insert(tip);
        List<Tip> list = daoService.findAll("book");
        String i = list.get(0).getField("id").getContent();
        int id = Integer.parseInt(i);
        
        daoService.editById("book", id, "author", "K.J.Rowlings");
        Tip tip1 = daoService.findById("book", id);
        assertEquals("K.J.Rowlings", tip1.getField("author").getContent());
        daoService.deleteAll("book");
    }
    
    

}
