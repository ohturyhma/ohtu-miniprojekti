/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary;

import java.sql.SQLException;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import readingtipslibrary.dao.Database;
import readingtipslibrary.dao.TipDao;
import readingtipslibrary.domain.Blogpost;
import readingtipslibrary.domain.Book;
import readingtipslibrary.domain.Podcast;
import readingtipslibrary.domain.Tip;
import readingtipslibrary.domain.Video;

/**
 *
 * This is for testing classes that implement Dao-inteface
 */
public class DaoTest {

    private Database database;
    private TipDao tipDao;

    @Before
    public void setUp() throws Exception {

        database = new Database("jdbc:sqlite:test.db");
        database.init();
        tipDao = new TipDao(database);
    }

    @Test
    public void testDatabase() throws SQLException, ClassNotFoundException {
        Database database = new Database("fake");
        database.init();
    }

    @Test
    public void findByNameTestReturnsCorrectBook() throws SQLException {
        Tip tip = Tip.tipFromType("book");
        tip.getField("author").setContent("J.K.Rowlings");
        tip.getField("title").setContent("Philosophers stone");
        tip.getField("isbn").setContent("123-123-123");
        tip.getField("description").setContent("Harry pottah");
        tip.getField("url").setContent("www.PorryHattah.com");
        
        Tip tip1 = Tip.tipFromType("book");
        tip1.getField("author").setContent("J.K.Rowlings");
        tip1.getField("title").setContent("Harry pottah");
        tip1.getField("isbn").setContent("123-123-123");
        tip1.getField("description").setContent("Harry pottah");
        tip1.getField("url").setContent("www.PorryHattah.com");
        
        tipDao.insert(tip);
        tipDao.insert(tip1);
        
        List<Tip> list = tipDao.findByName("Phi", "book");
        assertEquals(tip.getField("title").getContent(), list.get(0).getField("title").getContent());
        assertEquals(1, list.size());
        tipDao.deleteAll("book");
        
        //
    }

    @Test
    public void bookDaoTest() throws SQLException {
        //
    }

    @Test
    public void podcastDaoTest() throws SQLException {
        //
    }

    @Test
    public void videoDaoTest() throws SQLException {
        //
    }

}
