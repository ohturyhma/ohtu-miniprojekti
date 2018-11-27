/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary;

import org.junit.Before;
import org.junit.Test;
import java.sql.SQLException;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import readingtipslibrary.dao.DaoService;
import readingtipslibrary.dao.Database;

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
    public void blogService() {
        assertTrue(daoService.insertBlog("author", "title", "url", "type", "description"));
        assertFalse(daoService.findAllBlogs().isEmpty());
    }

    @Test
    public void bookService() {
        assertTrue(daoService.insertBook("author", "title", "isbn", "type", "description"));
        assertFalse(daoService.findAllBooks().isEmpty());
    }

    @Test
    public void podcastService() {
        assertTrue(daoService.insertPodcast("podcastName", "title", "description", "type"));
        assertFalse(daoService.findAllPodcasts().isEmpty());
    }

    @Test
    public void videoService() {
        assertTrue(daoService.insertVideo("title", "url", "type", "description"));
        assertFalse(daoService.findAllVideos().isEmpty());
    }

}
