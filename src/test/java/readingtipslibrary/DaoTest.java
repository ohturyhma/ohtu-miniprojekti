/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary;

import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import readingtipslibrary.dao.Database;
import readingtipslibrary.domain.Blogpost;
import readingtipslibrary.domain.Book;
import readingtipslibrary.domain.Podcast;
import readingtipslibrary.domain.Video;

/**
 *
 * This is for testing classes that implement Dao-inteface
 */
public class DaoTest {

    private Database database;

    @Before
    public void setUp() throws Exception {

        database = new Database("jdbc:sqlite:test.db");
        database.init();
    }

    @Test
    public void testDatabase() throws SQLException, ClassNotFoundException {
        Database database = new Database("fake");
        database.init();
    }

    @Test
    public void blogDaoTest() throws SQLException {
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
