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
import readingtipslibrary.dao.BlogDao;
import readingtipslibrary.dao.BookDao;
import readingtipslibrary.dao.Database;
import readingtipslibrary.dao.PodcastDao;
import readingtipslibrary.dao.VideoDao;
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
    private BlogDao blogD;
    private BookDao bookD;
    private PodcastDao podD;
    private VideoDao videoD;

    @Before
    public void setUp() throws Exception {

        database = new Database("jdbc:sqlite:test.db");
        database.init();
        blogD = new BlogDao(database);
        bookD = new BookDao(database);
        podD = new PodcastDao(database);
        videoD = new VideoDao(database);
    }

    @Test
    public void testDatabase() throws SQLException, ClassNotFoundException {
        Database database = new Database("fake");
        database.init();
    }

    @Test
    public void blogDaoTest() throws SQLException {
        Blogpost blog = new Blogpost("author", "title", "url", "type", "description");
        assertEquals(blog, blogD.insert(blog));
        assertFalse(blogD.findAll().isEmpty());
        blogD.insert(new Blogpost("author2", "title2", "url2", "type2", "description2"));
        blogD.destroyAll();
        assertTrue(blogD.findAll().isEmpty());
    }

    @Test
    public void bookDaoTest() throws SQLException {
        Book book = new Book("author", "title", "isbn", "type", "description");
        assertEquals(book, bookD.insert(book));
        assertFalse(bookD.findAll().isEmpty());
        bookD.insert(new Book("author2", "title2", "isbn2", "type2", "description2"));
        bookD.destroyAll();
        assertTrue(bookD.findAll().isEmpty());
    }

    @Test
    public void podcastDaoTest() throws SQLException {
        Podcast pod = new Podcast("podcastName", "title", "type", "description");
        assertEquals(pod, podD.insert(pod));
        assertFalse(podD.findAll().isEmpty());
        podD.insert(new Podcast("podcastName2", "title2", "type2", "description2"));
        podD.destroyAll();
        assertTrue(podD.findAll().isEmpty());
    }

    @Test
    public void videoDaoTest() throws SQLException {
        Video video = new Video("title", "url", "type", "description");
        assertEquals(video, videoD.insert(video));
        assertFalse(videoD.findAll().isEmpty());
        videoD.insert(new Video("title2", "url2","type2", "description2"));
        videoD.destroyAll();
        assertTrue(videoD.findAll().isEmpty());
    }

}
