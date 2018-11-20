/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingtipslibrary;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import readingtipslibrary.domain.Blogpost;
import readingtipslibrary.domain.Book;
import readingtipslibrary.domain.Podcast;
import readingtipslibrary.domain.Video;

/**
 *
 * Testing classes that implement Tip-interface
 */
public class TipTest {

    private Book book;
    private Blogpost blog;
    private Podcast pod;
    private Video video;

    @Before
    public void setup() {
        book = new Book("author", "title", "isbn", "type");
        blog = new Blogpost("author", "title", "url", "type");
        pod = new Podcast("podcastName", "title", "description", "type");
        video = new Video("title", "url", "type");
    }

    @Test
    public void bookToString() {
        assertEquals("author, title, isbn, type", book.toString());
    }

    @Test
    public void blogpostToString() {
        assertEquals("author, title, url, type", blog.toString());
    }

    @Test
    public void podcastToString() {
        assertEquals("podcastName, title, description, type", pod.toString());
    }

    @Test
    public void videoToString() {
        assertEquals("title, url, type", video.toString());
    }
}
