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
import readingtipslibrary.dao.BlogService;
import readingtipslibrary.dao.BookService;
import readingtipslibrary.dao.Database;
import readingtipslibrary.dao.PodcastService;
import readingtipslibrary.dao.VideoService;

/**
 *
 * Testing service-classes
 */
public class ServiceTest {

    private BlogService blogS;
    private BookService bookS;
    private PodcastService podS;
    private VideoService videoS;
    private Database database;

    @Before
    public void setup() throws ClassNotFoundException, SQLException {
        database = new Database("jdbc:sqlite:test.db");
        database.init();
        blogS = new BlogService(database);
        bookS = new BookService(database);
        podS = new PodcastService(database);
        videoS = new VideoService(database);
    }

    @Test
    public void blogService() {
        assertTrue(blogS.insertBlog("author", "title", "url", "type"));
        assertFalse(blogS.findAll().isEmpty());
    }

    @Test
    public void bookService() {
        assertTrue(bookS.insertBook("author", "title", "isbn", "type"));
        assertFalse(bookS.findAll().isEmpty());
    }

    @Test
    public void podcastService() {
        assertTrue(podS.insertPodcast("podcastName", "title", "description", "type"));
        assertFalse(podS.findAll().isEmpty());
    }

    @Test
    public void videoService() {
        assertTrue(videoS.insertVideo("title", "url", "type"));
        assertFalse(videoS.findAll().isEmpty());
    }

}
